package com.joancolmenerodev.feature.crypto_list.domain.exceptions

sealed class CryptoListExceptions : Exception() {
    object CryptoListNotAvailable : CryptoListExceptions()
    object CryptoListNotFound : CryptoListExceptions()
}