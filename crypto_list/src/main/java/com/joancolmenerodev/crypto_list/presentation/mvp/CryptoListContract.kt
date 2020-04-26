package com.joancolmenerodev.crypto_list.presentation.mvp

import com.joancolmenerodev.crypto_list.domain.model.CoinList
import com.joancolmenerodev.library_base.presentation.mvp.BasePresenter
import com.joancolmenerodev.library_base.presentation.mvp.PresenterView

interface CryptoListContract {

    interface View : PresenterView {
        fun showResults(currencyList: List<CoinList>)
        fun showProgressBar(isVisible: Boolean)
        fun navigateToCoinDetail(cryptoId: Int)
        fun networkIssue()
        fun serviceUnavailable()
        fun unknownError()
    }

    interface Presenter : BasePresenter<View> {
        fun onCoinClicked(cryptoId: Int)
    }

}