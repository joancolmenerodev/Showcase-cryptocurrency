package com.joancolmenerodev.feature.crypto_list.data.model


import com.google.gson.annotations.SerializedName
import com.joancolmenerodev.feature.crypto_list.domain.model.Crypto

data class CryptoResponse(
    @SerializedName("data")
    val `data`: List<DataDTO>,
    @SerializedName("status")
    val statusDTO: StatusDTO
)

internal fun CryptoResponse.map() = this.data.map { Crypto(it.id, it.name, it.symbol) }