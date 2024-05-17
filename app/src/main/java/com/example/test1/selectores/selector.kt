package com.example.test1.selectores
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.test1.extras.Episode
import com.example.test1.extras.Season
import com.example.test1.extras.VideoPlayer


@Composable
    @Preview
    fun serieScreen(){
        serieScaffold()
    }
    val arrayEpisodesS1 = ArrayList<Episode>()
    val arrayEpisodesS2 = ArrayList<Episode>()
    val arrayEpisodesS3 = ArrayList<Episode>()

    val arraySeasons = ArrayList<Season>()

    fun testArray1(){
        for (num in 1..3){
            val episode = Episode(id = null ,id_episode = 7,nombre = "Episodio ejemplo", episode = num, descripcion = "des des", season = 1, videoUrl = "")
            arrayEpisodesS1.add(episode)
        }
    }
    fun testArray2(){
        for (num in 1..3){
            val episode = Episode(id = null ,id_episode = 7,nombre = "Episodio ejemplo", episode = num, descripcion = "des des", season = 2,videoUrl = "")
            arrayEpisodesS2.add(episode)
        }
    }
    fun testArray3(){
        for (num in 1..3){
            val episode = Episode(id = null ,id_episode = 7,nombre = "Episodio ejemplo", episode = num, descripcion = "des des", season = 3,videoUrl = "")
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

                testArray1()
                testArray2()
                testArray3()

                val season1 = Season(id = null,id_season = 0, season = 1, episodes = arrayEpisodesS1)
                val season2 = Season(id = null,id_season = 0, season = 2, episodes = arrayEpisodesS2)
                val season3 = Season(id = null,id_season = 0, season = 3, episodes = arrayEpisodesS3)

                arraySeasons.add(season1)
                arraySeasons.add(season2)
                arraySeasons.add(season3)

                seasonsBoxexWithEpisodeList(arraySeasons)
            }
        )
    }

    @Composable
    fun seasonsBoxexWithEpisodeList(seasons: ArrayList<Season>) {

        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .background(Color.Red),
            columns = GridCells.Fixed(1),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ){
            items(seasons){
                SeasonBox(season = it)
            }
        }
    }

    @Composable
    fun SeasonBox(season: Season){
        val open = remember { mutableStateOf(false) }
        Column {
            Box(modifier = Modifier.fillMaxWidth()){
                Text(
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable {
                            open.value = !open.value
                        },
                    text = "Season ${season.season}",
                    textAlign = TextAlign.Center
                )
                IconDisplayState(open)
            }
            if (open.value){
                for(episdoe in season.episodes){
                    EpisodeBox(episode = episdoe,open)
                }
            }
        }
    }
    @Composable
    fun EpisodeBox(episode: Episode, open: MutableState<Boolean>){
        Box(modifier = Modifier){
                Text(
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable {
                        //    VideoPlayer(episode.videoUrl)
                        },
                    text = episode.toString(),
                    textAlign = TextAlign.Center)
        }
    }

    @Composable
    fun IconDisplayState(open: MutableState<Boolean>) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.CenterEnd
        ) {
            if (open.value){
                Icon(
                    Icons.Default.KeyboardArrowDown,
                    contentDescription = "Closed"
                )
            } else {
                Icon(
                    Icons.Default.KeyboardArrowRight,
                    contentDescription = "Open"
                )
            }
        }
    }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun predefiniedTopBar( topBarText : String){
    CenterAlignedTopAppBar(
        title = {
            Row (modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween)
            {
                Text(text = topBarText,
                    textAlign = TextAlign.Center,
                    fontSize = 26.sp,
                    color = Color.White, fontFamily = FontFamily.Monospace)
                Spacer(modifier = Modifier.width(1.dp))
            } // Row
        }, // Title
        colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = Color.Black)
        // #A67ABD
    )
}
@Composable
fun ImgIcons( img : Int){
    Image(painter = painterResource(id = img),
        contentDescription = null,
        modifier = Modifier.size(50.dp),
        alpha = 1F
    )
}