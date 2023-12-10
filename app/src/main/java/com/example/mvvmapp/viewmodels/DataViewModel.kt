package com.example.mvvmapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmapp.model.Data
import com.example.mvvmapp.model.ImageData
import com.example.mvvmapp.network.NetworkResult
import com.example.mvvmapp.repositories.Repo
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DataViewModel @Inject constructor(
    private val dataRepo: Repo
) : ViewModel() {
    private var _dataItems =
        MutableStateFlow<NetworkResult<List<ImageData>>>(NetworkResult.Loading(true))
    val dataItems = _dataItems.asStateFlow()

    init {
        getAllData()
    }

    private fun getAllData() {
        viewModelScope.launch {
            kotlin.runCatching {
                _dataItems.value = NetworkResult.Loading(true)
                dataRepo.getData()
            }.onSuccess {
                _dataItems.value = NetworkResult.Success(it.imagesList)
            }.onFailure {
                _dataItems.value = NetworkResult.Failure(it.message?:"Error on Data")
            }
        }
    }
}