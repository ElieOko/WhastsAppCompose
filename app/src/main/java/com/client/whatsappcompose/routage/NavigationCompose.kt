package com.client.whatsappcompose.routage

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

import androidx.navigation.compose.NavHost
import com.client.whatsappcompose.pages.ParentMain
import androidx.navigation.compose.composable
import com.client.whatsappcompose.pages.discussions.Conversation

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
            ParentMain(navHostController)
        }
        composable(ScreenPage.Conversation.name + "/{id}") {navStack->
            val userId = navStack.arguments?.getString("id")
            Conversation(navHostController,userId?.toInt())
        }
    }
}