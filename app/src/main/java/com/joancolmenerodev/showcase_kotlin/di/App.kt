package com.joancolmenerodev.showcase_kotlin.di

import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class App : Application() , HasAndroidInjector {

    lateinit var application: Application

    @Inject
    lateinit var androidInjector : DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent
            .factory()
            .create(this)
            .inject(this)
        this.application = this
    }
}