package com.joancolmenerodev.showcase_kotlin.di.modules

import com.joancolmenerodev.base.di.CryptoListModule
import dagger.Module

@Module(includes = [CryptoListModule::class])
object AppFeaturesModule