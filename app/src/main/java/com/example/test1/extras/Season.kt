package com.example.test1.extras

// Nuestro Episodio
data class Season(
    val id: Int?,
    var id_season: Int,
    var season: Int,
    var episodes: ArrayList<Episode>,
) {
    fun toMap(): MutableMap<String, Any> {
        return mutableMapOf(
            "id_season" to this.id_season,
            "season" to this.season,
            "episodes" to this.episodes
        ) // Fin del Mutable Map
    }

}


