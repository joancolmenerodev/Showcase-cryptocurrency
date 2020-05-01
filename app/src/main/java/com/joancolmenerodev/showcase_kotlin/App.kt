package com.joancolmenerodev.showcase_kotlin

import android.app.Application
import com.joancolmenerodev.showcase_kotlin.base.di.AppComponent
import com.joancolmenerodev.showcase_kotlin.base.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject


open class App : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.factory()
            .create(this)
            .inject(this)
    }


    open fun getAppComponent(): AppComponent {
        return DaggerAppComponent.factory()
            .create(this)
    }
}