package com.nikasov.composetutorial.slides

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nikasov.composetutorial.TAG
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun Counter() {
    // Define a state variable for the count
    var count by remember { mutableIntStateOf(0) }

    // Use SideEffect to log the current value of count
    SideEffect {
        // Called on every recomposition
        Log.i(TAG, "Count is $count")
    }

    Column {
        Button(onClick = { count++ }) {
            Text("Increase Count")
        }
        // With every state update, text is changed and recomposition is triggered
        Text("Counter $count")
    }
}

@Composable
fun MyComposable() {
    val isLoading = remember { mutableStateOf(false) }
    val data = remember { mutableStateOf(listOf<String>()) }

    // Define a LaunchedEffect to perform a long-running operation asynchronously
    // `LaunchedEffect` will cancel and re-launch if
    // `isLoading.value` changes
    LaunchedEffect(isLoading.value) {
        if (isLoading.value) {
            // Perform a long-running operation, such as fetching data from a network
            val newData = fetchData()
            // Update the state with the new data
            data.value = newData
            isLoading.value = false
        }
    }

    Column {
        Button(onClick = { isLoading.value = true }) {
            Text("Fetch Data")
        }
        if (isLoading.value) {
            // Show a loading indicator
            CircularProgressIndicator()
        } else {
            // Show the data
            LazyColumn {
                items(data.value.size) { index ->
                    Text(text = data.value[index])
                }
            }
        }
    }
}

// Simulate a network call by suspending the coroutine for 2 seconds
private suspend fun fetchData(): List<String> {
    // Simulate a network delay
    delay(2000)
    return listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5",)
}


@Composable
fun TimerScreen() {
    val elapsedTime = remember { mutableIntStateOf(0) }

    DisposableEffect(Unit) {
        val scope = CoroutineScope(Dispatchers.Default)
        val job = scope.launch {
            while (true) {
                delay(1000)
                elapsedTime.intValue += 1
                Log.i(TAG, ("Timer is still working ${elapsedTime.intValue}"))
            }
        }

        onDispose {
            job.cancel()
        }
    }

    Text(
        text = "Elapsed Time: ${elapsedTime.intValue}",
        modifier = Modifier.padding(16.dp),
        fontSize = 24.sp
    )
}