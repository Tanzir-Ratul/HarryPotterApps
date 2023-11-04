package com.example.harrypotterapps.api

import com.example.harrypotterapps.api.model.HarryPotterCharacters
import com.example.harrypotterapps.api.model.MovieCharDetails
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServiceHarry {
    @GET("characters")
    suspend fun getCharacter(): List<HarryPotterCharacters>

    @GET("character/{id}")
    suspend fun getCharacterDetails(@Path("id") id: String): MovieCharDetails
}