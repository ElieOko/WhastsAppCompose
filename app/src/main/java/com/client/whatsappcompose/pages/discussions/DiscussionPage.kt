package com.client.whatsappcompose.pages.discussions

import android.widget.Toast
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.client.whatsappcompose.composants.core.BoxDiscussion
import com.client.whatsappcompose.constantes.FakeData.discussion
import com.client.whatsappcompose.constantes.FakeData.typeDiscussionList
import com.client.whatsappcompose.ui.theme.wsColor

@Composable
fun DiscussionPage(){
    DiscussionBody()
}

@Composable
fun DiscussionBody(){
    val scrollHorizontal = rememberScrollState()
    val scrollVertical = rememberScrollState()
    val local = LocalContext.current
    Column(modifier = Modifier.fillMaxSize().verticalScroll(scrollVertical)) {
        Row(modifier = Modifier.padding(10.dp).horizontalScroll(scrollHorizontal).fillMaxWidth()) {
           typeDiscussionList.forEach {
               SuggestionChip(
                   shape = RoundedCornerShape(35.dp),
                   label = {
                       Text(it.title)
                   },
                   onClick = {},
                   colors = if(it.isActive) SuggestionChipDefaults.suggestionChipColors(wsColor) else SuggestionChipDefaults.suggestionChipColors()
               )
               Spacer(Modifier.width(10.dp))
           }

        }
        discussion.forEach {
            BoxDiscussion(it, onclick = {
                Toast.makeText(local, it.userReceiveTo.username, Toast.LENGTH_LONG).show()
            })
        }
    }
}

@Composable
@Preview(showBackground = true)
fun DiscussionPreview(){
    DiscussionBody()
}