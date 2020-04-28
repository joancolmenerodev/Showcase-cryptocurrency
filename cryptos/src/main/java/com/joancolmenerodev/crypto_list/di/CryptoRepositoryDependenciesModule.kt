package com.joancolmenerodev.crypto_list.di

import com.joancolmenerodev.crypto_list.data.repository.CryptoRepositoryImpl
import com.joancolmenerodev.crypto_list.domain.repository.CryptoRepository
import dagger.Binds
import dagger.Module

@Module
abstract class CryptoRepositoryDependenciesModule {

    @Binds
    abstract fun bindCryptoRepository(repository: CryptoRepositoryImpl): CryptoRepository

}
