package com.youtube.youtubeclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.youtube.youtubeclone.Adapter.VideosAdapter
import com.youtube.youtubeclone.Model.addVideos
import com.youtube.youtubeclone.OnClick.OnItemClickListener
import com.youtube.youtubeclone.OnClick.addOnItemClickListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_videos.adapter = VideosAdapter(addVideos())
        recycler_videos.layoutManager = LinearLayoutManager(this)

        recycler_videos.addOnItemClickListener(object: OnItemClickListener {

            override fun onItemClicked(position: Int, view: View) {
                when {
                    position == 0 -> Toast.makeText(applicationContext,"Abrir o Vídeo 1", Toast.LENGTH_SHORT).show()
                    position == 1 -> Toast.makeText(applicationContext,"Abrir o Vídeo 2", Toast.LENGTH_SHORT).show()
                    position == 2 -> Toast.makeText(applicationContext,"Abrir o Vídeo 3", Toast.LENGTH_SHORT).show()
                    position == 3 -> Toast.makeText(applicationContext,"Abrir o Vídeo 4", Toast.LENGTH_SHORT).show()
                }
            }

        })

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflate = menuInflater
        inflate.inflate((R.menu.menu_youtube), menu)
        return true

    }
}
