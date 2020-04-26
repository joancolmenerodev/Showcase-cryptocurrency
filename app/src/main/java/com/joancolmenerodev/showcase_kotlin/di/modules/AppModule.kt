package com.joancolmenerodev.showcase_kotlin.di.modules

import android.content.Context
import com.joancolmenerodev.showcase_kotlin.App
import dagger.Module
import dagger.Provides

@Module
object AppModule {

    @Provides
    fun provideContext(application: App) : Context = application.applicationContext

    @Provides
    fun provideApplication(application: App) : App = application
}