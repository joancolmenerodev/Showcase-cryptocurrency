package com.joancolmenerodev.showcase_kotlin.feature.cryptos.detail

import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.filters.SmallTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.joancolmenerodev.feature.crypto_detail.presentation.CryptoDetailActivity
import com.joancolmenerodev.showcase_kotlin.base.espresso.BaseTest
import com.joancolmenerodev.showcase_kotlin.feature.cryptos.detail.page.CryptoDetailPage
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class CryptoDetailActivityTest : BaseTest<CryptoDetailActivity>() {
    override fun getTestActivity() = IntentsTestRule(CryptoDetailActivity::class.java, true, false)

    private val cryptoDetailPage =
        CryptoDetailPage(
            context
        )

    @Before
    override fun setUp() {
        super.setUp()
        launchActivity(
            CryptoDetailActivity.getCryptoDetailActivityIntent(
                context,
                CRYPTO_ID
            )
        )
    }

    @Test
    @SmallTest
    fun showCryptoDetailGivenACryptoId() {
        //TODO : Avoid this Thread.sleep() with IdlingResources
        Thread.sleep(2000)
        at(cryptoDetailPage)
        cryptoDetailPage.cryptoNameText(CRYPTO_NAME)
    }

    companion object {
        const val CRYPTO_NAME = "Bitcoin"
        const val CRYPTO_ID = 1
    }
}