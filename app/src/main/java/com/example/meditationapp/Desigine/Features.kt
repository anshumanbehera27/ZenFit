package com.example.meditationapp.Desigine

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meditationapp.ui.theme.ButtonBlue
import com.example.meditationapp.ui.theme.TextWhite


// todo 4 Create a dataclase for the featureas
data class Features(
    val title:String ,
    @DrawableRes val IconId:Int ,
    val lightColor:Color ,
    val mediumColor: Color,
    val darkColor: Color
)


@Composable
fun FeaturesSection(features: List<Features>){
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = "Features" ,
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(15.dp)
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 7.5.dp , end = 7.5.dp , bottom = 100.dp),
            modifier = Modifier.fillMaxHeight()
        ){
            items(features.size) {
                FeatureItem(features = features[it])
            }
        }
    }
}
@Composable
fun FeatureItem(
    features:Features
){
    BoxWithConstraints(
        modifier = Modifier
            .padding(7.5.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(10.dp))
            .background(features.darkColor)
    ) {
        val width = constraints.maxWidth
        val height = constraints.maxHeight

        // medium Colored path
        val mediumColoredpoint1 = Offset(0f , height*0.3f )
        val mediumColorpoint2 = Offset(width *0.1f , height*0.35f)
        val mediumColorpoint3 = Offset(width *0.4f , height*0.05f )
        val mediumColorpoint4 = Offset(width*0.75f, height*0.7f )
        val mediumColorpoint5 = Offset(width*1.4f, -height.toFloat() )

        val mediumColoredPath = Path().apply {
            moveTo(mediumColoredpoint1.x , mediumColoredpoint1.y)
           StandardQuadFromTo(mediumColoredpoint1 , mediumColorpoint2)
            StandardQuadFromTo(mediumColorpoint2, mediumColorpoint3)
            StandardQuadFromTo(mediumColorpoint3, mediumColorpoint4)
            StandardQuadFromTo(mediumColorpoint4 , mediumColorpoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f , height.toFloat() + 100f)
            close()
        }
        // Light colored path
        val lightPoint1 = Offset(0f, height * 0.35f)
        val lightPoint2 = Offset(width * 0.1f, height * 0.4f)
        val lightPoint3 = Offset(width * 0.3f, height * 0.35f)
        val lightPoint4 = Offset(width * 0.65f, height.toFloat())
        val lightPoint5 = Offset(width * 1.4f, -height.toFloat() / 3f)

        val lightColoredPath = Path().apply {
            moveTo(lightPoint1.x, lightPoint1.y)
            StandardQuadFromTo(lightPoint1, lightPoint2)
            StandardQuadFromTo(lightPoint2, lightPoint3)
            StandardQuadFromTo(lightPoint3, lightPoint4)
            StandardQuadFromTo(lightPoint4, lightPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }
        Canvas(modifier = Modifier.fillMaxSize() ) {
            drawPath(
                path = lightColoredPath ,
                color = features.lightColor
            )

        }
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(15.dp))
        {
            Text(text = features.title,
                style = MaterialTheme.typography.headlineSmall ,
                lineHeight = 26.sp,
                modifier = Modifier.align(Alignment.TopStart)
             )
            
            Icon(painter = painterResource(id = features.IconId),
                contentDescription =  features.title,
                tint = Color.White,
                modifier = Modifier.align(Alignment.BottomStart)
            )
            Text(text = "Start",
                color = TextWhite,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold ,
                modifier = Modifier
                    .clickable {
                        // handel the click
                    }
                    .align(Alignment.BottomEnd)
                    .clip(RoundedCornerShape(10.dp))
                    .background(ButtonBlue)
                    .padding(vertical = 6.dp, horizontal = 15.dp)
            )
        }







    }

}