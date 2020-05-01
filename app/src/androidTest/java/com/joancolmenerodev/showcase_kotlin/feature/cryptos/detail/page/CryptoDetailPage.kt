package com.joancolmenerodev.showcase_kotlin.feature.cryptos.detail.page

import android.content.Context
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.joancolmenerodev.showcase_kotlin.R
import com.joancolmenerodev.showcase_kotlin.base.espresso.Page
import com.joancolmenerodev.showcase_kotlin.base.espresso.UIElement

class CryptoDetailPage (context: Context) : Page(context = context) {
    private val constraintParentCryptoDetail = UIElement(withId(R.id.main_constraintLayout_crypto_detail))
    private val cryptoName = UIElement(withId(R.id.tv_cryptoName))

    override fun at() {
        constraintParentCryptoDetail.isDisplayed()
    }

    fun cryptoNameText(text: String) {
        cryptoName.withText(text)
    }
}