package com.client.whatsappcompose.composants.core

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.client.whatsappcompose.R
import com.client.whatsappcompose.models.User


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun TopBarConversation(
    user : User? = User(id = 3, username = "David", profil = R.drawable.kedy) ,
    onclick : ()-> Unit = {},
){
    TopAppBar(
        title = {
            Row {
                Image(painter = painterResource(user?.profil?.toInt() ?: 0),null,
                    modifier = Modifier
                        .size(35.dp)
                        .clip(RoundedCornerShape(60),
                        ),
                    contentScale = ContentScale.Crop)
                Spacer(Modifier.width(15.dp))
                Text(user?.username.toString())
            }
        },
        navigationIcon = {
            IconButton(onClick = {onclick()}) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, null)
            }
        },
        actions = {
            IconButton(onClick = {onclick()}) {
                Icon(painter = painterResource(R.drawable.video), null, modifier = Modifier.size(30.dp))
            }
            IconButton(onClick = {onclick()}) {
                Icon(painter = painterResource(R.drawable.call), null, modifier = Modifier.size(28.dp))
            }
            IconButton(onClick = {onclick()}) {
                Icon(painter = painterResource(R.drawable.menu), null, modifier = Modifier.size(28.dp))
            }
        }
    )
}