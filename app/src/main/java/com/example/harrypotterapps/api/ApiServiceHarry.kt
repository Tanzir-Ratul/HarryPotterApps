package com.example.harrypotterapps.api

import com.example.harrypotterapps.api.model.CharacterDetails
import com.example.harrypotterapps.api.model.MovieCharacters
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServiceHarry {
    @GET("characters")
    suspend fun getCharacter(): List<MovieCharacters.HarryPotterCharacters>

    @GET("character/{id}")
    suspend fun getCharacterDetails(@Path("id") id: String): CharacterDetails
}