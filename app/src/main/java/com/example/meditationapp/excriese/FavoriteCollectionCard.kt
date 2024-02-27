package com.example.fitpro

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

// TODO 3 FavoriteCollectionCard
/*
why surface is use - for design and shape of the image

 */
@Composable
fun FavoriteCollectionCard(
    @DrawableRes drawableRes: Int ,
    @StringRes text:Int ,
    modifier: Modifier = Modifier

){
    Surface(
        shape =  MaterialTheme.shapes.medium ,
        modifier =  modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier =  Modifier.width(225.dp)
        ) {
            Image(painter = painterResource(drawableRes),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier =  modifier.size(80.dp)
            )
            Text(text = stringResource(text))
        }

    }

}