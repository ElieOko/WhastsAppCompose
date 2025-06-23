package com.client.whatsappcompose.constantes

import com.client.whatsappcompose.models.Conversation
import com.client.whatsappcompose.models.TypeDiscussion
import com.client.whatsappcompose.models.User
import com.client.whatsappcompose.R

object FakeData {
    val typeDiscussionList = listOf<TypeDiscussion>(
        TypeDiscussion(id = 1, title = "Toutes", true),
        TypeDiscussion(id = 2, title = "Non lues plus de "),
        TypeDiscussion(id = 3, title = "Favoris"),
        TypeDiscussion(id = 4, title = "Groupes"),
        TypeDiscussion(id = 5, title = "+"),
    )

    val discussion = listOf<Conversation>(
        Conversation(
            id = 1,
            userSendTo = User(id = 1, username = "Kedy "),
            userReceiveTo = User(id = 2, username = "Hilaire", profil = R.drawable.hilaire),
            message = "Lobi nako...",
            time = "22:10",
            status = true
        ),
        Conversation(
            id = 2,
            userSendTo = User(id = 1, username = "Kedy "),
            userReceiveTo = User(id = 3, username = "David", profil = R.drawable.kedy),
            message = "Bonjour",
            status = false
        ),
        Conversation(
            id = 3,
            userSendTo = User(id = 1, username = "Kedy "),
            userReceiveTo = User(id = 3, username = "Gedeon", profil = R.drawable.gedeon),
            message = "Bonjour position...",
            time = "19:45"
        ),
    )
}