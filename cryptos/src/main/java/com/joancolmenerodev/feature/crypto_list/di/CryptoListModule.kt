package com.joancolmenerodev.feature.crypto_list.di

import com.joancolmenerodev.feature.crypto_list.presentation.CryptoListActivity
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