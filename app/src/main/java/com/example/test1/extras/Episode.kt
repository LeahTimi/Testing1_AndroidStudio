package com.example.test1.extras

// Nuestro Episodio
data class Episode(
    val id: Int?,
    var id_episode: Int,
    var nombre: String,
    var descripcion: String,
    var episode: Int,
    var season: Int,
    var videoUrl: String
) {
    fun toMap(): MutableMap<String, Any> {
        return mutableMapOf(
            "id_episode" to this.id_episode,
            "nombre" to this.nombre,
            "descripcion" to this.descripcion,
            "episode" to this.episode,
            "season" to this.season,
            "videoUrl" to this.videoUrl
        ) // Fin del Mutable Map
    }

    override fun toString():String{
        val text = String.format("%02dx%02d: %s",season,episode,nombre)
        return text
    }
}


