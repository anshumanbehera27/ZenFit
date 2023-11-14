package com.example.meditationapp.Desigine

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.meditationapp.R
import com.example.meditationapp.ui.theme.TextWhite

// todo 2 create GreeatingSection
@Composable
fun GreeatingSection(name:String ){

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Good morning , $name",
                style = MaterialTheme.typography.headlineSmall,
                color = TextWhite

            )
            Text(text = "We wish you a have a good day",
                style = MaterialTheme.typography.bodyMedium,
                color = TextWhite
                
            )
        }
       Icon(painter = painterResource(id = R.drawable.ic_search)  ,
           contentDescription = "Search",
           tint = Color.White,
           modifier = Modifier.size(24.dp)
       )
    }
}
