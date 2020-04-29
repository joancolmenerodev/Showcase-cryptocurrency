package com.joancolmenerodev.base.di

import com.joancolmenerodev.feature.crypto_detail.di.CryptoDetailPresenterDependenciesModule
import com.joancolmenerodev.feature.crypto_detail.presentation.CryptoDetailActivity
import com.joancolmenerodev.feature.crypto_list.di.CryptoListPresenterDependenciesModule
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

    @ContributesAndroidInjector(modules =[CryptoDetailPresenterDependenciesModule::class])
    abstract fun bindCryptoDetailActivity() : CryptoDetailActivity
}