package com.youtube.youtubeclone.Model

import com.youtube.youtubeclone.R

data class Videos (

    val thumb: Int,
    val foto: Int,
    val tempoVideo: String,
    val titulo: String,
    val visualizacao: String

)

class VideosBuilder {

    var thumb: Int = 0
    var foto: Int = 0
    var tempoVideo: String = ""
    var titulo: String = ""
    var visualizacao: String =""

    fun build(): Videos = Videos(thumb, foto, tempoVideo, titulo, visualizacao)
}

fun videos(block: VideosBuilder.() -> Unit): Videos = VideosBuilder().apply(block).build()

fun addVideos(): MutableList<Videos> = mutableListOf(

    videos {
        thumb = R.drawable.minecraft
        foto = R.drawable.canal1
        tempoVideo = "25:00"
        titulo = "Minecraft: O início de Gameplay"
        visualizacao = "Minecraft 56 mil visualizações - 8 meses"
    },

    videos {
        thumb = R.drawable.receitas
        foto = R.drawable.canal2
        tempoVideo = "18:00"
        titulo = "Saladas de Macarrão | Receitas Prontas"
        visualizacao = "Receitas 20 mil visualizações - 2 meses"
    },

    videos {
        thumb = R.drawable.viagens
        foto = R.drawable.canal3
        tempoVideo = "12:00"
        titulo = "Conheça as Ilhas Maldivas"
        visualizacao = "ViagensVR 1 mi visualizações - 1 ano"
    },

    videos {
        thumb = R.drawable.animes
        foto = R.drawable.canal4
        tempoVideo = "30:00"
        titulo = "Dragon Ball Super - Episódio 50"
        visualizacao = "Animes 98 mil visualizações - 1 mês"
    }

)
