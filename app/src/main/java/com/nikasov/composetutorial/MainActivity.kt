package com.nikasov.composetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.nikasov.composetutorial.architecture.HomeScreen
import com.nikasov.composetutorial.ui.theme.ComposeTutorialTheme
import dagger.hilt.android.AndroidEntryPoint

const val TAG = "ComposeTutorialLog"

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeTutorialTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background)
                        .statusBarsPadding()
                        .navigationBarsPadding()
                ) {
//                    var count by remember { mutableStateOf(0) }
                    Column {
                        StatelessCounter(124) {

                        }
                    }
//                    HelloScreen()
                    HomeScreen()
                }
            }
        }
    }
}




















@Composable
fun StatelessCounter(
    count: Int,
    onClick: () -> Unit
) {
    var count by remember { mutableStateOf(count) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = count.toString())
        Button(onClick = {
            count++
        }) {
            count++
            Text(text = "Click")
        }
    }
}








