package com.client.whatsappcompose.models

import androidx.compose.runtime.Composable

data class PagerItem(
    val dispay : @Composable () -> Unit
)
