package com.client.whatsappcompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.client.whatsappcompose.pages.ParentMain
import com.client.whatsappcompose.pages.discussions.DiscussionPage
import com.client.whatsappcompose.routage.NavigationCompose
import com.client.whatsappcompose.ui.theme.WhatsAppComposeTheme

class MainActivity : ComponentActivity() {
    private lateinit var navController : NavHostController
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            navController = rememberNavController()
            WhatsAppComposeTheme {
                NavigationCompose(navController)
            }
        }
    }
}

