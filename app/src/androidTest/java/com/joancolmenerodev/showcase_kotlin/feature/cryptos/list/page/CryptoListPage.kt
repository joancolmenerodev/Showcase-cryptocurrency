package com.joancolmenerodev.showcase_kotlin.feature.cryptos.list.page

import android.content.Context
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.joancolmenerodev.showcase_kotlin.R
import com.joancolmenerodev.showcase_kotlin.base.espresso.Page
import com.joancolmenerodev.showcase_kotlin.base.espresso.UIElement

class CryptoListPage(context: Context) : Page(context = context) {

    private val recyclerView = UIElement(withId(R.id.rv_crypto_currency_list))
    private val constraintParentCryptoList = UIElement(withId(R.id.main_constraintLayout_crypto_list))

    override fun at() {
        constraintParentCryptoList.isDisplayed()
    }

    fun isRecyclerViewFilled(){
        recyclerView.clickItemAtPosition(FIRST_POSITION_RECYCLER_VIEW)
    }


    companion object {
        const val FIRST_POSITION_RECYCLER_VIEW = 0
    }
}