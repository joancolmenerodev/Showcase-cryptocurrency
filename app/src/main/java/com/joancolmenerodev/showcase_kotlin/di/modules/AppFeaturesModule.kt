package com.joancolmenerodev.showcase_kotlin.di.modules

import com.joancolmenerodev.feature.crypto_list.di.CryptoListModule
import dagger.Module

@Module(includes = [CryptoListModule::class])
object AppFeaturesModule