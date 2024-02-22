package com.example.materialapp3
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.example.meditationapp.ui.theme.MeditationAppTheme

@Composable
fun MyArticles(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Home.route){
        composable(Home.route){
            Content(navController)
        }
        composable(Favoritepart.route){
            favroite(modifier = Modifier.fillMaxSize())
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Content(navController:NavController) {

    MeditationAppTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            // TODO create the Add button
            Scaffold(
                floatingActionButton = {
                    FloatingActionButton(onClick = {
                        navController.navigate(Favoritepart.route)
                    }) {
                        Icon(imageVector = Icons.Default.Favorite, contentDescription = null  ,
                            tint = MaterialTheme.colorScheme.onErrorContainer)

                    }
                },
                topBar = {
//                    TopAppBar(title = { Text(text = "Content App")} ,
//                        colors = TopAppBarDefaults.smallTopAppBarColors(
//                            containerColor = MaterialTheme.colorScheme.surfaceVariant,
//                            titleContentColor = MaterialTheme.colorScheme.onSurfaceVariant)
//
//                    )
                    OptionMenu()


                },
            ) { values ->
                LazyColumn(contentPadding = values){
                    items(20){
                        ImageCard(
                            title = "Bacon ipsum",
                            description = "Bacon ipsum dolor amet pork shankle beef andouille ball tip. Meatball corned beef swine, strip steak bacon jerky doner tongue biltong pork loin drumstick sausage hamburger burgdoggen." ,
                            modifier =  Modifier.padding(16.dp))


                    }


                }

            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnboardingPreview() {
    MyArticles()

}