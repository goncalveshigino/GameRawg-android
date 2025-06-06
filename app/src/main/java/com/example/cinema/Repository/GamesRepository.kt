package com.example.cinema.Repository

import com.example.cinema.data.ApiGames
import com.example.cinema.model.GameList
import com.example.cinema.model.SingleGameModel
import javax.inject.Inject

class GamesRepository @Inject constructor(private val apiGames: ApiGames) {

    suspend fun  getGames(): List<GameList>? {
        val response = apiGames.getGames()

        if (response.isSuccessful) {
            return response.body()?.results
        }

        return null
    }

    suspend fun getGameById(id: Int): SingleGameModel? {
        val response = apiGames.getGameById(id)
        if (response.isSuccessful) {
            return response.body()
        }

        return null
    }
}