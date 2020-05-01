package com.joancolmenerodev.feature.crypto_detail.data.model

import com.google.gson.annotations.SerializedName

class CryptoDetailDataDTO(
    @SerializedName("category")
    val category: String,
    @SerializedName("date_added")
    val dateAdded: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("logo")
    val logo: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("platform")
    val platform: Any,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("symbol")
    val symbol: String,
    @SerializedName("tabs")
    val tags: List<String>,
    @SerializedName("urls")
    val urlsDTO: UrlsDTO
)