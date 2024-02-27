package com.example.fitpro
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.meditationapp.Homepage.navgationView

import com.example.meditationapp.R
import com.example.meditationapp.data.home
import com.example.meditationapp.data.welcome
import com.example.meditationapp.ui.theme.MeditationAppTheme


class MainActivity : ComponentActivity() {



}
@Composable
fun fitnessScreen(){
    MeditationAppTheme {
        Scaffold(
            bottomBar = { Mynagavation() }
        ) { padding->
            HomeScreen(Modifier.padding(padding))
        }
    }
}

// TODO 14 Add negavite from home screen to new screen

@Composable
fun Mynagavation(){
    val  navController = rememberNavController()

    NavHost(navController = navController, startDestination = welcome.route){
        composable(welcome.route){
            WelcomeScreen(navController)
        }
        composable(home.route){
           portraitModeView()
        }
    }
}


// TODO 12 how to chnage the screen when it is protrate and landscape mode
@Composable
fun Myapp(windowSize: WindowSizeClass){
    when(windowSize.widthSizeClass){
        WindowWidthSizeClass.Compact->{
            portraitModeView()

        }
        WindowWidthSizeClass.Expanded ->{
            LandscapeMode()
        }
    }
}
// TODO 9  combine them into a full screen implementation.
/*
1 - we need to create a function and add it all of the screen in to the patiular column
2 - how to use the scroll view in the
 with the help of verticalScroll(rememberScrollState())
 3 - After that we are define the all of the screen one by on
 */
@Composable
fun HomeScreen(modifier: Modifier = Modifier){
    Column(
        modifier.verticalScroll(rememberScrollState())
    ) {
        Spacer(Modifier.height(16.dp))
        serachBar(Modifier.padding(horizontal = 16.dp))
        HomeSection(titel = R.string.align_your_body) {
            AlignYourBodyRow()
        }
        HomeSection(titel = R.string.favorite_collections) {
            FavoriteCollectionsGrid()

        }
        Spacer(Modifier.height(16.dp))




    }

}

// TODO 8  Create a homeSection for merg the title and composable function
@Composable
fun HomeSection(
    @StringRes titel:Int ,
    modifier: Modifier = Modifier,
    content: @Composable () ->Unit
){
    Column(modifier) {
        Text(stringResource(titel),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 16.dp)
                .padding(horizontal = 16.dp)
        )

        content()

    }

}


// TODO 4 how to make the algigement make scroable element one by one using the simple function list
/*
1 - create a data class deawablesting pair
2 - we need to make a list of all of the string and image we want to add in the app
3 - we need to create a function AlignYourbody wehere all of the item are able to show one by one
 */

private data class DrawableStringPair(
    @DrawableRes val drawableRes: Int ,
    @StringRes val text: Int
)

private  val alignYourBodyData = listOf(
    R.drawable.ab1_inversions to R.string.ab1_inversions,
    R.drawable.ab2_quick_yoga to R.string.ab2_quick_yoga,
    R.drawable.ab3_stretching to R.string.ab3_stretching,
    R.drawable.ab4_tabata to R.string.ab4_tabata,
    R.drawable.ab5_hiit to R.string.ab5_hiit,
    R.drawable.ab6_pre_natal_yoga to R.string.ab6_pre_natal_yoga
).map { DrawableStringPair(it.first ,it.second) }
//TODO 5 crete a function for Align body row arragement
@Composable
fun AlignYourBodyRow(modifier: Modifier  = Modifier){
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ){
        items(alignYourBodyData){ item ->
           AlignYourBodyElement(item.drawableRes ,item.text)

        }

        }
    }


private val favoriteCollectionsData = listOf(
    R.drawable.fc1_short_mantras to R.string.fc1_short_mantras,
    R.drawable.fc2_nature_meditations to R.string.fc2_nature_meditations,
    R.drawable.fc3_stress_and_anxiety to R.string.fc3_stress_and_anxiety,
    R.drawable.fc4_self_massage to R.string.fc4_self_massage,
    R.drawable.fc5_overwhelmed to R.string.fc5_overwhelmed,
    R.drawable.fc6_nightly_wind_down to R.string.fc6_nightly_wind_down
).map { DrawableStringPair(it.first, it.second) }

// TODO 6 create a Fav collection layouts
// we want to add the multiple row in to use LazyHorizontalGrid
@Composable
fun FavoriteCollectionsGrid(modifier: Modifier = Modifier){
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        modifier =  modifier.height(168.dp) ,
        contentPadding =  PaddingValues(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)

    ){
        items(favoriteCollectionsData) {item ->
            FavoriteCollectionCard(item.drawableRes , item.text,Modifier.height(80.dp))
        }
    }
}



