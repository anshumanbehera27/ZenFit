package com.example.meditationapp.Homepage



import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.meditationapp.ui.theme.AquaBlue
import com.example.meditationapp.ui.theme.ButtonBlue
import com.example.meditationapp.ui.theme.DeepBlue

data class BotttommenuContent(
    val route:String,
    val titel :String ,
    @DrawableRes val iconId:Int
)





@Composable
fun Bottomenu(
        items: List<BotttommenuContent>,
        modifier: Modifier = Modifier,
        activeHighlightColor: Color = ButtonBlue,
        activeTextColor: Color = Color(0xffeeeeee),
        inactiveTextColor: Color = AquaBlue,
        initialSelectedItemIndex: Int = 0,
        navController: NavController,
        onItemClick: (BotttommenuContent) -> Unit
    ) {
    var selectItemIndex by remember {
        mutableStateOf(initialSelectedItemIndex)
    }
        val backStackEntry = navController.currentBackStackEntryAsState()
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(DeepBlue)
            .padding(15.dp)
    ) {
        items.forEachIndexed{index, item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            BottomMenuItem(
                item = item ,
                isSelected = selected,
                activeHighlightColor = activeHighlightColor,
                activeTextColor =activeTextColor ,
                inactiveTextColor = inactiveTextColor,
                onItemClick = {onItemClick(item)}



            )


        }
//        items.forEachIndexed{index, item ->
//            BottomMenuItem(
//                item = item ,
//                isSelected = index == selectItemIndex,
//                activeHighlightColor = activeHighlightColor,
//                activeTextColor =activeTextColor ,
//                inactiveTextColor = inactiveTextColor,
//
//
//
//                ) {
//                selectItemIndex  = index
//
//
//            }
//
//
//        }


    }

}
// todo Add all the item  of the navugation bar item
@Composable
fun BottomMenuItem(
    item: BotttommenuContent,

    isSelected: Boolean = false,
    activeHighlightColor: androidx.compose.ui.graphics.Color= ButtonBlue,
    activeTextColor: androidx.compose.ui.graphics.Color = Color(0xffeeeeee),
    inactiveTextColor: androidx.compose.ui.graphics.Color = AquaBlue,
    onItemClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable {
            onItemClick()
        }
    ){
        Box(contentAlignment =  Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(if (isSelected) activeHighlightColor else androidx.compose.ui.graphics.Color.Transparent)
                .padding(10.dp)
        )
        {
            Icon(painter = painterResource(id = item.iconId), contentDescription = item.titel ,
                tint = (if (isSelected) activeTextColor else inactiveTextColor),
                modifier =  Modifier.size(20.dp)

            )

        }
        Text(
            text = item.titel,
            color = if (isSelected) activeTextColor else inactiveTextColor

        )

    }


}

