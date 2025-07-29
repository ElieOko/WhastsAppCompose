package com.client.whatsappcompose.constantes

import com.client.whatsappcompose.models.Conversation
import com.client.whatsappcompose.models.TypeDiscussion
import com.client.whatsappcompose.models.User
import com.client.whatsappcompose.R
import com.client.whatsappcompose.models.Contact

object FakeData {
    val typeDiscussionList = listOf<TypeDiscussion>(
        TypeDiscussion(id = 1, title = "Toutes",),
        TypeDiscussion(id = 2, title = "Non lues plus de ", true),
        TypeDiscussion(id = 3, title = "Favoris"),
        TypeDiscussion(id = 4, title = "Groupes"),
        TypeDiscussion(id = 5, title = "+"),
    )

    val discussion = listOf<Conversation>(

        Conversation(
            id = 2,
            userSendTo = User(id = 1, username = "Kedy "),
            userReceiveTo = User(id = 3, username = "David", profil = R.drawable.kedy),
            message = "Bonjour",
            status = false
        ),
        Conversation(
            id = 3,
            userSendTo = User(id = 1, username = "Kedy"),
            userReceiveTo = User(id = 3, username = "Gedeon", profil = R.drawable.gedeon),
            message = "Bonjour position...",
            time = "19:45"
        ),
        Conversation(
            id = 4,
            userSendTo = User(id = 4, username = "Terence", profil = R.drawable.hilaire),
            userReceiveTo = User(id = 1, username = "Kedy"),
            message = "Jambo",
            time = "15:10"
        ),
        Conversation(
            id = 5,
            userSendTo = User(id = 4, username = "Terence", profil = R.drawable.hilaire),
            userReceiveTo = User(id = 1, username = "Kedy"),
            message = "Niko apa",
            time = "15:12"
        )
    )
    val listContact = listOf<Contact>(
        Contact(id = 1, user = User(id = 2, username = "Hilaire", profil = R.drawable.hilaire)),
        Contact(id = 2, user = User(id = 3, username = "Gedeon", profil = R.drawable.gedeon)),
        Contact(id=3, user = User(id = 3, username = "David", profil = R.drawable.kedy)),
        Contact(id = 4, user =User(id = 4, username = "Terence", profil = R.drawable.hilaire))


    )
}