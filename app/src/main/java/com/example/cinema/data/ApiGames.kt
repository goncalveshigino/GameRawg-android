package com.example.cinema.data

import android.hardware.usb.UsbEndpoint
import com.example.cinema.model.GamesModel
import com.example.cinema.util.Constants.Companion.API_KEY
import com.example.cinema.util.Constants.Companion.ENDPOINT
import retrofit2.Response
import retrofit2.http.GET

interface ApiGames {

    @GET(ENDPOINT + API_KEY )
    suspend fun  getGames(): Response<GamesModel>

}