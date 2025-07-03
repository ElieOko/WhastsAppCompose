package com.client.whatsappcompose.pages.discussions

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.client.whatsappcompose.R
import com.client.whatsappcompose.composants.core.BoxDiscussion
import com.client.whatsappcompose.composants.core.TopBarActionMode
import com.client.whatsappcompose.models.Contact
import com.client.whatsappcompose.models.Conversation
import com.client.whatsappcompose.models.Discussion
import com.client.whatsappcompose.models.TypeDiscussion
import com.client.whatsappcompose.models.User
import com.client.whatsappcompose.ui.theme.bagdeColor
import com.client.whatsappcompose.ui.theme.wsColor

@Composable
fun DiscussionPage(){
    DiscussionBody()
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnrememberedMutableState", "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DiscussionBody(){
    val scrollHorizontal = rememberScrollState()
    val scrollVertical = rememberScrollState()
    val local = LocalContext.current
    val discussionSelect: SnapshotStateList<Discussion> = remember { mutableStateListOf() }
    val discussionChannelNonLue : SnapshotStateList<Discussion>  = remember { mutableStateListOf() }
    val positionChannel = remember { mutableIntStateOf(1) }
    val colorState = remember { mutableStateOf(true) }
    val activeChip = remember { mutableStateOf(true) }
    val countNoRead = remember { mutableStateOf("") }
    val discussionChannel: SnapshotStateList<Discussion> =  remember {
        mutableStateListOf(
                Discussion(
                    id = 1,
                    contact = Contact(id = 1, user = User(id = 2, username = "Hilaire", profil = R.drawable.hilaire)),
                    listConversation = listOf(
                        Conversation(
                            id = 1,
                            userSendTo = User(id = 1, username = "Kedy "),
                            userReceiveTo = User(id = 2, username = "Hilaire", profil = R.drawable.hilaire),
                            message = "Lobi nako...",
                            time = "22:10",
                            status = true
                        ),
                    )
                ),
                Discussion(
                    id = 2,
                    contact = Contact(id = 2, user = User(id = 3, username = "Gedeon", profil = R.drawable.gedeon)),
                    listConversation = listOf(
                        Conversation(
                            id = 3,
                            userSendTo = User(id = 1, username = "Kedy"),
                            userReceiveTo = User(id = 3, username = "Gedeon", profil = R.drawable.gedeon),
                            message = "Bonjour position...",
                            time = "19:45"
                        ),
                    )
                ),
                Discussion(
                    id = 3,
                    contact = Contact(id=3, user = User(id = 3, username = "David", profil = R.drawable.kedy)),
                    listConversation = listOf(
                        Conversation(
                            id = 2,
                            userSendTo = User(id = 1, username = "Kedy "),
                            userReceiveTo = User(id = 3, username = "David", profil = R.drawable.kedy),
                            message = "Bonjour",
                            status = false
                        ),
                    )
                ),
                Discussion(
                    id = 4,
                    contact = Contact(id = 4, user =User(id = 4, username = "Terence", profil = R.drawable.hilaire)),
                    listConversation = listOf(
                        Conversation(
                            id = 4,
                            userSendTo = User(id = 4, username = "Terence", profil = R.drawable.hilaire),
                            userReceiveTo = User(id = 1, username = "Kedy"),
                            message = "Jambo",
                            time = "15:10",
                            status = false
                        ),
                        Conversation(
                            id = 5,
                            userSendTo = User(id = 4, username = "Terence", profil = R.drawable.hilaire),
                            userReceiveTo = User(id = 1, username = "Kedy"),
                            message = "Niko apa",
                            time = "15:12",
                            status = false
                        )
                    )
                )
        )
    }
    val typeDiscussionList =  remember {
        mutableStateListOf(
            TypeDiscussion(id = 1, title = "Toutes",true),
            TypeDiscussion(id = 2, title = "Non lues "),
            TypeDiscussion(id = 3, title = "Favoris "),
            TypeDiscussion(id = 4, title = "Groupes "),
            TypeDiscussion(id = 5, title = "+"),
        )
    }
    Scaffold(topBar = {
        if(discussionSelect.count() != 0){
            TopBarActionMode(discussionSelect.count(), onclick = {
                discussionSelect.clear()
                discussionChannel.forEachIndexed { index, discussion ->
                    discussionChannel[index] = discussion.copy(isSelect = false)
                }
                discussionChannelNonLue.forEachIndexed { index, discussion ->
                    discussionChannelNonLue[index] = discussion.copy(isSelect = false)
                }
            })
        }
        else{
            activeChip.value = true
            TopAppBar(
                title = {
                    Text("WhatsApp", color = bagdeColor, fontWeight = FontWeight.Bold)
                },
                actions = {
                IconButton(onClick = {}) {
                    Icon(painter = painterResource(R.drawable.camera), null, modifier = Modifier.size(28.dp))
                }
                IconButton(onClick = {}) {
                    Icon(painter = painterResource(R.drawable.search), null, modifier = Modifier.size(28.dp))
                }
                IconButton(onClick = {}) {
                    Icon(painter = painterResource(R.drawable.menu), null, modifier = Modifier.size(28.dp))
                }
            })
        }
    }) {
        discussionChannel.forEach {discussion ->
            val nomlues: Boolean = discussionChannelNonLue.contains(element = discussion)
            val data = discussion.listConversation.filter { conversation ->
                conversation.status == false && conversation.userSendTo.id != 1
            }.size
            val count = discussionChannelNonLue.filter { nonLue-> nonLue.id == discussion.id }.size
            if (!nomlues && data !=  0 && count == 0){
                discussionChannelNonLue.add(discussion)
                countNoRead.value = discussionChannelNonLue.size.toString()
            }
        }
        Column(modifier = Modifier.fillMaxSize().verticalScroll(scrollVertical)) {
            Spacer(Modifier.height(90.dp))
            Row(modifier = Modifier.horizontalScroll(scrollHorizontal).fillMaxWidth()) {
                Spacer(Modifier.width(15.dp))
                typeDiscussionList.forEachIndexed {indice,it->
                    colorState.value = it.isActive
                    SuggestionChip(
                        enabled = activeChip.value,
                        shape = RoundedCornerShape(35.dp),
                        label = {
                            Text(
                                when(it.id){
                                    1-> it.title
                                    2-> it.title + countNoRead.value
                                    3 -> it.title
                                    4-> it.title
                                    else -> it.title
                                }
                            )
                        },
                        onClick = {
                            typeDiscussionList.forEachIndexed { i, it ->
                                typeDiscussionList[i] = it.copy(isActive = i == indice)
                            }
                            positionChannel.intValue = it.id
                        },
                        colors =  if(it.isActive) SuggestionChipDefaults.suggestionChipColors(wsColor, labelColor = if (!activeChip.value) wsColor else Color.Unspecified, disabledContainerColor = if (!activeChip.value) wsColor else Color.Unspecified) else SuggestionChipDefaults.suggestionChipColors()
                    )
                    Spacer(Modifier.width(10.dp))
                }
            }
            when(positionChannel.intValue){
                1 -> {
                    discussionChannel.forEachIndexed {i,it->
                        BoxDiscussion(it,
                            onlonclickEvent = {
                                if (discussionSelect.count() == 0){
                                    activeChip.value = false
                                    discussionChannel.forEachIndexed { indice, data ->
                                        discussionChannel[indice] = data.copy(isSelect = indice == i)
                                    }
                                    discussionSelect.add(it)
                                }

                            },
                            isSelect = it.isSelect,
                            onclickEvent = {
                                if(discussionSelect.count() != 0){
                                    val updatedSelect = !it.isSelect
                                    if(discussionChannel.any {discussion-> discussion.isSelect }){
                                        discussionChannel.forEachIndexed { indice, data ->
                                            if (data == it) {
                                                discussionChannel[indice] = data.copy(isSelect = updatedSelect)
                                            }
                                        }
                                        if (updatedSelect) {
                                            discussionSelect.add(it)
                                        } else {
                                            discussionSelect.removeIf{d -> d.id == it.id}
                                            Toast.makeText(local, discussionChannel.filter { discussion-> discussion.isSelect }.size.toString(), Toast.LENGTH_LONG).show()
                                        }
                                    }
                                } else{
                                    Toast.makeText(local,"${it.id}", Toast.LENGTH_LONG).show()
                                }
                            }
                        )
                    }
                }
                2 -> {
                    discussionChannelNonLue.forEachIndexed {i, discussion ->
                        BoxDiscussion(
                            discussion,
                            isSelect = discussion.isSelect,
                            onclickEvent = {
                                if(discussionSelect.count() != 0){
                                    val updatedSelect = !discussion.isSelect
                                    if(discussionChannelNonLue.any { discussion-> discussion.isSelect }){
                                        discussionChannelNonLue.forEachIndexed { indice, data ->
                                            if (data == it) {
                                                discussionChannelNonLue[indice] = data.copy(isSelect = updatedSelect)
                                            }
                                        }
                                        if (updatedSelect) {
                                            discussionSelect.add(discussion)
                                        } else {
                                            discussionSelect.removeIf{d -> d.id == discussion.id}
                                            discussionChannelNonLue[i] = discussion.copy(isSelect = false)
                                            Toast.makeText(local, discussionChannelNonLue.filter {discussion-> discussion.isSelect }.size.toString(), Toast.LENGTH_LONG).show()
                                        }
                                    }
                                } else{
                                    Toast.makeText(local,"${discussion.id}", Toast.LENGTH_LONG).show()
                                }
                            },
                            onlonclickEvent = {
                                if (discussionSelect.count() == 0){
                                    activeChip.value = false
                                    discussionChannelNonLue.forEachIndexed { indice, data ->
                                        discussionChannelNonLue[indice] = data.copy(isSelect = indice == i)
                                    }
                                    discussionSelect.add(discussion)
                                }
                            },
                        )
                    }
                }
                3->{

                }
            }

        }
    }

}

@Composable
@Preview(showBackground = true, device = "id:pixel_5")
fun DiscussionPreview(){
    DiscussionBody()
}