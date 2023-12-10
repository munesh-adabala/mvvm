package com.example.mvvmapp.model

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("success")
    val isSuccess: Boolean,
    @SerializedName("total_photos")
    val totalPhotos: Int,
    val limit: Int,
    @SerializedName("photos")
    val imagesList: List<ImageData>
)

