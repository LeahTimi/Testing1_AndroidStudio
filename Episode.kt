package timoneda.lemon.a1proyecto_gachapony.model

// Nuestro Episodio
data class Episode(
    val id: Int?,
    var id_episode: Int,
    var nombre: String,
    var descripcion: String,
    var episode: Int,
    var season: Int,
) {
    fun toMap(): MutableMap<String, Any> {
        return mutableMapOf(
            "id_episode" to this.id_episode,
            "nombre" to this.nombre,
            "descripcion" to this.descripcion,
            "episode" to this.episode,
            "season" to this.season
        ) // Fin del Mutable Map
    }

    override fun toString():String{
        return String.format("%dx%0d: %s",season,episode,nombre)
    }
}


