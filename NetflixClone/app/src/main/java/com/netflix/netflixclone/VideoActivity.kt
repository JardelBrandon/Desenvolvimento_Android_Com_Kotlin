package com.netflix.netflixclone

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import kotlinx.android.synthetic.main.activity_video.*

class VideoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)
        
        var videoUrl = Uri.parse("https://firebasestorage.googleapis.com/v0/b/netflix-clone-7a50e.appspot.com/o/Video%2FTHE%20WITCHER%20_%20TRAILER%20FINAL%20_%20NETFLIX.mp4?alt=media&token=b64695cc-dbf3-45ac-90a0-97771dc29829")

        val decordview = window.decorView
        val opcoes = View.SYSTEM_UI_FLAG_FULLSCREEN
        decordview.systemUiVisibility = opcoes

        video.setMediaController(MediaController(this))
        video.setVideoURI(videoUrl)
        video.requestFocus()
    }
}
