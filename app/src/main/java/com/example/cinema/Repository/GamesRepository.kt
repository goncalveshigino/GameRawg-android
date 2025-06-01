package com.example.cinema.Repository

import com.example.cinema.data.ApiGames
import com.example.cinema.model.GameList
import javax.inject.Inject

class GamesRepository @Inject constructor(private val apiGames: ApiGames) {

    suspend fun  getGames(): List<GameList>? {
        val response = apiGames.getGames()

        if (response.isSuccessful) {
            return response.body()?.results
        }

        return null
    }
}