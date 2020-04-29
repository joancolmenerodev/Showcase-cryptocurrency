package com.joancolmenerodev.base.di

import com.joancolmenerodev.base.repository.CryptoRepositoryImpl
import com.joancolmenerodev.base.repository.CryptoRepository
import dagger.Binds
import dagger.Module

@Module
abstract class CryptoRepositoryDependenciesModule {

    @Binds
    abstract fun bindCryptoRepository(repository: CryptoRepositoryImpl): CryptoRepository

}
