package com.example.meditationapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.materialapp3.MyArticles
import com.example.meditationapp.Home.route
import com.example.meditationapp.Homepage.HomeScreen

import com.example.meditationapp.Homepage.mainScreenView
import com.example.meditationapp.Homepage.navgationView
import com.example.meditationapp.excriese.excriese
import com.example.meditationapp.ui.theme.MeditationAppTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MeditationAppTheme {

                val navController = rememberNavController();

                Scaffold(
                    bottomBar = { navgationView() }
                ) {
                    Navagation(navController = navController)
                }


                // A surface container using the 'background' color from the theme }
            }
        }
    }

    @Composable
    fun Navagation(navController: NavController) {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = Home.route) {
            composable("Homepage") {
                mainScreenView()
            }
            composable("article") {
                MyArticles()
            }
            composable("excrise") {
                excriese()
            }

        }
    }
}




