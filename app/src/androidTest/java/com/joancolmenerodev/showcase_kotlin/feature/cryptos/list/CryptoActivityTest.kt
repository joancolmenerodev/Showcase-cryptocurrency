package com.joancolmenerodev.showcase_kotlin.feature.cryptos.list

import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.filters.SmallTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.joancolmenerodev.feature.crypto_detail.presentation.CryptoDetailActivity
import com.joancolmenerodev.feature.crypto_list.presentation.CryptoListActivity
import com.joancolmenerodev.showcase_kotlin.base.espresso.BaseTest
import com.joancolmenerodev.showcase_kotlin.feature.cryptos.list.page.CryptoListPage
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class CryptoActivityTest : BaseTest<CryptoListActivity>() {

    override fun getTestActivity() = IntentsTestRule(CryptoListActivity::class.java, true, false)

    private val mainActivityPage = CryptoListPage(context)

    @Before
    override fun setUp() {
        super.setUp()
        launchActivity(null)
    }

    @Test
    @SmallTest
    fun showACryptoListAndTapOnItem() {
        //TODO : Avoid this Thread.sleep() with IdlingResources
        Thread.sleep(2000)
        at(mainActivityPage)
        mainActivityPage.isRecyclerViewFilled()
    }
}