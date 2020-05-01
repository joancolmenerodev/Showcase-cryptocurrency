package com.joancolmenerodev.showcase_kotlin.base

import com.joancolmenerodev.showcase_kotlin.App
import com.joancolmenerodev.showcase_kotlin.base.di.DaggerTestAppComponent

open class TestApp : App() {

    override fun onCreate() {
        DaggerTestAppComponent.factory()
            .create(this)
            .inject(this)
    }

}