package com.ebook.ebookdigital

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var botao_leitura = bt_leitura

        botao_leitura.setOnClickListener {

            var intent = Intent(this, LeituraDoEbookActivity::class.java)
            startActivity(intent)
        }
    }
}
