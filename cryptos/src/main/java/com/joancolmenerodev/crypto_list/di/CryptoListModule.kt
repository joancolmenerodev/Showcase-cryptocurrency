package com.joancolmenerodev.crypto_list.di

import com.joancolmenerodev.crypto_list.presentation.CryptoListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(
    includes = [
        CryptoRepositoryDependenciesModule::class
    ]
)
abstract class CryptoListModule {

    @ContributesAndroidInjector(modules = [CryptoListPresenterDependenciesModule::class])
    abstract fun bindCryptoListActivity(): CryptoListActivity
}