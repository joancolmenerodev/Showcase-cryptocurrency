package com.joancolmenerodev.library_base.retrofit

import com.joancolmenerodev.library_base.Either
import com.joancolmenerodev.library_base.ErrorEntity
import retrofit2.Response
import java.io.IOException

inline fun <T, R> Response<T>.safeCall(
    errorFactory: FailureFactory = FailureFactory(),
    transform: (T) -> R
): Either<ErrorEntity, R> =
    try {
        when (this.isSuccessful) {
            true -> Either.Right(transform(this.body()!!))
            false -> Either.Left(errorFactory.handleCode(this.code()))
        }
    } catch (exception: IOException) {
        Either.Left(errorFactory.handleException(exception))
    }