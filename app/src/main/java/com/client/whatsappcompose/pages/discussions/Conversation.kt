package com.client.whatsappcompose.pages.discussions

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.Badge
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.client.whatsappcompose.composants.core.TopBarConversation
import com.client.whatsappcompose.constantes.FakeData.listContact
import com.client.whatsappcompose.R
import com.client.whatsappcompose.ui.theme.bagdeColor

@Composable
fun Conversation(navHostController: NavHostController, userId: Int? = null) {
    ConversationBody(navHostController,userId)
}

@Composable
fun ConversationBody(navHostController: NavHostController? = null, userId: Int? = null) {
     val user = listContact.filter { contact ->
         contact.user.id == userId
     }[0].user
    var value by rememberSaveable { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopBarConversation(
                user = user,
                onclick = {
                    navHostController?.popBackStack()
                }
            )
        }
    ) {
        Column(modifier = Modifier.padding(it).padding(5.dp).fillMaxSize(), horizontalAlignment = Alignment.End, verticalArrangement = Arrangement.Bottom) {

            Row(Modifier.fillMaxWidth().padding(10.dp)) {
                Box {
                    BasicTextField(value = value, onValueChange = { value = it }, modifier = Modifier.width(300.dp))
                    if (value.isEmpty()) {
                        Text(text = "Placeholder")
                    }
                }
                Spacer(Modifier.width(10.dp))
                //IconButton(onClick = {}) {
                IconButton(onClick = {},modifier = Modifier, colors = IconButtonDefaults.iconButtonColors(
                    contentColor = Color.White,
                    containerColor = Color.Black
                ),) {
                    Icon(painter = painterResource(R.drawable.voice),null,modifier = Modifier.size(28.dp))
                    }
                //}
            }

        }
    }
}

@Composable
@Preview(showBackground = true)
fun ConversationPreview(){
    ConversationBody()
}