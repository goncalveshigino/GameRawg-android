package com.example.cinema.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cinema.Repository.GamesRepository
import com.example.cinema.model.GameList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import javax.inject.Inject

class GamesViewModel @Inject constructor(private val repository: GamesRepository): ViewModel() {

    private val _games = MutableStateFlow<List<GameList>>(emptyList())
    val games = _games.asStateFlow()

    init {
        fetchGames()
    }

    private fun fetchGames() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val result = repository.getGames()
                _games.value =  result ?: emptyList()
            }
        }
    }
}