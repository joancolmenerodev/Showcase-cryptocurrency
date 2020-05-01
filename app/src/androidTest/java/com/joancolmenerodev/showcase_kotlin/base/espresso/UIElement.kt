package com.joancolmenerodev.showcase_kotlin.base.espresso

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matcher

class UIElement(matcher : Matcher<View>) {

    private val element : ViewInteraction = onView(matcher)

    fun click(){
        element.perform(ViewActions.click())
    }

    fun clickItemAtPosition(position: Int) {
        element.perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(position, ViewActions.click()))
    }

    fun isDisplayed() {
        element.check(matches(ViewMatchers.isDisplayed()))
    }

    fun isNotDisplayed() {
        element.check(doesNotExist())
    }

    fun withText(text: String) {
        element.check(matches(ViewMatchers.withText(text)))
    }

}