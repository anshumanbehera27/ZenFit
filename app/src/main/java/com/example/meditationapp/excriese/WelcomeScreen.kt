package com.example.fitpro

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

import com.example.meditationapp.R
import com.example.meditationapp.data.home

// todo 13 create an welcome Screen
@Composable
public fun WelcomeScreen(navController: NavController){
    Box(modifier = Modifier.fillMaxSize()){
        Image(painter = painterResource(id = R.drawable.first) ,
            contentDescription = "background",
            contentScale = ContentScale.FillBounds ,
            modifier = Modifier.matchParentSize()
        )
        Column (
            modifier =  Modifier.fillMaxSize() ,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {

            Text("Welcome to FitnessApp" , fontSize = 30.sp , color = Color.Black )

            Button(onClick = {
                             navController.navigate(home.route)
            } ,
                modifier =  Modifier.padding(16.dp) ,
                colors = ButtonDefaults.buttonColors(Color.Magenta)


            ) {
                Text(text = "Click here to procced" , fontSize = 18.sp)

            }

        }
    }


}

