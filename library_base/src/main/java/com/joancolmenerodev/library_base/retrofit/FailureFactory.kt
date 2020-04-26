package com.joancolmenerodev.library_base.retrofit

import com.joancolmenerodev.library_base.ErrorEntity
import java.lang.Exception
import java.net.HttpURLConnection.HTTP_BAD_REQUEST

open class FailureFactory {

    open fun handleCode(code: Int) =
        if (code == HTTP_BAD_REQUEST) {
            ErrorEntity.ServiceUnavailable
        } else {
            ErrorEntity.Network
        }

    open fun handleException(e: Exception) = ErrorEntity.Unknown
}