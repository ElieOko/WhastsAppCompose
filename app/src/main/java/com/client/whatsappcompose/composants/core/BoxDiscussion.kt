package com.client.whatsappcompose.composants.core

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.client.whatsappcompose.R
import com.client.whatsappcompose.constantes.FakeData.discussion
import com.client.whatsappcompose.models.Conversation
import com.client.whatsappcompose.ui.theme.wsColor

@Composable
fun BoxDiscussion(
     conversation: Conversation,
     onclick :()-> Unit = {}
){
    Row(Modifier.fillMaxWidth().clickable{
        onclick()
    }, horizontalArrangement = Arrangement.SpaceBetween) {
        Row(Modifier.padding(2.dp)) {
            Column {
                Image(
                    painter = painterResource(conversation.userReceiveTo.profil),
                    contentDescription = null,
                    modifier = Modifier
                        .size(55.dp)
                        .clip(RoundedCornerShape(60),
                        ),
                    contentScale = ContentScale.Crop

                )
            }
            Column(Modifier.padding(10.dp)) {
                Text(conversation.userReceiveTo.username, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Spacer(Modifier.height(2.dp))
                Row {
                    Icon(modifier = Modifier.size(23.dp),painter = painterResource(
                        if (conversation.status == null) R.drawable.check else R.drawable.read
                    ), contentDescription = "", tint = if (conversation.status == true) Color.Blue else Color.Unspecified
                    )
                    Text(conversation.message.toString(), color =  Color.Black.copy(0.5f))
                }
                }
        }
        Column(Modifier.padding(10.dp)) {
            Text(conversation.time)
        }
    }


}

@Composable
@Preview(showBackground = true)
fun Prevualisation(){

    BoxDiscussion(discussion[0])
}