package com.joancolmenerodev.crypto_list.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.joancolmenerodev.crypto_list.R
import com.joancolmenerodev.crypto_list.domain.model.CoinList
import com.joancolmenerodev.crypto_list.presentation.adapter.CryptoListAdapter
import com.joancolmenerodev.crypto_list.presentation.mvp.CryptoListContract
import com.joancolmenerodev.library_base.presentation.extension.toast
import com.joancolmenerodev.library_base.presentation.extension.visible
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_crypto_list.*
import javax.inject.Inject

class CryptoListActivity : AppCompatActivity(), CryptoListContract.View  {

    private lateinit var adapter: CryptoListAdapter
    private lateinit var gridLayoutManager: GridLayoutManager

    @Inject
    lateinit var presenter : CryptoListContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crypto_list)
        AndroidInjection.inject(this)

        initViews()
        presenter.onViewReady(this)
    }

    private fun initViews() {
        gridLayoutManager = GridLayoutManager(this, COLUMNS_GRID)
    }

    override fun showResults(currencyList: List<CoinList>) {
        adapter = CryptoListAdapter(currencyList)
        rv_crypto_currency_list.adapter = adapter
        rv_crypto_currency_list.layoutManager = gridLayoutManager
        adapter.let {
            it.onItemClick = { cryptoId -> presenter.onCoinClicked(cryptoId) }
        }
    }

    override fun showProgressBar(isVisible: Boolean) {
        progressbar_list.visible(isVisible)
    }

    override fun navigateToCoinDetail(cryptoId: Int) {
        Toast.makeText(this,"Not implemented yet",Toast.LENGTH_LONG).show()
    }

    override fun networkIssue() {
        toast(R.string.network_message)
    }

    override fun serviceUnavailable() {
        toast(R.string.service_unavailable_message)
    }

    override fun unknownError() {
        toast(R.string.unknown_error_message)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
    }

}
private const val COLUMNS_GRID = 2