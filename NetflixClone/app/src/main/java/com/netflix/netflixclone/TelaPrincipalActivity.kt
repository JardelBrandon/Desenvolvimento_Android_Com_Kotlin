package com.netflix.netflixclone

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.firebase.auth.FirebaseAuth
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_tela_principal.*

class TelaPrincipalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_principal)

        val imagens = Uri.parse("https://firebasestorage.googleapis.com/v0/b/netflix-clone-7a50e.appspot.com/o/Imagens%2Fwitcher.png?alt=media&token=0a039f8c-825b-4074-98ed-e50fc142f282")

        Picasso.get().load(imagens).fit().placeholder(R.drawable.gif).into(serie1)
        Picasso.get().load(imagens).fit().placeholder(R.drawable.gif).into(serie2)
        Picasso.get().load(imagens).fit().placeholder(R.drawable.gif).into(serie3)
        Picasso.get().load(imagens).fit().placeholder(R.drawable.gif).into(serie4)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflate = menuInflater
        inflate.inflate(R.menu.menu_tela_principal, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item!!.itemId) {
            R.id.item_sair -> {
                FirebaseAuth.getInstance().signOut()
                voltaParaFormLogin()
                true
            }
            else ->   super.onOptionsItemSelected(item)
        }
    }

    private fun voltaParaFormLogin() {

        var intent = Intent(this, FormLoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}
