package com.joancolmenerodev.showcase_kotlin.di

import com.joancolmenerodev.networking.di.NetworkingModule
import com.joancolmenerodev.showcase_kotlin.App
import com.joancolmenerodev.showcase_kotlin.di.modules.AppFeaturesModule
import com.joancolmenerodev.showcase_kotlin.di.modules.CoroutineDispatcherProviderModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        NetworkingModule::class,
        AppFeaturesModule::class,
        CoroutineDispatcherProviderModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: App): AppComponent
    }
}