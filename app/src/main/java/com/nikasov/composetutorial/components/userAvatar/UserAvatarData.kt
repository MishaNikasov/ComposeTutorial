package com.nikasov.composetutorial.components.userAvatar

data class UserAvatarData(
    val avatarUrl: String,
    val isOnline: Boolean,
) {
    companion object {
        val onlineItem = UserAvatarData(
            avatarUrl = "https://hips.hearstapps.com/hmg-prod/images/beautiful-smooth-haired-red-cat-lies-on-the-sofa-royalty-free-image-1678488026.jpg?crop=1xw:0.84415xh;center,top",
            isOnline = true
        )
        val offlineItem = UserAvatarData(
            avatarUrl = "https://static.fundacion-affinity.org/cdn/farfuture/xFsdVk-9Vi8ifllknxGrwV-ul0WVSmjXl7DSObD4iLU/mtime:1644939075/sites/default/files/los-10-sonidos-principales-del-gato-fa.jpg",
            isOnline = true
        )
        val list = listOf(
            onlineItem,
            onlineItem,
            offlineItem,
            onlineItem,
            onlineItem,
            onlineItem,
            offlineItem,
            offlineItem,
            offlineItem,
            onlineItem
        )
    }
}
