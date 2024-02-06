package com.nikasov.composetutorial.components.bottomBar

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nikasov.composetutorial.ui.theme.ComposeTutorialTheme
import com.nikasov.composetutorial.ui.theme.noRippleClickable

@Composable
fun BottomBarItem(
    data: BottomBarItemData,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {

    Box(
        modifier = modifier
            .height(54.dp)
            .noRippleClickable { onClick() }
    ) {
        AnimatedVisibility(
            visible = isSelected,
            enter = fadeIn(),
            exit = fadeOut(),
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .height(6.dp)
                .width(20.dp)
                .align(Alignment.TopCenter)
        ) {
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Color(0xFF4C17AF))
            )
        }
        Icon(
            imageVector = data.icon,
            contentDescription = data.name,
            modifier = Modifier
                .align(Alignment.Center)
                .size(20.dp)
        )
        AnimatedVisibility(
            visible = isSelected,
            enter = fadeIn(),
            exit = fadeOut(),
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            Text(
                text = data.title,
                lineHeight = 1.sp,
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }
    }

}

@Composable
@Preview
fun BottomBarItemPreview() {
    ComposeTutorialTheme {
        BottomBarItem(
            data = BottomBarItemData.Home,
            isSelected = true,
            onClick = { }
        )
    }
}