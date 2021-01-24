package com.app.spotifyclone.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.spotifyclone.DetalhesActivity
import com.app.spotifyclone.Model.*

import com.app.spotifyclone.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.album_item.view.*
import kotlinx.android.synthetic.main.categoria_item.view.*
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    private lateinit var categoriaAdapter: CategoriaAdapter

    companion object {
        fun newInstance(): HomeFragment {
            val fragmentHome = HomeFragment()
            val argumentos = Bundle()
            fragmentHome.arguments = argumentos
            return fragmentHome
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val categorias = arrayListOf<Categoria>()
        categoriaAdapter = CategoriaAdapter(categorias)
        recycler_view_categorias.adapter = categoriaAdapter
        recycler_view_categorias.layoutManager = LinearLayoutManager(context)
        retrofit().create(SpotifyAPI::class.java)
            .listCategorias()
            .enqueue(object : Callback<Categorias> {

                override fun onFailure(call: Call<Categorias>, t: Throwable) {
                    Toast.makeText(context, "Erro no servidor!", Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<Categorias>, response: Response<Categorias>) {
                    if (response.isSuccessful) {
                        response.body()?.let {

                            categoriaAdapter.categorias.clear()
                            categoriaAdapter.categorias.addAll(it.categorias)
                            categoriaAdapter.notifyDataSetChanged()

                        }
                    }
                }

            })

    }

    private inner class CategoriaAdapter(internal val categorias: MutableList<Categoria>): RecyclerView.Adapter<CategoriaHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriaHolder {
            return CategoriaHolder(layoutInflater.inflate(R.layout.categoria_item, parent, false))
        }

        override fun getItemCount(): Int = categorias.size

        override fun onBindViewHolder(holder: CategoriaHolder, position: Int) {

            val categoria = categorias[position]
            holder.bind(categoria)

        }
    }

    private inner class CategoriaHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bind(categoria: Categoria) {
            itemView.text_titulo.text = categoria.titulo
            itemView.recycler_albuns.adapter = AlbunsAdapter(categoria.albuns) { album ->

                val intent = Intent(context, DetalhesActivity::class.java)
                startActivity(intent)

            }
            itemView.recycler_albuns.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        }

    }

    //---------------------------------------------------------------------------------------------------------------

    private inner class AlbunsAdapter(private val albuns: List<Album>, private val listener: ((Album) -> Unit)?): RecyclerView.Adapter<AlbunsHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbunsHolder = AlbunsHolder(
            layoutInflater.inflate(R.layout.album_item, parent, false), listener
        )

        override fun getItemCount(): Int = albuns.size

        override fun onBindViewHolder(holder: AlbunsHolder, position: Int) {
            val album = albuns[position]
            holder.bind(album)
        }
    }

    private inner class AlbunsHolder(itemView: View, val onClick: ((Album) -> Unit)?): RecyclerView.ViewHolder(itemView) {
            fun bind(album: Album) {
                Picasso.get().load(album.album).placeholder(R.drawable.placeholder).fit().into(itemView.image_album)
                itemView.image_album.setOnClickListener {
                    onClick?.invoke(album)
                }
            }
    }
}
