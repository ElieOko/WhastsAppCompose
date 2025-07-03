package com.client.whatsappcompose.pages

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.BottomAppBar

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.client.whatsappcompose.models.Parent
import com.client.whatsappcompose.R
import com.client.whatsappcompose.models.PagerItem
import com.client.whatsappcompose.pages.discussions.DiscussionPage
import com.client.whatsappcompose.ui.theme.wsColor

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(showBackground = true)
@Composable
fun ParentMain(){
    val listParent = listOf<Parent>(
        Parent(1,"Discussions", icon = R.drawable.discussion),
        Parent(2,"Actus", icon = R.drawable.status),
        Parent(3,"Communautés", icon = R.drawable.people),
        Parent(4,"Appels", icon = R.drawable.call),
    )
    val local = LocalContext.current
    val statePage = rememberPagerState(pageCount = { listParent.size })
    val state = remember { mutableIntStateOf(0) }

    val childreenList = listOf(
        PagerItem{DiscussionPage()},
        PagerItem{ Text("Actus")}.dispay(),
        PagerItem{Text("Communautés")}.dispay(),
        PagerItem{Text("Appels")}.dispay()
    )
    LaunchedEffect(statePage) {
        snapshotFlow { statePage.currentPage }.collect { page ->
            when(page){
                0 -> state.intValue = 0
                1 -> state.intValue = 1
                2 -> state.intValue = 2
                3 -> state.intValue = 3
            }
        }
    }
    Scaffold(bottomBar = {
        NavigationBar {
            listParent.forEachIndexed {i,parent ->
                NavigationBarItem(
                    colors =  NavigationBarItemDefaults.colors(
                        indicatorColor = wsColor
                    ),
                    onClick = {
                        state.intValue = i

                    },
                    selected = i == state.intValue
                    , icon = {
                    Icon(painter = painterResource(parent.icon),null, modifier = Modifier.size(28.dp))
                },
                    label = {Text(parent.name, fontWeight = FontWeight.Bold, fontSize = 12.sp)}
                )
            }

        }
    }) {

        Column(modifier = Modifier.fillMaxSize()) {
//            HorizontalPager(state = statePage) {page->
//                Toast.makeText(local, page.toString(),Toast.LENGTH_LONG).show()
//                CoreUi(statePage.currentPage)
//            }
            CoreUi(state.intValue)
        }
    }
}

@Composable
fun CoreUi(state : Int){
    when(state){
        0 -> DiscussionPage()
        1 -> Text("")
        2 -> Text("")
        3 -> Text("")
    }
}