package com.example.meditationapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.meditationapp.Desigine.Bottomenu
import com.example.meditationapp.Desigine.BotttommenuContent

import com.example.meditationapp.Desigine.GreeatingSection
import com.example.meditationapp.Desigine.HomeScreen
import com.example.meditationapp.Desigine.mainScreenView
import com.example.meditationapp.ui.theme.MeditationAppTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            mainScreenView()


            // A surface container using the 'background' color from the theme }
        }
    }
}





