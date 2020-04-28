package com.joancolmenerodev.library_base.service

open class ServiceException(override val cause: Exception? = null) : Exception(cause)

sealed class ServerException : ServiceException() {
    object ServiceUnavailable : ServerException()
}

sealed class ClientException : ServiceException() {
    object NotFound : ClientException()
}