package com.client.whatsappcompose.models

data class User(
    val id : Int,
    val username : String,
    val description : String? = null,
    val profil : Int = 0,
    val phone : String? = null
)
