package com.example.harrypotterapps.ui.repository

import android.util.Log
import com.example.harrypotterapps.api.ApiServiceHarry
import com.example.harrypotterapps.api.model.HarryPotterCharacters
import com.example.harrypotterapps.api.model.MovieCharDetails
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HarryPotterRepository
@Inject
constructor(private val apiService: ApiServiceHarry) {

    suspend fun getCharacters(): List<HarryPotterCharacters> {
        return withContext(Dispatchers.IO) {
            apiService.getCharacter()
        }
    }

    suspend fun getCharacterDetails(id: String): MovieCharDetails {
        return withContext(Dispatchers.IO) {
            apiService.getCharacterDetails(id)
        }
    }

}