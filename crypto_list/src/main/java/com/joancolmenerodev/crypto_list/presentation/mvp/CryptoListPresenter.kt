package com.joancolmenerodev.crypto_list.presentation.mvp

import com.joancolmenerodev.crypto_list.domain.model.CoinList
import com.joancolmenerodev.crypto_list.domain.usecase.GetCryptoListUseCase
import com.joancolmenerodev.library_base.ErrorEntity
import com.joancolmenerodev.library_base.presentation.mvp.AbstractPresenter
import com.joancolmenerodev.library_base.threading.CoroutineDispatcherProvider
import kotlinx.coroutines.launch
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
                getCryptoListUseCase.execute()
            }.fold(
                ::handleFailure,
                ::handleCoinList
            )
            view.showProgressBar(false)
        }
    }


    private fun handleFailure(failure: ErrorEntity) {
        when (failure) {
            is ErrorEntity.Network -> {
                view?.networkIssue()
            }
            is ErrorEntity.ServiceUnavailable -> {
                view?.serviceUnavailable()
            }
            is ErrorEntity.Unknown -> {
                view?.unknownError()
            }
        }
    }

    private fun handleCoinList(coinList: List<CoinList>) {
        view?.showResults(coinList)
    }


    override fun onCoinClicked(cryptoId: Int) {
        view?.navigateToCoinDetail(cryptoId = cryptoId)
    }
}
