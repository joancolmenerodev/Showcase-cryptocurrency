package com.joancolmenerodev.showcase_kotlin.base.espresso

import android.content.Context

abstract class Page(private val context: Context) {

    abstract fun at()

}