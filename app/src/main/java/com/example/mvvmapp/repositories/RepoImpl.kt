package com.example.mvvmapp.repositories

import com.example.mvvmapp.model.ApiService
import com.example.mvvmapp.model.Data
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepoImpl @Inject constructor(
    private val apiService: ApiService
): Repo {
    override suspend fun getData(): Data {
       return apiService.getPhotos()
    }
}