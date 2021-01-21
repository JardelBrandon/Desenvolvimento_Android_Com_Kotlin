package com.loja.lojavirtual.Fragments

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.afollestad.materialdialogs.MaterialDialog
import com.google.android.material.dialog.MaterialDialogs
import com.google.firebase.firestore.FirebaseFirestore
import com.loja.lojavirtual.Model.Dados

import com.loja.lojavirtual.R
import com.squareup.picasso.Picasso
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.fragment_produtos.*
import kotlinx.android.synthetic.main.lista_produtos.view.*
import kotlinx.android.synthetic.main.pagamento.*
import kotlinx.android.synthetic.main.pagamento.view.*

/**
 * A simple [Fragment] subclass.
 */
class ProdutosFragment : Fragment() {

    private lateinit var adapter: GroupAdapter<ViewHolder>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_produtos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        adapter = GroupAdapter()
        recycler_produtos.adapter = adapter
        adapter.setOnItemClickListener{item, view ->

            val dialogView = LayoutInflater.from(context).inflate(R.layout.pagamento, null)
            val builder = AlertDialog.Builder(context)
                .setView(dialogView)
                .setTitle("Formas de Pagamento")

            val mAlertDialog = builder.show()
            mAlertDialog.bt_pagar.setOnClickListener {

                mAlertDialog.dismiss()
                val pagamento = mAlertDialog.form_pagamento.text.toString()

                if (pagamento == "249,99") {

                    MaterialDialog.Builder(this!!.context!!)
                        .title("Pagamento Concluído")
                        .content("Obrigado pela compra! volte sempre.")
                        .show()

                } else {

                    Toast.makeText(context, "Pagamento Recusado", Toast.LENGTH_SHORT).show()

                }

            }

        }

        buscarProdutos()

    }

    private inner class ProdutosItem(internal val adProdutos: Dados): Item<ViewHolder>() {

        override fun getLayout(): Int {

            return R.layout.lista_produtos

        }

        override fun bind(viewHolder: ViewHolder, position: Int) {

            viewHolder.itemView.nome_produto.text = adProdutos.nome
            viewHolder.itemView.preco_produto.text = adProdutos.preco
            Picasso.get().load(adProdutos.uid).into(viewHolder.itemView.foto_produto)

        }
    }

    private fun buscarProdutos() {

        FirebaseFirestore.getInstance().collection("Produtos")
            .addSnapshotListener { snapshot, exception ->
                exception?.let {
                    return@addSnapshotListener
                }

                snapshot?.let {

                    for(doc in snapshot) {
                        val produtos = doc.toObject(Dados::class.java)
                        adapter.add(ProdutosItem(produtos))
                    }

                }
            }

    }

}
