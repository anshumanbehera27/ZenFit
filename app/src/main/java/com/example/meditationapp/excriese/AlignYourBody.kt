package com.example.fitpro

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

// TODO 2  create a  a space for yoga poses
/*
1 - first create for single element and add the image for the each of the part
2 - add the image throw the drawable
3 - how to resize the clip - clip  shape
4 - fix the image Contentscale
 */
@Composable
fun AlignYourBodyElement(
    @DrawableRes drawableRes: Int ,
    @StringRes text :Int,
    modifier: Modifier = Modifier
){
    Column( horizontalAlignment =  Alignment.CenterHorizontally,
        modifier = Modifier)
    {
        Image(painter = painterResource(drawableRes),
            contentDescription = null ,
            modifier  = Modifier.size(88.dp).clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        Text(
            text = stringResource(text),
        modifier  = Modifier.paddingFromBaseline(top = 24.dp , bottom =  8.dp),
            style = MaterialTheme.typography.bodyMedium
        )

    }

}