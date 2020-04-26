package com.joancolmenerodev.library_base.presentation.mvp

interface BasePresenter<T> {
    fun onViewReady(view: T)
    fun onViewDestroyed()
}