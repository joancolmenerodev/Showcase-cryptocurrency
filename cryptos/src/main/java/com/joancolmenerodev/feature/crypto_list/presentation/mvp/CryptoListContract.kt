package com.joancolmenerodev.feature.crypto_list.presentation.mvp

import com.joancolmenerodev.feature.crypto_list.domain.model.Crypto
import com.joancolmenerodev.library_base.presentation.mvp.BasePresenter
import com.joancolmenerodev.library_base.presentation.mvp.PresenterView

interface CryptoListContract {

    interface View : PresenterView {
        fun showResults(currencyList: List<Crypto>)
        fun showProgressBar(isVisible: Boolean)
        fun navigateToCoinDetail(cryptoId: Int)
        fun serviceUnavailable()
        fun listNotFound()
    }

    interface Presenter : BasePresenter<View> {
        fun onCoinClicked(cryptoId: Int)
    }

}