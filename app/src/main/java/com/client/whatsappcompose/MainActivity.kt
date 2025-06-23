package com.client.whatsappcompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.client.whatsappcompose.pages.discussions.DiscussionPage
import com.client.whatsappcompose.ui.theme.WhatsAppComposeTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WhatsAppComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    Column() {
                        Spacer(Modifier.height(25.dp))
                        DiscussionPage()
                    }
                }
            }
        }
    }
}

