package com.youtube.youtubeclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.recyclerview.widget.LinearLayoutManager
import com.youtube.youtubeclone.Adapter.VideosAdapter
import com.youtube.youtubeclone.Model.addVideos
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_videos.adapter = VideosAdapter(addVideos())
        recycler_videos.layoutManager = LinearLayoutManager(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflate = menuInflater
        inflate.inflate((R.menu.menu_youtube), menu)

        return true
    }
}
