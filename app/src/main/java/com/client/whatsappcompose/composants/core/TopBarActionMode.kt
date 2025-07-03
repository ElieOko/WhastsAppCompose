package com.client.whatsappcompose.composants.core

import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.client.whatsappcompose.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true)
fun TopBarActionMode(
    tailleItem : Int = 0,
    onclick :()->Unit = {}
){

    TopAppBar(
        navigationIcon = {
           IconButton(onClick = {onclick()}) {
               Icon(Icons.AutoMirrored.Filled.ArrowBack, null)
           }
        },
        title = { Text(tailleItem.toString(), modifier = Modifier.absoluteOffset(x = 18.dp)) },
        actions = {
            IconButton(onClick = {}) {
                Icon(painter = painterResource(R.drawable.pin), null, modifier = Modifier.size(28.dp))
            }
            IconButton(onClick = {}) {
                Icon(painter = painterResource(R.drawable.notificationon), null, modifier = Modifier.size(28.dp))
            }
            IconButton(onClick = {}) {
                Icon(painter = painterResource(R.drawable.archive), null, modifier = Modifier.size(28.dp))
            }
            IconButton(onClick = {}) {
                Icon(painter = painterResource(R.drawable.menu), null, modifier = Modifier.size(28.dp))
            }
        }
    )
}