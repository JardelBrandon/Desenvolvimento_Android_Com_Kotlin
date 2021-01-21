package com.loja.lojavirtual.Fragments

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import com.google.firebase.storage.FirebaseStorage
import com.loja.lojavirtual.R
import kotlinx.android.synthetic.main.activity_cadastro_produtos.*
import java.util.*

class CadastroProdutosActivity : AppCompatActivity() {

    private var selecionarUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_produtos)

        bt_selecionar_foto.setOnClickListener {

            selecionarFotoDaGaleria()

        }

        bt_cadastrar_produto.setOnClickListener {

            salvarDadosNoFirebase()

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 0) {

            selecionarUri = data?.data

            val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, selecionarUri)
            foto_produto.setImageBitmap(bitmap)
            bt_selecionar_foto.alpha = 0f

        }
    }

    private fun selecionarFotoDaGaleria() {

        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, 0)

    }

    private fun salvarDadosNoFirebase() {

        val nomeArquivo = UUID.randomUUID().toString()
        val referencia = FirebaseStorage.getInstance().getReference(
            "/imagens/${nomeArquivo}"
        )
        selecionarUri?.let {

            referencia.putFile(it)
                .addOnSuccessListener {
                    referencia.downloadUrl.addOnSuccessListener {
                        
                    }
                }

        }

    }

}
