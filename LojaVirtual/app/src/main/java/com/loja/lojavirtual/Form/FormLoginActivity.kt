package com.loja.lojavirtual.Form

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.loja.lojavirtual.R
import kotlinx.android.synthetic.main.activity_form_login.*

class FormLoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_login)
        supportActionBar!!.hide()

        text_tela_cadastro.setOnClickListener {
            var intent = Intent(this, FormCadastroActivity::class.java)
            startActivity(intent)
        }
    }
}
