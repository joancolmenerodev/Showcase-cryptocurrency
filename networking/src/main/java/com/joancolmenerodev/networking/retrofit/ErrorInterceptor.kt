package com.joancolmenerodev.networking.retrofit

import com.joancolmenerodev.library_base.service.ClientException
import com.joancolmenerodev.library_base.service.ServerException
import com.joancolmenerodev.library_base.service.ServiceException
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import java.net.HttpURLConnection
import javax.inject.Inject

class ErrorInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response =
        try {
            val response = chain.proceed(chain.request())
            if (!response.isSuccessful) {
                when (response.code) {
                    HttpURLConnection.HTTP_UNAVAILABLE -> throw ServerException.ServiceUnavailable

                    HttpURLConnection.HTTP_NOT_FOUND -> throw ClientException.NotFound

                    else -> throw ServiceException(IllegalStateException("The status code ${response.code} was received but not handled!"))
                }
            }
            response
        } catch (error: IOException) {
            throw ServiceException(error)
        }
}

