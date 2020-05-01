package com.joancolmenerodev.feature.crypto_detail.domain.exceptions

sealed class CryptoDetailExceptions : Exception() {
    object CryptoNotFound : CryptoDetailExceptions()
    object CryptoUnavailable : CryptoDetailExceptions()
}