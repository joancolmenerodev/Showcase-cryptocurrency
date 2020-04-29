package com.joancolmenerodev.feature.crypto_detail.presentation.mvp

import com.joancolmenerodev.feature.crypto_detail.domain.exceptions.CryptoDetailExceptions
import com.joancolmenerodev.feature.crypto_detail.domain.model.CryptoDetail
import com.joancolmenerodev.feature.crypto_detail.domain.usecase.GetCryptoDetailUseCase
import com.joancolmenerodev.library_base.presentation.mvp.AbstractPresenter
import com.joancolmenerodev.library_base.threading.CoroutineDispatcherProvider
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CryptoDetailPresenter @Inject constructor(
    private val getCryptoDetailUseCase: GetCryptoDetailUseCase,
    private val uiContextProviderCoroutine: CoroutineDispatcherProvider
) :
    AbstractPresenter<CryptoDetailContract.View>(uiContextProviderCoroutine),
    CryptoDetailContract.Presenter {

    override fun onViewReady(cryptoId: Int?, view: CryptoDetailContract.View) {
        super.onViewReady(view)

        launch {
            view.showProgressBar(true)
            withContext(uiContextProviderCoroutine.io()) {
                getCryptoDetailUseCase.execute(cryptoId ?: DEFAULT_ID)
            }.fold(
                ::handleFailure,
                ::handleCoinList
            )
            view.showProgressBar(false)
        }
    }

    private fun handleFailure(failure: CryptoDetailExceptions) {
        when (failure) {
            is CryptoDetailExceptions.CryptoNotFound -> {
                view?.notFound()
            }
            is CryptoDetailExceptions.CryptoUnavailable -> {
                view?.serviceUnavailable()
            }
        }
    }

    private fun handleCoinList(cryptoDetail: CryptoDetail) {
        with(cryptoDetail) {
            view?.displayLogo(logo)
            view?.displayName(name)
            view?.displayDescription(description)
            view?.displaySymbol(symbol)
            view?.displayWebsite(website)
        }
    }

}

private const val DEFAULT_ID = -1