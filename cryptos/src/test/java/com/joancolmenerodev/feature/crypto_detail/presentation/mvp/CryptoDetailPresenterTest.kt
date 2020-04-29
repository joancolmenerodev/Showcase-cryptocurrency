package com.joancolmenerodev.feature.crypto_detail.presentation.mvp

import com.joancolmenerodev.feature.crypto_detail.domain.exceptions.CryptoDetailExceptions
import com.joancolmenerodev.feature.crypto_detail.domain.model.CryptoDetail
import com.joancolmenerodev.feature.crypto_detail.domain.usecase.GetCryptoDetailUseCase
import com.joancolmenerodev.library_base.Either
import com.joancolmenerodev.library_base.threading.TestCoroutineDispatcherProvider
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.unmockkAll
import org.junit.After
import org.junit.Before
import org.junit.Test


class CryptoDetailPresenterTest {

    @RelaxedMockK
    private lateinit var view: CryptoDetailContract.View

    @MockK
    private lateinit var getCryptoDetailUseCase: GetCryptoDetailUseCase

    private lateinit var presenter: CryptoDetailPresenter

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        presenter = CryptoDetailPresenter(getCryptoDetailUseCase, TestCoroutineDispatcherProvider())
    }

    @After
    fun tearDown() {
        presenter.onViewDestroyed()
        unmockkAll()
    }

    @Test
    fun `given an user click on a crypto then it shows the detail of it`() {
        //Assign
        coEvery { getCryptoDetailUseCase.execute(any()) } answers { Either.Right(cryptoDetail) }

        //Act
        presenter.onViewReady(CRYPTO_ID, view)

        //Assert
        coVerify(exactly = 1) {
            view.showProgressBar(true)
            view.displayName(cryptoDetail.name)
            view.displayWebsite(cryptoDetail.website)
            view.displaySymbol(cryptoDetail.symbol)
            view.displayDescription(cryptoDetail.description)
            view.displayLogo(cryptoDetail.logo)
            view.showProgressBar(false)
        }

    }

    @Test
    fun `given an user click on a crypto then crypto service is not available`() {

        //Assign
        coEvery { getCryptoDetailUseCase.execute(any()) } answers {
            Either.Left(
                CryptoDetailExceptions.CryptoUnavailable
            )
        }

        //Act
        presenter.onViewReady(CRYPTO_ID, view)

        //Assert
        coVerify(exactly = 1) {
            view.showProgressBar(true)
            view.serviceUnavailable()
            view.showProgressBar(false)
        }
    }

    @Test
    fun `given an user opens the page and there's a problem because there's no list found then it shows a message`() {

        //Assign
        coEvery { getCryptoDetailUseCase.execute(any()) } answers {
            Either.Left(
                CryptoDetailExceptions.CryptoNotFound
            )
        }

        //Act
        presenter.onViewReady(CRYPTO_ID, view)

        //Assert
        coVerify(exactly = 1) {
            view.showProgressBar(true)
            view.notFound()
            view.showProgressBar(false)
        }
    }

    companion object {

        const val CRYPTO_ID = 2

        private val cryptoDetail = CryptoDetail(
            logo = "http://logo.png",
            name = "Bitcoin",
            symbol = "BTC",
            description = "This is a description of Bitcoin",
            website = "www.bitcoin.io"
        )
    }
}