package com.joancolmenerodev.library_base

import com.joancolmenerodev.library_base.threading.CoroutineDispatcherProvider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher

class TestCoroutineDispatcherProvider : CoroutineDispatcherProvider {
    override fun default(): CoroutineDispatcher {
        return TestCoroutineDispatcher()
    }

    override fun io(): CoroutineDispatcher {
        return TestCoroutineDispatcher()
    }

    override fun main(): CoroutineDispatcher {
        return TestCoroutineDispatcher()
    }
}