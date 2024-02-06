package com.nikasov.composetutorial.components.userAvatar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun UserAvatar(
    data: UserAvatarData,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .size(64.dp)
    ) {
        AsyncImage(
            model = data.avatarUrl,
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clip(CircleShape)
        )
        Box(
            modifier = Modifier
                .padding(6.dp)
                .size(8.dp)
                .clip(CircleShape)
                .align(Alignment.BottomEnd)
                .background(Color(0xF211F707))
        )
    }
}

@Composable
@Preview
fun UserAvatarPreview() {
    UserAvatar(data = UserAvatarData.onlineItem)
}
