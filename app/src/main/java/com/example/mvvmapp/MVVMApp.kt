package com.example.mvvmapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MVVMApp: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}