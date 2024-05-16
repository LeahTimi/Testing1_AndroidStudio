
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import timoneda.lemon.a1proyecto_gachapony.model.Episode
import timoneda.lemon.a1proyecto_gachapony.result.interfaces.iscreenWithBottomAndTopBar

class SerieScreenImp : iscreenWithBottomAndTopBar {

    @Composable
    @Preview
    fun serieScreen(){
        serieScaffold()
    }
    val arrayEpisodesS1 = ArrayList<Episode>()
    val arrayEpisodesS2 = ArrayList<Episode>()
    val arrayEpisodesS3 = ArrayList<Episode>()

    fun testArray1(){
        for (num in 1..3){
            val episode = Episode(id = null ,id_episode = 7,nombre = "Episodio ejemplo", episode = num, descripcion = "des des", season = 1)
            arrayEpisodesS1.add(episode)
        }
    }
    fun testArray2(){
        for (num in 1..3){
            val episode = Episode(id = null ,id_episode = 7,nombre = "Episodio ejemplo", episode = num, descripcion = "des des", season = 2)
            arrayEpisodesS2.add(episode)
        }
    }
    fun testArray3(){
        for (num in 1..3){
            val episode = Episode(id = null ,id_episode = 7,nombre = "Episodio ejemplo", episode = num, descripcion = "des des", season = 3)
            arrayEpisodesS3.add(episode)
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun serieScaffold(){
        Scaffold(
            topBar = { predefiniedTopBar("Glosario",) },
            bottomBar = {  },
            content = { padding -> serieContent(padding = padding) }
        ) // Scaffold
    }

    @Composable
    fun serieContent(padding: PaddingValues){
        Column (modifier = Modifier
            .fillMaxSize()
            .padding(padding)
            .background(
                Brush.linearGradient(
                    colors = listOf(
                        Color(android.graphics.Color.parseColor("#E6BAE8")),
                        Color(android.graphics.Color.parseColor("#D35AE8"))
                    )
                )
            ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            content = {
                val open = remember { mutableStateOf(true) }
                testArray1()
                testArray2()
                testArray3()

                seasonBoxWithEpisodeList()
            }
        )
    }

    @Composable
    fun seasonBoxWithEpisodeList(){
        LazyVerticalGrid(
            columns = GridCells.Fixed(1),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ){
            items(arrayEpisodesS1){
                episodeBox(episode = it)
            }
        }
    }

    @Composable
    fun episodeBox(episode: Episode){
        Box(modifier = Modifier){
            Row {
                Text(text = episode.toString())
            }
        }
    }

}
