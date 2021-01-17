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

        sucos.setOnClickListener{

            var intent = Intent(this, SucosActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}
