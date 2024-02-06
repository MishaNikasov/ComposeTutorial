package com.nikasov.composetutorial.architecture

import com.nikasov.composetutorial.components.userAvatar.UserAvatarData
import com.nikasov.composetutorial.components.userItem.UserData

data class HomeScreenState(
    val searchText: String,
    val avatars: List<UserAvatarData>,
    val users: List<UserData>
)
