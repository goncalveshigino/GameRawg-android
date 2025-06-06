package com.example.cinema.data

import com.example.cinema.model.GamesModel
import com.example.cinema.model.SingleGameModel
import com.example.cinema.util.Constants.Companion.API_KEY
import com.example.cinema.util.Constants.Companion.ENDPOINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiGames {

    @GET(ENDPOINT + API_KEY )
    suspend fun  getGames(): Response<GamesModel>

    @GET("$ENDPOINT/{id}$API_KEY")
    suspend fun getGameById(@Path(value = "id")id: Int): Response<SingleGameModel>

}