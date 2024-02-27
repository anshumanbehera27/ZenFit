package com.example.fitpro

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.magnifier
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.meditationapp.R


// TODO 1 Create a search bar
/*
 1 - create a Textfild
 2  - add the search logo to the app
 3 - write the  hin of the text filed

 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun serachBar(modifier: Modifier = Modifier){
    TextField(
        value = "" ,
        onValueChange = {} ,
         modifier = modifier
             .fillMaxWidth()
             .heightIn(min = 56.dp) ,
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search ,
                contentDescription = null
            )
        } ,
        colors =  TextFieldDefaults.textFieldColors(
            unfocusedIndicatorColor = MaterialTheme.colorScheme.surface ,
            focusedIndicatorColor =  MaterialTheme.colorScheme.surface
        ),
        placeholder = {Text(stringResource(R.string.placeholder_search))
        }
    )
}




