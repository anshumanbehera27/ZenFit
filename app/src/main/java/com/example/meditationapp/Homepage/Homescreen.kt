package com.example.meditationapp.Homepage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.meditationapp.R
import com.example.meditationapp.ui.theme.Beige1
import com.example.meditationapp.ui.theme.Beige2
import com.example.meditationapp.ui.theme.Beige3
import com.example.meditationapp.ui.theme.BlueViolet1
import com.example.meditationapp.ui.theme.BlueViolet2
import com.example.meditationapp.ui.theme.BlueViolet3
import com.example.meditationapp.ui.theme.DeepBlue
import com.example.meditationapp.ui.theme.LightGreen1
import com.example.meditationapp.ui.theme.LightGreen2
import com.example.meditationapp.ui.theme.LightGreen3
import com.example.meditationapp.ui.theme.MeditationAppTheme
import com.example.meditationapp.ui.theme.OrangeYellow1
import com.example.meditationapp.ui.theme.OrangeYellow2
import com.example.meditationapp.ui.theme.OrangeYellow3

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun mainScreenView(){
    MeditationAppTheme {

        Scaffold(
            bottomBar = { navgationView()}
        ) { padding->
            HomeScreen(Modifier.padding(padding))

        }
    }
}
// Todo 1 create a frame for the home Screen
@Composable
fun HomeScreen(modifier: Modifier = Modifier){

    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()


    ) {
        Column {
            GreeatingSection(name = "Anshuman")
            chipSection(
                chips = listOf(
                    "Sweet sleep",
                    "Insomnia",
                    "Despression",
                    "Sweet sleep",
                    "Insomnia",
                    "Despression"
                )
            )
            CurrentMedition()
            FeaturesSection(
                features = listOf(
                    Features(
                        title = "Sleep meditation",
                        R.drawable.ic_headphone,
                        BlueViolet1,
                        BlueViolet2,
                        BlueViolet3
                    ),
                    Features(
                        title = "Tips for sleeping",
                        R.drawable.ic_videocam,
                        LightGreen1,
                        LightGreen2,
                        LightGreen3
                    ),
                    Features(
                        title = "Night island",
                        R.drawable.ic_headphone,
                        OrangeYellow1,
                        OrangeYellow2,
                        OrangeYellow3
                    ),
                    Features(
                        title = "Calming sounds",
                        R.drawable.ic_headphone,
                        Beige1,
                        Beige2,
                        Beige3
                    )
                )
            )
        }
//        Bottomenu(
//            items = listOf(
//                BotttommenuContent("Home", R.drawable.ic_home),
//                BotttommenuContent("Fitness", R.drawable.ic_fit),
//                BotttommenuContent("Profile", R.drawable.ic_profile),
//                BotttommenuContent("article", R.drawable.article)
//
//            ), modifier = Modifier.align(Alignment.BottomCenter)
//        )

    }


  }

@Composable
fun navgationView(){
    val navController = rememberNavController();
    Bottomenu(
        items = listOf(
           BotttommenuContent(route = "home", titel = "Home", iconId = R.drawable.ic_home),
            BotttommenuContent(route = "Fitness", titel = "Fitness", iconId = R.drawable.ic_fit),
            BotttommenuContent(route = "Profile", titel = "Profile", iconId = R.drawable.ic_profile),
            BotttommenuContent(route = "article", titel = "article", iconId = R.drawable.article)


        ),
        navController = navController,
        onItemClick = {
            navController.navigate(it.route)
        }
    )
}







