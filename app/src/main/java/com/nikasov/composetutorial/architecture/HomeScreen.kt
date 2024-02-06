package com.nikasov.composetutorial.architecture

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.nikasov.composetutorial.components.bottomBar.BottomBar
import com.nikasov.composetutorial.components.bottomBar.BottomBarItemData
import com.nikasov.composetutorial.components.searchBar.SearchBar
import com.nikasov.composetutorial.components.topBar.TopBar
import com.nikasov.composetutorial.components.userAvatar.UserAvatar
import com.nikasov.composetutorial.components.userItem.UserCard

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
) {
    LaunchedEffect(true) { viewModel.loadData() }
    val state by viewModel.screenState.collectAsStateWithLifecycle()
    HomeScreenContent(state) { viewModel.search(it) }
}

@Composable
fun HomeScreenContent(
    state: HomeScreenState,
    onSearch: (String) -> Unit
) {
    Scaffold(
        topBar = {
             Column(modifier = Modifier.fillMaxWidth()) {
                 TopBar("Chat Room")
                 SearchBar(
                     query = state.searchText,
                     onQueryChange = { onSearch(it) },
                     modifier = Modifier.padding(16.dp)
                 )
             }
        },
        bottomBar = { BottomBar(items = BottomBarItemData.entries) }
    ) { paddings ->
        Column(
            modifier = Modifier
                .padding(paddings)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .horizontalScroll(rememberScrollState())
                    .padding(horizontal = 16.dp)
            ) {
                state.avatars.map { UserAvatar(data = it, Modifier.size(64.dp)) }
            }
            Spacer(modifier = Modifier.height(21.dp))
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            ) {
                state.users.map { UserCard(userData = it) }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}