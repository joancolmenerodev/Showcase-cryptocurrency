package com.joancolmenerodev.feature.crypto_detail.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.joancolmenerodev.feature.crypto_detail.presentation.mvp.CryptoDetailContract
import com.joancolmenerodev.feature.crypto_list.R
import com.joancolmenerodev.library_base.presentation.extension.toast
import com.joancolmenerodev.library_base.presentation.extension.visible
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_crypto_detail.*
import javax.inject.Inject

class CryptoDetailActivity : AppCompatActivity(), CryptoDetailContract.View {

    @Inject
    lateinit var presenter: CryptoDetailContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crypto_detail)
        inject()
        presenter.onViewReady(getCryptoId(), this)

    }

    private fun inject() {
        AndroidInjection.inject(this)
    }

    private fun getCryptoId(): Int? = intent?.extras?.getInt(CRYPTO_ID)

    override fun displayLogo(logo: String) {
        Glide.with(this)
            .load(logo)
            .into(iv_crypto_logo)
    }

    override fun displayName(name: String) {
        tv_cryptoName.text = name
    }

    override fun displaySymbol(symbol: String) {
        tv_cryptoSymbol.text = symbol
    }

    override fun displayDescription(description: String) {
        tv_cryptoDescription.text = description
    }

    override fun displayWebsite(website: String) {
        tv_cryptoWebsite.text = website
    }

    override fun showProgressBar(isVisible: Boolean) {
        progressbar_detail.visible(isVisible)
    }

    override fun notFound() {
        toast(R.string.no_coin_found_detail)
    }

    override fun serviceUnavailable() {
        toast(R.string.service_unavailable_message)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
    }

    companion object {
        var CRYPTO_ID: String = "CRYPTO_ID"
        private const val DEFAULT_CRYPTO_ID = -1

        @JvmStatic
        fun getCryptoDetailActivityIntent(
            context: Context,
            cryptoId: Int? = DEFAULT_CRYPTO_ID
        ): Intent =
            Intent(context, CryptoDetailActivity::class.java)
                .apply {
                    cryptoId?.let { putExtra(CRYPTO_ID, it) }
                }
    }
}
