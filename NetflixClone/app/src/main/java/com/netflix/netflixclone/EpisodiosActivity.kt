package com.netflix.netflixclone

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_episodios.*

class EpisodiosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_episodios)

        val imagemDoVideo = Uri.parse("https://firebasestorage.googleapis.com/v0/b/netflix-clone-7a50e.appspot.com/o/Imagens%2Fvideo.jpg?alt=media&token=e2a7c4b4-f11b-4301-8265-301b831f1d7b")
        Picasso.get().load(imagemDoVideo).placeholder(R.drawable.gif).into(imagemVideo)

        playVideo.setOnClickListener {
            var intent = Intent(this, VideoActivity::class.java)
            startActivity(intent)
        }
    }
}
