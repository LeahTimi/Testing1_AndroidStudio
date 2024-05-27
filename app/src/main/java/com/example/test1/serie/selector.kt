package com.example.test1.serie
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.test1.data.setComboBoxSelectedOptionText
import com.example.test1.extras.Episode
import com.example.test1.extras.Season
import com.example.test1.selectores.iscreenWithBottomAndTopBar

class BarImplemets() : iscreenWithBottomAndTopBar
    @Composable
    @Preview
    fun serieScreen(){
        serieScaffold()
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun serieScaffold(){
        Scaffold(
            topBar = { BarImplemets().predefiniedTopBar(topBarText = "Glosario",) },
            bottomBar = { BarImplemets().predefiniedBottomBar() },
            content = { padding -> serieContent(padding = padding) }
        ) // Scaffold
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun serieContent(padding: PaddingValues){
        Column (modifier = Modifier
            .fillMaxSize()
            .padding(padding)
            // Color(android.graphics.Color.parseColor("#313338") )
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
                val episodes1 = ArrayList<Episode>()
                val episode1 = Episode(id_episode = 1, episode = 1, id = 0, season = 1, videoUrl = "", nombre = "Episodio 1 season 1", descripcion = "Descripción")
                val episode2 = Episode(id_episode = 1, episode = 2, id = 0, season = 1, videoUrl = "", nombre = "Episodio 2 season 1", descripcion = "Descripción")
                episodes1.add(episode1);episodes1.add(episode2);episodes1.add(episode1);episodes1.add(episode2)
                val episodes2 = ArrayList<Episode>()
                val episode3 = Episode(id_episode = 1, episode = 1, id = 0, season = 2, videoUrl = "", nombre = "Episodio 1 season 2", descripcion = "Descripción")
                val episode4 = Episode(id_episode = 1, episode = 2, id = 0, season = 2, videoUrl = "", nombre = "Episodio 2 season 2", descripcion = "Descripción")
                episodes2.add(episode3);episodes2.add(episode4);episodes2.add(episode3);episodes2.add(episode4)
                val season1 = Season(id_season = 1, season = 1, episodes = episodes1, id = 1)
                val season2 = Season(id_season = 2, season = 2, episodes = episodes2, id = 2)
                val allEpisodesMLP_Show = ArrayList<Season>()
                allEpisodesMLP_Show.add(season1);allEpisodesMLP_Show.add(season2);allEpisodesMLP_Show.add(season1);allEpisodesMLP_Show.add(season2)


                SeasonsBoxexWithEpisodeList(allEpisodesMLP_Show)
            }
        )
    }

    @Composable
    fun SeasonsBoxexWithEpisodeList(seasons: ArrayList<Season>) {

        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxWidth(0.8f),
            columns = GridCells.Fixed(1),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ){
            items(seasons){ season ->
                SeasonBox(season = season)
            }
        }
    }

    @Composable
    fun SeasonBox(season: Season){
        val open = remember { mutableStateOf(false) }
        val corner1 = RoundedCornerShape(topStart = 55.dp, topEnd = 55.dp, bottomEnd = 55.dp, bottomStart = 55.dp)
        val corner2 = RoundedCornerShape(topStart = 0.dp)
        val currCorner = remember { mutableStateOf(corner1) }
        Column(modifier = Modifier
            .clip(shape = currCorner.value)
         //   .border(width = 1.dp, color = Color.Black
        //        ,shape = RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp)
    //        )
        ) {// #DA80E8
            Box(modifier = Modifier
                .clickable {
                    open.value = !open.value
                    if (currCorner.value == corner1) {
                        currCorner.value = corner2
                    } else {
                        currCorner.value = corner1
                    }
                }
                .clip(shape = currCorner.value)
                .fillMaxWidth()
                .height(50.dp)
                .background(Color(android.graphics.Color.parseColor("#2F1733"))), // #F0EC7D #EDD855
                contentAlignment = Alignment.Center
            ){
                Text(
                    modifier = Modifier,
                    text = "Season ${season.season}",
                    textAlign = TextAlign.Center,
                    fontStyle = FontStyle.Italic,
                    color = Color.White
                )
                IconDisplayState(open)
            }

            AnimatedVisibility(visible = open.value) {

                    // Muestra una Columna
                    Column(modifier = Modifier
                        .background(Color(android.graphics.Color.parseColor("#fdf5fe")))
                        //   .border(2.dp, shape = corner2, color = Color.Black)
                    , horizontalAlignment = Alignment.CenterHorizontally
                    ){

                        var cont = 0
                        for(episode in season.episodes){
                            Spacer(modifier = Modifier
                                .height(4.dp))
                            if (cont >0){
                                Spacer(
                                    modifier = Modifier
                                        .height(1.dp)
                                        .width(250.dp)
                                        .border(
                                            shape = RectangleShape,
                                            width = 2.dp,
                                            color = Color.Black
                                        )
                                )
                            }
                            cont++
                            Spacer(modifier = Modifier
                                .height(4.dp))
                            EpisodeBox(episode = episode)
                        }
                        Spacer(modifier = Modifier.height(7.dp))
                    }
            }
        }
    }
@Composable
    fun EpisodeBox(episode: Episode){
        Box(modifier = Modifier
            .height(25.dp)
       //     .background(Color(android.graphics.Color.parseColor("#F0EC7D")))
        ){
                Text(
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable {

                        },
                    text = episode.toString(),
                    textAlign = TextAlign.Center,
                    fontStyle = FontStyle.Italic,
                    color = Color(android.graphics.Color.parseColor("#2F1733")))
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
                    contentDescription = "Closed",
                    tint = Color.White
                )
            } else {
                Icon(
                    Icons.Default.KeyboardArrowRight,
                    contentDescription = "Open",
                    tint = Color.White
                )
            }
        }
    }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComboBoxSeasons(allEpisodesMLP_Show : ArrayList<Season>){
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf(allEpisodesMLP_Show[0]) }


    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        }
    ) {
        TextField(
            modifier = Modifier.menuAnchor(),
            readOnly = true,
            value = selectedOption.name(),
            onValueChange = { },
            label = { Text("Label") },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded
                )
            },
            colors = ExposedDropdownMenuDefaults.textFieldColors()
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }
        ) {
            allEpisodesMLP_Show.forEach { season ->
                DropdownMenuItem(
                    text = { Text(text = season.name()) },
                    onClick = {
                        selectedOption = season
                        setComboBoxSelectedOptionText(selectedOption.name())
                        expanded = false
                    }
                )
            }
        }
    }
}

@Composable
fun ImgIcons( img : Int){
    Image(painter = painterResource(id = img),
        contentDescription = null,
        modifier = Modifier.size(50.dp),
        alpha = 1F
    )
}