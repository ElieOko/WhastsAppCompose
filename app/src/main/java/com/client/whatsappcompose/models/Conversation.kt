package com.client.whatsappcompose.models

import java.io.File

data class Conversation(
    val id : Int,
    val userSendTo : User,
    val userReceiveTo : User,
    val message : String? = null,
    val fileData : File? = null,
    val imageData : File? = null,
    val typeDiscussion: TypeDiscussion? = null,
    var status : Boolean? = null,
    val dateCreated : String = "",
    val time : String = "12:13",
    val isActive : Boolean = true
)
