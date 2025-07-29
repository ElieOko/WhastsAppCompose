package com.client.whatsappcompose.routage

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

import androidx.navigation.compose.NavHost
import com.client.whatsappcompose.pages.ParentMain
import androidx.navigation.compose.composable

@Composable
fun NavigationCompose(
    navHostController: NavHostController
){
    NavHost(
        navController = navHostController,
        startDestination = ScreenPage.ParentMain.name,
        route = "root"
    ) {
        composable(ScreenPage.ParentMain.name){
            ParentMain()
        }
        composable(ScreenPage.Conversation.name) {

        }
    }
}