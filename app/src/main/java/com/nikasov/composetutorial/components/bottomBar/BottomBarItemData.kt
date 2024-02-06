package com.nikasov.composetutorial.components.bottomBar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.ui.graphics.vector.ImageVector

enum class BottomBarItemData {
    Home,
    Alert,
    Chat,
    Profile;

    val title: String
        get() = when(this) {
            Home -> "Home"
            Alert -> "Alert"
            Chat -> "Chat"
            Profile -> "Profile"
        }

    val icon: ImageVector
        get() = when(this) {
            Home -> Icons.Default.Home
            Alert -> Icons.Default.Notifications
            Chat -> Icons.Default.Email
            Profile -> Icons.Default.Face
        }
}