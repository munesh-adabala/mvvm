package com.example.mvvmapp.repositories

import com.example.mvvmapp.model.Data

interface Repo {
    suspend fun getData(): Data
}