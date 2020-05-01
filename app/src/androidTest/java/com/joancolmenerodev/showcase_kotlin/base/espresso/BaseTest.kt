package com.joancolmenerodev.showcase_kotlin.base.espresso

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.After
import org.junit.Before
import org.junit.Rule

abstract class BaseTest<T : Activity> {

    abstract fun getTestActivity(): IntentsTestRule<T>
    val context: Context = InstrumentationRegistry.getInstrumentation().targetContext

    fun at(page: Page) {
        page.at()
    }

    @Rule
    @JvmField
    var activityTestRule = this.getTestActivity()

    @Before
    open fun setUp() {
        //Should be IdlingRegistry register
    }

    fun launchActivity(intent: Intent?) {
        getTestActivity().launchActivity(intent)
    }

    @After
    fun tearDown() {
        activityTestRule.finishActivity()
        //Should be IdlingRegistry unregister
    }

}