package com.example.mvvmapp.model

import retrofit2.http.GET

interface ApiService {

    @GET("sample-data/photos")
    suspend fun getPhotos() : Data
}