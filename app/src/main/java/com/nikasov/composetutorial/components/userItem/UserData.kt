package com.nikasov.composetutorial.components.userItem

import com.nikasov.composetutorial.components.userAvatar.UserAvatarData

data class UserData(
    val userAvatarData: UserAvatarData,
    val name: String,
    val specialty: String,
    val lastSeen: String,
    val lastMessage: String,
) {
    companion object {
        val list: List<UserData> = listOf(
            UserData(
                userAvatarData = UserAvatarData.onlineItem,
                name = "Dr. Hanry",
                specialty = "Cardiologist",
                lastSeen = "1 min ago",
                lastMessage = "Hi, nice to meet you. How can i help?",
            ),
            UserData(
                userAvatarData = UserAvatarData.offlineItem,
                name = "Dr. David",
                specialty = "Cardiologist",
                lastSeen = "1 min ago",
                lastMessage = "Hi, nice to meet you. How can i help? Hi, nice to meet you. How can i help? Hi, nice to meet you. How can i help?",
            ),
            UserData(
                userAvatarData = UserAvatarData.onlineItem,
                name = "Dr. Hanry",
                specialty = "Cardiologist",
                lastSeen = "1 min ago",
                lastMessage = "Hi, nice to meet you. How can i help?",
            ),
            UserData(
                userAvatarData = UserAvatarData.onlineItem,
                name = "Dr. David",
                specialty = "Cardiologist",
                lastSeen = "1 min ago",
                lastMessage = "Hi, nice to meet you. How can i help?",
            ),
            UserData(
                userAvatarData = UserAvatarData.offlineItem,
                name = "Dr. Hanry",
                specialty = "Cardiologist",
                lastSeen = "1 min ago",
                lastMessage = "Hi, nice to meet you. How can i help?",
            ),
            UserData(
                userAvatarData = UserAvatarData.offlineItem,
                name = "Dr. David",
                specialty = "Cardiologist",
                lastSeen = "1 min ago",
                lastMessage = "Hi, nice to meet you. How can i help?",
            )
        )
    }
}
