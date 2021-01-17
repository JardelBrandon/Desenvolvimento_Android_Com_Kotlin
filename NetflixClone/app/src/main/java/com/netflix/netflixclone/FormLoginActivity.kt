package com.netflix.netflixclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_form_login.*

class FormLoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_login)

        var textoCadastrar = text_cadastrar

        textoCadastrar.setOnClickListener {
            abrirTelaDeCadastro()
        }
    }

    private fun abrirTelaDeCadastro() {
        var intent = Intent(this, FormCadastroActivity::class.java)
        startActivity(intent)
    }

}
