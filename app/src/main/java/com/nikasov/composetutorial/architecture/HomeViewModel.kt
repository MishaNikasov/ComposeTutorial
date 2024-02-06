package com.nikasov.composetutorial.architecture

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nikasov.composetutorial.components.userAvatar.UserAvatarData
import com.nikasov.composetutorial.components.userItem.UserData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(): ViewModel() {

    private val searchText = MutableStateFlow("")
    private val avatars = MutableStateFlow<List<UserAvatarData>>(emptyList())
    private val users = MutableStateFlow<List<UserData>>(emptyList())

    val screenState: StateFlow<HomeScreenState> = combine(searchText, avatars, users) { searchText, avatars, users ->
        HomeScreenState(
            searchText = searchText,
            avatars = avatars,
            users = users,
        )
    }.stateIn(viewModelScope, SharingStarted.Lazily, HomeScreenState(searchText.value, avatars.value, users.value))

    fun loadData() {
        viewModelScope.launch {
            delay(1000)
            avatars.update { UserAvatarData.list }
            delay(1000)
            users.update { UserData.list }
        }
    }

    fun search(query: String) {
        searchText.update { query }
    }

}