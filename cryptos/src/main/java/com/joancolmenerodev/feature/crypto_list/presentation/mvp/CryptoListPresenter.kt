package com.joancolmenerodev.feature.crypto_list.presentation.mvp

import com.joancolmenerodev.feature.crypto_list.domain.exceptions.CryptoListExceptions
import com.joancolmenerodev.feature.crypto_list.domain.model.Crypto
import com.joancolmenerodev.feature.crypto_list.domain.usecase.GetCryptoListUseCase
import com.joancolmenerodev.library_base.presentation.mvp.AbstractPresenter
import com.joancolmenerodev.library_base.threading.CoroutineDispatcherProvider
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CryptoListPresenter @Inject constructor(
    private val getCryptoListUseCase: GetCryptoListUseCase,
    private val uiContextProviderCoroutine: CoroutineDispatcherProvider
) :
    AbstractPresenter<CryptoListContract.View>(uiContextProviderCoroutine),
    CryptoListContract.Presenter {

    override fun onViewReady(view: CryptoListContract.View) {
        super.onViewReady(view)
        launch {
            view.showProgressBar(isVisible = true)
            withContext(uiContextProviderCoroutine.io()) {
                getCryptoListUseCase.execute(CRYPTOS_PER_PAGE)
            }.fold(
                ::handleFailure,
                ::handleCoinList
            )
            view.showProgressBar(isVisible = false)
        }
    }


    private fun handleFailure(failure: CryptoListExceptions) {
        when (failure) {
            is CryptoListExceptions.CryptoListNotAvailable -> {
                view?.serviceUnavailable()
            }
            is CryptoListExceptions.CryptoListNotFound -> {
                view?.listNotFound()
            }
        }
    }

    private fun handleCoinList(crypto: List<Crypto>) {
        view?.showResults(crypto)
    }


    override fun onCoinClicked(cryptoId: Int) {
        view?.navigateToCoinDetail(cryptoId = cryptoId)
    }
}

private const val CRYPTOS_PER_PAGE = 50
