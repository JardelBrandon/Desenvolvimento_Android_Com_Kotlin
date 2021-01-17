package com.cardapio.cardapioderestaurante

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()

        var sucos = sucos
        var lanches = lanches
        var sobremesas = sobremesas
        var pratosPrincipais = pratosPrincipais

        sucos.setOnClickListener{

            var intent = Intent(this, SucosActivity::class.java)
            startActivity(intent)
            finish()
        }

        lanches.setOnClickListener{

            var intent = Intent(this, LanchesActivity::class.java)
            startActivity(intent)
            finish()
        }

        sobremesas.setOnClickListener {
            var intent = Intent(this, SobremesasActivity::class.java)
            startActivity(intent)
            finish()
        }

        pratosPrincipais.setOnClickListener {
            var intent = Intent(this, PratosPrincipaisActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
