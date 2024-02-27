package com.example.fitpro

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.meditationapp.R

import com.example.meditationapp.ui.theme.MeditationAppTheme

// TODO 10 bottom navagation bar for portarate
// define a navigation bar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun portraitModeView(){
    MeditationAppTheme{
        Scaffold(
            bottomBar = { BottomNavigation() }
        ) { padding ->

            HomeScreen(Modifier.padding(padding))

        }
    }
}
@Composable
public fun BottomNavigation(modifier: Modifier = Modifier){
    // crete a  filed or area for the navbar
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surfaceVariant ,
        modifier  = modifier
    ){
        NavigationBarItem(
            icon = {
                Icon(imageVector = Icons.Default.Home,
                    contentDescription = null)
            },
            label = {
                Text(text = stringResource(R.string.bottom_navigation_home))
            },
            selected = true  ,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                Icon(imageVector = Icons.Default.AccountCircle,
                    contentDescription = null )
            },
            label = {
                Text(text = stringResource(R.string.bottom_navigation_home))
            },
            selected = false,
            onClick = {}
        )
    }
}
// TODO 11 Navigation bar for the lanscape mode
@Composable
fun LandscapeMode(){
    MeditationAppTheme {
      Surface(color = MaterialTheme.colorScheme.background) {
          Row {
              NavigationRail()
              HomeScreen()
          }

      }

    }
}



@Composable
private fun NavigationRail(modifier: Modifier = Modifier) {
    NavigationRail(
        modifier = modifier.padding(start = 8.dp, end = 8.dp),
        containerColor = MaterialTheme.colorScheme.background,
    ) {
        Column(
            modifier = modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NavigationRailItem(
                icon = {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = null
                    )
                },
                label = {
                    Text(stringResource(R.string.bottom_navigation_home))
                },
                selected = true,
                onClick = {}
            )
            Spacer(modifier = Modifier.height(8.dp))
            NavigationRailItem(
                icon = {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = null
                    )
                },
                label = {
                    Text(stringResource(R.string.bottom_navigation_profile))
                },
                selected = false,
                onClick = {}
            )
        }
    }
}