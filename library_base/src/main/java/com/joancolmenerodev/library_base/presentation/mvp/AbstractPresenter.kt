package com.joancolmenerodev.library_base.presentation.mvp

import com.joancolmenerodev.library_base.threading.CoroutineDispatcherProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

abstract class AbstractPresenter<T : PresenterView>(private val uiContext: CoroutineDispatcherProvider) :
    BasePresenter<T>, CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext = job + uiContext.main()

    var view: T? = null

    override fun onViewDestroyed() {
        this.view = null
        this.job.cancel()
    }

    override fun onViewReady(view: T) {
        this.view = view
    }

}