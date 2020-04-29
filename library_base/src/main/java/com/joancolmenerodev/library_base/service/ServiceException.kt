package com.joancolmenerodev.library_base.service

import java.io.IOException

open class ServiceException(override val cause: Exception? = null) : IOException(cause)

sealed class ServerException : ServiceException() {
    object ServiceUnavailable : ServerException()
}

sealed class ClientException : ServiceException() {
    object NotFound : ClientException()
    object RequestTimeout : ClientException()
}