package com.loja.lojavirtual.Fragments

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import com.loja.lojavirtual.R
import kotlinx.android.synthetic.main.activity_cadastro_produtos.*

class CadastroProdutosActivity : AppCompatActivity() {

    private var selecionarUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_produtos)

        bt_selecionar_foto.setOnClickListener {

            selecionarFotoDaGaleria()

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
}
