package com.loja.lojavirtual.Form

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.loja.lojavirtual.R

class FormCadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_cadastro)
        supportActionBar!!.hide()

    }
}
