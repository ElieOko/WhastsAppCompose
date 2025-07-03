package com.client.whatsappcompose.composants.core

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Badge
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.client.whatsappcompose.R
import com.client.whatsappcompose.models.Discussion
import com.client.whatsappcompose.ui.theme.bagdeColor
import com.client.whatsappcompose.ui.theme.wsColor

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BoxDiscussion(
     discussion: Discussion,
     onclickEvent :()-> Unit = {},
     onlonclickEvent : ()-> Unit = {},
     isSelect : Boolean = false
){
    val me = 1
    val lastIndice = discussion.listConversation.size - 1
    val msgNonLue = discussion.listConversation.filter { it.status == false }.size
    Row(Modifier.fillMaxWidth().combinedClickable(
        onClick = onclickEvent,
        onLongClick = onlonclickEvent
    ).background(
        if (isSelect) wsColor else Color.Unspecified
    ), horizontalArrangement = Arrangement.SpaceBetween) {
        Row(Modifier.padding(2.dp)) {
            Column(Modifier.padding(10.dp)) {
                Box {
                    Image(
                        painter = painterResource(if(discussion.contact.user.id != me) discussion.contact.user.profil else discussion.contact.user.profil),
                        contentDescription = null,
                        modifier = Modifier
                            .size(45.dp)
                            .clip(RoundedCornerShape(60),
                            ),
                        contentScale = ContentScale.Crop
                    )
                    Row(modifier = Modifier.padding(2.dp)) {
                        if (isSelect){
                            Badge(containerColor = bagdeColor,modifier = Modifier.size(22.dp).absoluteOffset(y = (25).dp,x = (26).dp).border(width = 2.dp,
                                color = Color(0xF788F18A),
                                shape = CircleShape
                            )) {
                                Icon(Icons.Default.Check,null, tint = Color.White)
                            }
                        }
                    }
                }
            }

            Column{
                Spacer(Modifier.height(15.dp))
                Text( if(discussion.contact.user.id != me) discussion.contact.user.username else discussion.contact.user.username, fontSize = 15.sp, fontWeight = FontWeight.Bold)
                Spacer(Modifier.height(3.dp))
                Row(Modifier.absoluteOffset(y=(-5).dp)) {
                    if (discussion.listConversation[lastIndice].userSendTo.id == me){
                        Icon(modifier = Modifier.size(23.dp),painter = painterResource(
                            if (discussion.listConversation[lastIndice].status == null) R.drawable.check else R.drawable.read
                        ), contentDescription = "", tint = if (discussion.listConversation[lastIndice].status == true) Color.Blue else Color.Unspecified
                        )
                    }
                    Text(discussion.listConversation[lastIndice].message.toString(), color =  Color.Black.copy(0.5f), fontSize = 14.sp)
                }
            }
        }
        Column(Modifier.padding(10.dp)) {
            Text(discussion.listConversation[lastIndice].time,color =  Color.Black.copy(0.5f), fontSize = 12.sp)
            Spacer(Modifier.height(5.dp))
            Row {
                if(discussion.listConversation[lastIndice].userSendTo.id != me) {
                    Spacer(Modifier.width(10.dp))
                    Badge(modifier = Modifier.size(20.dp),containerColor = bagdeColor){
                        Text(msgNonLue.toString(), color = Color.White)
                    }

                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true, device = "id:pixel_5")
fun Prevualisation(){
    //BoxDiscussion(discussionChannel[0])
}