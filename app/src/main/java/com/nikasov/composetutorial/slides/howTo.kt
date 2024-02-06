package com.nikasov.composetutorial.slides

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TextField(text: String) {
    Text(text = text)
}

@Preview(showBackground = true)
@Composable
fun TextFieldPreview() {
    TextField(text = "Test")
}

@Preview(
    name = "TextField on device",
    device = Devices.PIXEL_7_PRO,
    showSystemUi = true
)
@Composable
fun TextFieldDevicePreview() {
    Text(text = "Test")
}

@Composable
fun TextFields(
    firstText: String,
    secondText: String,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Text(text = firstText)
        Text(text = secondText)
    }
}

@Preview(
    name = "TextField on device",
    device = Devices.PIXEL_7_PRO,
    showSystemUi = true
)
@Composable
fun TextFieldsDevicePreview() {
    TextFields(
        firstText = "Title",
        secondText = "Description",
        onClick = { },
    )
}