@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.materialapp3

import android.accounts.AuthenticatorDescription
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import java.sql.Wrapper
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.SizeMode
import java.util.concurrent.Flow

import kotlin.random.Random

@Composable
fun ImageCard(
    title:String ,
    description: String ,
    modifier: Modifier = Modifier
){
    Card (
        modifier = Modifier ,
        colors =  CardDefaults.cardColors(
            containerColor = colorScheme.surfaceVariant,
            ),
        shape = MaterialTheme.shapes.large
    )
    {
        Image(painter = rememberAsyncImagePainter(model = "https://picsum.photos/seed/${Random.nextInt()}/300/200"),
            contentDescription =null ,
            modifier = Modifier
                .clip(MaterialTheme.shapes.large)
                .fillMaxWidth()
                .aspectRatio(3f / 2f)
        )
        Column(modifier =  Modifier.padding(16.dp)) 
        {
            Text(text = title , style = MaterialTheme.typography.titleLarge)
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Text(text = description , style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(8.dp))

            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                mainAxisSpacing = 8.dp,
                mainAxisSize = SizeMode.Wrap
            ) {

                AssistChip(onClick = {},
                    colors = AssistChipDefaults.assistChipColors( 
                        leadingIconContentColor = colorScheme.surfaceVariant ) ,
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.FavoriteBorder,
                            contentDescription = null
                        )
                    }, 
                    label = {
                        Text(text = "Mark As favotie")
                    }
                )

                AssistChip(onClick = { },
                    colors = AssistChipDefaults.assistChipColors(
                        leadingIconContentColor = colorScheme.surfaceVariant ) ,
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Share,
                            contentDescription = null
                        )
                    },
                    label = {
                        Text(text = "Share with Others")
                    }
                )



            }
            

        }


    }
}


