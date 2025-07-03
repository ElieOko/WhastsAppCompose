package com.client.whatsappcompose.models

import androidx.compose.ui.graphics.vector.ImageVector

data class Parent(
    val id : Int,
    val name : String,
    var isActive : Boolean = false,
    val icon : Int = 0
)
