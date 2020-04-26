package com.joancolmenerodev.crypto_list.di

import com.joancolmenerodev.crypto_list.presentation.mvp.CryptoListContract
import com.joancolmenerodev.crypto_list.presentation.mvp.CryptoListPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class CryptoListPresenterDependenciesModule {

    @Binds
    abstract fun bindCryptoListPresenter(presenter: CryptoListPresenter): CryptoListContract.Presenter
}
