package com.joancolmenerodev.networking.retrofit

import com.joancolmenerodev.crypto_list.data.retrofit.service.CryptoRetrofitService
import dagger.Module
import dagger.Provides
import dagger.Reusable
import retrofit2.Retrofit

@Module
object RetrofitServiceModule {

    @Provides
    @Reusable
    fun provideLoginService(retrofit: Retrofit): CryptoRetrofitService {
        return retrofit.create(CryptoRetrofitService::class.java)
    }


}