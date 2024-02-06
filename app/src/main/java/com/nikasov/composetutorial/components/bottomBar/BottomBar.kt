package com.nikasov.composetutorial.components.bottomBar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

//https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/Arrangement

@Composable
fun BottomBar(
    items: List<BottomBarItemData>,
    modifier: Modifier = Modifier,
) {
    var selectedItem by remember { mutableStateOf(BottomBarItemData.Home) }
    Surface(
        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        color = MaterialTheme.colorScheme.background,
        shadowElevation = 6.dp,
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxWidth()
                .padding( top = 4.dp)
        ) {
            items.forEach { itemData ->
                BottomBarItem(
                    data = itemData,
                    isSelected = itemData == selectedItem,
                    onClick = { selectedItem = itemData },
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }

}

@Composable
@Preview
fun BottomBarPreview() {
    BottomBar(items = BottomBarItemData.entries)
}