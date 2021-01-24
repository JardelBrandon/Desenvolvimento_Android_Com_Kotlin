package com.app.spotifyclone

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.spotifyclone.Fragments.HomeFragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detalhes.*

class DetalhesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes)

        intent.extras?.let {

            var album: String? = it.getString("album")
            var titulos: String? = it.getString("titulos")

            Picasso.get().load(album).into(detalhe_album)
            titulo_album.setText(titulos)

        }

        window.statusBarColor = Color.LTGRAY
        toolbar.setNavigationIcon(getDrawable(R.drawable.ic_arrow_back))
        toolbar.title = null
        toolbar.setNavigationOnClickListener {

            var intent = Intent(this, HomeFragment::class.java)
            startActivities(intent)
            finish()

        }
    }

    private fun startActivities(intent: Intent) {

    }
}
