package com.joancolmenerodev.crypto_list.data.model


import com.google.gson.annotations.SerializedName
import com.joancolmenerodev.crypto_list.domain.model.CoinList

data class CryptoResponse(
    @SerializedName("data")
    val `data`: List<DataDTO>,
    @SerializedName("status")
    val statusDTO: StatusDTO
)

internal fun CryptoResponse.toDomainModel() = this.data.map { CoinList(it.id, it.name, it.symbol) }