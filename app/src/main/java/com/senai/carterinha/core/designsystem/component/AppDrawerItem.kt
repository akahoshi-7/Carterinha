package com.senai.carterinha.core.designsystem.component

import androidx.compose.ui.graphics.vector.ImageVector

data class AppDrawerItem(
    val label: String,
    val icon: ImageVector,
    val selected: Boolean = false,
    val onClick: () -> Unit
)
