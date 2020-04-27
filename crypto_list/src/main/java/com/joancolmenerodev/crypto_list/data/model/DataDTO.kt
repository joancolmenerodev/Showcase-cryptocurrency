package com.joancolmenerodev.crypto_list.data.model


import com.google.gson.annotations.SerializedName

data class DataDTO(
    @SerializedName("first_historical_data")
    val firstHistoricalData: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("is_active")
    val isActive: Int,
    @SerializedName("last_historical_data")
    val lastHistoricalData: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("platform")
    val platform: Any?,
    @SerializedName("rank")
    val rank: Int,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("symbol")
    val symbol: String
)