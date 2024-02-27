package com.example.materialapp3

import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import android.widget.Toast

import androidx.annotation.OptIn;
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue



@kotlin.OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OptionMenu(){
    var showMenu by remember {
        mutableStateOf(false)
    }
    val context = LocalContext.current
    // TODO  Create the top app bar
    TopAppBar(
        title = { Text(text = "Content App")},
        actions = {
            IconButton(onClick = { Toast.makeText(context, "Profile", Toast.LENGTH_SHORT) }) {
                Icon(Icons.Default.Person, "")

            }

            IconButton(onClick = {
                Toast.makeText(context, "Favorite", Toast.LENGTH_SHORT).show()
            }) {
                Icon(Icons.Default.Favorite, "")

            }
            IconButton(onClick = { showMenu = !showMenu }) {
                Icon(Icons.Default.MoreVert, "")

            }
            DropdownMenu(
                expanded = showMenu,
                onDismissRequest = { showMenu = false }
            ) {

                DropdownMenuItem(
                    text = { Text(text = "profile" ) },
                    onClick = {
                        Toast.makeText(context, "profile", Toast.LENGTH_SHORT).show()
                    } )


                DropdownMenuItem(
                    text = { Text(text = "New content" )  },
                    onClick = {
                        Toast.makeText(context, "new content", Toast.LENGTH_SHORT).show()
                    })

                DropdownMenuItem(
                    text = { Text(text = "feed back" ) },
                    onClick = {
                        Toast.makeText(context, "Feed back", Toast.LENGTH_SHORT).show()
                    })


                DropdownMenuItem(
                    text = { Text(text = "Report An issue " ) },
                    onClick = {
                        Toast.makeText(context, "Report issue", Toast.LENGTH_SHORT).show()
                    })


                DropdownMenuItem(
                    text = { Text(text = "help" ) },
                    onClick = {
                        Toast.makeText(context, "help", Toast.LENGTH_SHORT).show()
                    })


            }

        })
}


