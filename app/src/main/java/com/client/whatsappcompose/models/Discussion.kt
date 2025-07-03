package com.client.whatsappcompose.models

data class Discussion(
    val id: Int,
    val contact: Contact,
    val listConversation: List<Conversation> = emptyList(),
    var isSelect: Boolean = false,
    var isFavorite: Boolean = false
)
