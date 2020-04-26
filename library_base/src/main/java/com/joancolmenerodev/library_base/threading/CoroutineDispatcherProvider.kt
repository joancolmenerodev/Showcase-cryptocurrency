package com.joancolmenerodev.library_base.threading

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

interface CoroutineDispatcherProvider {

    fun main(): CoroutineDispatcher = Dispatchers.Main
    fun default(): CoroutineDispatcher = Dispatchers.Default
    fun io(): CoroutineDispatcher = Dispatchers.IO
    fun unconfined(): CoroutineDispatcher = Dispatchers.Unconfined

}

class DefaultCoroutineDispatcherProvider : CoroutineDispatcherProvider
