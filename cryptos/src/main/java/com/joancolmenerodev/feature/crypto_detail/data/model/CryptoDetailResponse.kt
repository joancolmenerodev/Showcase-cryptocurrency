package com.joancolmenerodev.feature.crypto_detail.data.model


import com.google.gson.annotations.SerializedName
import com.joancolmenerodev.feature.crypto_detail.domain.model.CryptoDetail

data class CryptoDetailResponse(
    @SerializedName("data")
    val data: Map<String, CryptoDetailDataDTO>,
    @SerializedName("status")
    val statusDTO: StatusDTO
)

internal fun CryptoDetailResponse.map(): CryptoDetail {
    val coin = this.data.values.first()
    return CryptoDetail(
        logo = coin.logo,
        name = coin.name,
        symbol = coin.symbol,
        description = coin.description,
        website = coin.urlsDTO.website.first()
    )

}