package com.joancolmenerodev.feature.crypto_detail.data.model

import com.google.gson.annotations.SerializedName

data class StatusDTO(
    @SerializedName("credit_count")
    val creditCount: Int,
    @SerializedName("elapsed")
    val elapsed: Int,
    @SerializedName("error_code")
    val errorCode: Int,
    @SerializedName("error_message")
    val errorMessage: Any,
    @SerializedName("timestamp")
    val timestamp: String
)