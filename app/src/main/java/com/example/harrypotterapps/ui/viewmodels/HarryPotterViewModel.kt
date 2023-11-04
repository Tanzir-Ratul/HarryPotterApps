package com.example.harrypotterapps.ui.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.harrypotterapps.api.model.HarryPotterCharacters
import com.example.harrypotterapps.api.model.MovieCharDetails
import com.example.harrypotterapps.ui.repository.HarryPotterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HarryPotterViewModel @Inject constructor(private val repository: HarryPotterRepository) :
    ViewModel() {

    private var _characters = MutableLiveData<List<HarryPotterCharacters?>>()
    var characters: LiveData<List<HarryPotterCharacters?>> = _characters

    private var _starDetails = MutableLiveData<MovieCharDetails?>()
    var starDetails:LiveData<MovieCharDetails?> = _starDetails

    private var _isLoading = MutableLiveData<Boolean>()
    var isLoading: LiveData<Boolean> = _isLoading

    fun getCharacters() {
        _isLoading.value = true
        viewModelScope.launch {
            try {
                val response = repository.getCharacters()
                _characters.value = response
                _isLoading.value = false
            } catch (e: Exception) {
                _isLoading.value = false
                e.printStackTrace()
            }
        }
    }

    fun getCharacterDetails(id: String){
        _isLoading.value = true
        viewModelScope.launch {
          // try {
                val response = repository.getCharacterDetails(id)
                _starDetails.value = response
                Log.d("response", response.toString())
                _isLoading.value = false
            /*}catch (e: Exception){
                _isLoading.value = false
                e.printStackTrace()
            }*/
        }
    }

}