package com.joancolmenerodev.feature.crypto_detail.di

import com.joancolmenerodev.feature.crypto_detail.presentation.mvp.CryptoDetailContract
import com.joancolmenerodev.feature.crypto_detail.presentation.mvp.CryptoDetailPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class CryptoDetailPresenterDependenciesModule {

    @Binds
    abstract fun bindCryptoDetailPresenter(presenter: CryptoDetailPresenter): CryptoDetailContract.Presenter
}