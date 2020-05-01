package com.joancolmenerodev.showcase_kotlin.base.di.modules

import com.joancolmenerodev.library_base.threading.CoroutineDispatcherProvider
import com.joancolmenerodev.library_base.threading.DefaultCoroutineDispatcherProvider
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
object CoroutineDispatcherProviderModule {

    @Provides
    @Reusable
    fun provideDefaultCoroutineContextProvider(): CoroutineDispatcherProvider =
        DefaultCoroutineDispatcherProvider()
}