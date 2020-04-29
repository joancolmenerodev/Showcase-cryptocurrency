package com.joancolmenerodev.feature.crypto_detail.domain.exceptions

import java.lang.Exception

sealed class CryptoDetailExceptions : Exception(){
    object CryptoNotFound : CryptoDetailExceptions()
    object CryptoUnavailable : CryptoDetailExceptions()
}