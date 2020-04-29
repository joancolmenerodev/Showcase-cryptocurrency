package com.joancolmenerodev.feature.crypto_detail.presentation.mvp

import com.joancolmenerodev.library_base.presentation.mvp.BasePresenter
import com.joancolmenerodev.library_base.presentation.mvp.PresenterView

interface CryptoDetailContract {
    interface View : PresenterView {
        fun displayLogo(logo: String)
        fun displayName(name: String)
        fun displaySymbol(symbol: String)
        fun displayDescription(description: String)
        fun displayWebsite(website: String)
        fun showProgressBar(isVisible: Boolean)
        fun notFound()
        fun serviceUnavailable()
    }

    interface Presenter : BasePresenter<View> {
        fun onViewReady(cryptoId: Int?, view: View)
    }
}