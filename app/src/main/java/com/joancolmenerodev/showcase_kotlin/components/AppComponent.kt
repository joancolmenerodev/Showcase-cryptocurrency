package com.joancolmenerodev.showcase_kotlin.components

import com.joancolmenerodev.showcase_kotlin.App
import com.joancolmenerodev.showcase_kotlin.di.modules.AppFeaturesModule
import com.joancolmenerodev.showcase_kotlin.di.modules.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        AppFeaturesModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: App): AppComponent
    }
}