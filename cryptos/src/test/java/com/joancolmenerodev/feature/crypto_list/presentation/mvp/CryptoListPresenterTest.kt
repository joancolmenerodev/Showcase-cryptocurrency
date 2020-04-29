package com.joancolmenerodev.feature.crypto_list.presentation.mvp

import com.joancolmenerodev.feature.crypto_list.domain.exceptions.CryptoListExceptions
import com.joancolmenerodev.feature.crypto_list.domain.model.Crypto
import com.joancolmenerodev.feature.crypto_list.domain.usecase.GetCryptoListUseCase
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


class CryptoListPresenterTest {

    @RelaxedMockK
    private lateinit var view: CryptoListContract.View

    @MockK
    private lateinit var getCryptoListUseCase: GetCryptoListUseCase

    private lateinit var presenter: CryptoListPresenter

    @Before
    fun setUp(){
        MockKAnnotations.init(this)
        presenter = CryptoListPresenter(getCryptoListUseCase, TestCoroutineDispatcherProvider())
    }

    @After
    fun tearDown() {
        presenter.onViewDestroyed()
        unmockkAll()
    }

    @Test
    fun `given an user opens the page it loads a list of crypto`(){

        //Assign
        coEvery { getCryptoListUseCase.execute() } answers { Either.Right(cryptoList) }

        //Act
        presenter.onViewReady(view)

        //Assert
        coVerify(exactly = 1) {
            view.showProgressBar(true)
            view.showResults(cryptoList)
            view.showProgressBar(false)
        }
    }

    @Test
    fun `given an user opens the page and there's a problem then it shows a message`(){

        //Assign
        coEvery { getCryptoListUseCase.execute() } answers { Either.Left(CryptoListExceptions.CryptoListNotAvailable) }

        //Act
        presenter.onViewReady(view)

        //Assert
        coVerify(exactly = 1) {
            view.showProgressBar(true)
            view.serviceUnavailable()
            view.showProgressBar(false)
        }
    }

    @Test
    fun `given an user opens the page and there's a problem because there's no list found then it shows a message`(){

        //Assign
        coEvery { getCryptoListUseCase.execute() } answers { Either.Left(CryptoListExceptions.CryptoListNotFound) }

        //Act
        presenter.onViewReady(view)

        //Assert
        coVerify(exactly = 1) {
            view.showProgressBar(true)
            view.listNotFound()
            view.showProgressBar(false)
        }
    }


    companion object {
        val cryptoList = listOf(
            Crypto(
                id = 1,
                name = "Bitcoin",
                symbol = "BTC"
            ),
            Crypto(
                id = 2,
                name = "Liteon",
                symbol = "LTC"
            )
        )
    }


}