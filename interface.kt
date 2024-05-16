import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import timoneda.lemon.a1proyecto_gachapony.R
import timoneda.lemon.a1proyecto_gachapony.navigation.AppScreens

interface iscreenWithBottomAndTopBar{
    // TOP BAR With out Return Statement
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

    // Top Bar With Return Statement
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun predefiniedTopBarWithReturn( topBarText : String,navController: NavController){
        CenterAlignedTopAppBar(
            title = {
                Row (modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween)
                {
                    Icon(
                        Icons.Default.ArrowBack,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier
                            .size(30.dp)
                            .clickable {
                                navController.navigate(route = AppScreens.CollectionScreen.route)
                            } // Clicakle fin
                    ) // Icon
                    Text(text = topBarText,
                        textAlign = TextAlign.Center,
                        fontSize = 26.sp,
                        color = Color.White, fontFamily = FontFamily.Monospace)
                    Spacer(modifier = Modifier.width(1.dp))
                } // Row
            }, // Title
            colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = Color.Black)
        )
    }


    // BOTTOM BAR  to navigate between screens
    @Composable
    fun predefiniedBottomBar(navController: NavController){
        BottomAppBar (containerColor = Color.Black,
            modifier = Modifier
        ){
            // Box 1
            Box(modifier = Modifier
                .fillMaxHeight()
                .width(133.dp)
                .border(
                    width = 1.dp,
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color.Black, Color.Black,
                            Color.Black, Color.Black, Color.White
                        )
                    ),
                    shape = RectangleShape
                ) )// Modificadores Caja 1 - Bestairio
            {
                Column (modifier = Modifier
                    .fillMaxSize()
                    .clickable {
                        navController.navigate(route = AppScreens.BestiarioScreen.route)
                    },
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally)
                {
                    ImgIcons(img = R.drawable.bestiario)
                    Text(
                        text = "Glosario-Pony",
                        color = Color.White,
                        fontSize = 15.sp,
                        modifier = Modifier,
                        textAlign = TextAlign.Center)
                }
            } // FIN BOX 1
            // Box 2
            Box(modifier = Modifier
                .fillMaxHeight()
                .width(133.dp)
                .border(
                    width = 1.dp,
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color.White, Color.Black,
                            Color.Black, Color.Black, Color.White
                        )
                    ),
                    shape = RectangleShape
                ) )// Modificadores Caja 2
            {
                Column (modifier = Modifier
                    .fillMaxSize()
                    .clickable {
                        navController.navigate(route = AppScreens.BannerScreen.route)
                    },
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally)
                {
                    ImgIcons(img = R.drawable.gachamlp)
                    Text(
                        text = "Invoca un Pony!",
                        color = Color.White,
                        fontSize = 15.sp,
                        modifier = Modifier,
                        textAlign = TextAlign.Center)
                }
            } // FIN BOX 2
            // Box 3
            Box(modifier = Modifier
                .fillMaxHeight()
                .width(133.dp)
                .border(
                    width = 1.dp,
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color.White, Color.Black,
                            Color.Black, Color.Black, Color.Black
                        )
                    ),
                    shape = RectangleShape
                ) )// Modificadores Caja 3
            {
                Column (modifier = Modifier
                    .fillMaxSize()
                    .clickable {
                        navController.navigate(route = AppScreens.CollectionScreen.route)
                    },
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally)
                {
                    ImgIcons(img = R.drawable.collection)
                    Text(
                        text = "Colección",
                        color = Color.White,
                        fontSize = 15.sp,
                        modifier = Modifier,
                        textAlign = TextAlign.Center)
                }
            } // FIN BOX 3
        }
    }

    // Local image Loader
    @Composable
    fun ImgIcons( img : Int){
        Image(painter = painterResource(id = img),
            contentDescription = null,
            modifier = Modifier.size(50.dp),
            alpha = 1F
        )
    }

    @Composable
    fun ImgChikiIcons( img : Int){
        Image(painter = painterResource(id = img),
            contentDescription = null,
            modifier = Modifier.height(25.dp).width(13.dp),
            alpha = 1F
        )
    }

    // Database Image Loader
    @Composable
    fun SaberImg(img: Int){
        Image(painter = painterResource(id = img),
            contentDescription = null,
            modifier = Modifier.size(300.dp),
            alpha = 1F
        )
    }

    @OptIn(ExperimentalGlideComposeApi::class)
    @Composable
    fun SaberImgURL(url : String){
        GlideImage(model = url
            , contentDescription = "",
            modifier = Modifier.size(300.dp),
            alpha = 1F)
    }
}
