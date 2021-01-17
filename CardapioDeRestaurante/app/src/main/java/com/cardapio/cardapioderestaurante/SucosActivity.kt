package com.cardapio.cardapioderestaurante

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.toolbar.*

class SucosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sucos)
        supportActionBar!!.hide()

        toolbar.title = "Sucos"
        toolbar.setNavigationIcon(getDrawable(R.drawable.ic_voltar))
        toolbar.setNavigationOnClickListener {

            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
