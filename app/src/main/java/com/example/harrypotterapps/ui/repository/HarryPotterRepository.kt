package com.example.harrypotterapps.ui.repository

import android.util.Log
import com.example.harrypotterapps.api.ApiServiceHarry
import com.example.harrypotterapps.api.model.CharacterDetails
import com.example.harrypotterapps.api.model.MovieCharacters
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HarryPotterRepository
@Inject
constructor(private val apiService: ApiServiceHarry) {

    suspend fun getCharacters(): List<MovieCharacters.HarryPotterCharacters> {
        return withContext(Dispatchers.IO) {
            apiService.getCharacter()
        }
    }

    suspend fun getCharacterDetails(id: String): CharacterDetails {
        return withContext(Dispatchers.IO) {
            apiService.getCharacterDetails(id)
        }
    }

}