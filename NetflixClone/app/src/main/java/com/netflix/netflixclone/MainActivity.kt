package com.netflix.netflixclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()

        Handler().postDelayed({abrirTelaDeLogin()}, 3000)

    }

    private fun abrirTelaDeLogin() {

        var intent = Intent(this, FormLoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}
