package com.joancolmenerodev.showcase_kotlin.base.di

import com.joancolmenerodev.networking.di.NetworkingModule
import com.joancolmenerodev.showcase_kotlin.base.TestApp
import com.joancolmenerodev.showcase_kotlin.base.di.modules.AppFeaturesModule
import com.joancolmenerodev.showcase_kotlin.base.di.modules.CoroutineDispatcherProviderModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        NetworkingModule::class,
        AppFeaturesModule::class,
        CoroutineDispatcherProviderModule::class]
)
interface TestAppComponent : AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: TestApp): TestAppComponent
    }
}