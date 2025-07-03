package com.client.whatsappcompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.client.whatsappcompose.pages.ParentMain
import com.client.whatsappcompose.pages.discussions.DiscussionPage
import com.client.whatsappcompose.ui.theme.WhatsAppComposeTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WhatsAppComposeTheme {
                 ParentMain()
            }
        }
    }
}

