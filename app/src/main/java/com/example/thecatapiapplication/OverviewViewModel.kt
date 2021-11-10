package com.example.thecatapiapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

enum class CatApiStatus { LOADING, ERROR, DONE }


class OverviewViewModel : ViewModel() {
    private val _status = MutableLiveData<CatApiStatus>()
    val status: LiveData<CatApiStatus> = _status
    private val _photos = MutableLiveData<List<CatPhoto>>()
    val photos: LiveData<List<CatPhoto>> = _photos
    init {
        getCatPhotos()
    }
    private fun getCatPhotos() {
        viewModelScope.launch {
            _status.value = CatApiStatus.LOADING
            try {
                _photos.value = CatApi.retrofitService.getPhotos()
                _status.value = CatApiStatus.DONE
            } catch (e: Exception) {
                _status.value = CatApiStatus.ERROR
                _photos.value = listOf()
            }
        }
    }
}