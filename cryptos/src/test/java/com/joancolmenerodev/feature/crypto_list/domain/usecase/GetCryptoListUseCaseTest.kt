package com.joancolmenerodev.feature.crypto_list.domain.usecase

import com.joancolmenerodev.base.repository.CryptoRepository
import com.joancolmenerodev.feature.crypto_list.domain.exceptions.CryptoListExceptions
import com.joancolmenerodev.feature.crypto_list.domain.model.Crypto
import com.joancolmenerodev.library_base.Either
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test


class GetCryptoListUseCaseTest {

    private lateinit var getCryptoListUseCase: GetCryptoListUseCase
    private val cryptoRepository: CryptoRepository = mockk()

    @Before
    fun setUp() {
        getCryptoListUseCase = GetCryptoListUseCase(cryptoRepository)
    }

    @Test
    fun `given the repository returns the list of crypto then the result is a list of crypto`() {
        //ASSIGN
        coEvery { cryptoRepository.getCoinList(any()) } answers { cryptoList }

        //ACT
        val result = runBlocking { getCryptoListUseCase.execute(CRYPTO_PER_PAGE) }

        //ASSERT
        assertEquals(result, Either.Right(cryptoList))

    }

    @Test
    fun `given the repository returns an CryptoListNotFound then the result is an Either CryptoListNotFound`() {
        //ASSIGN
        val cryptoListNotFoundException = CryptoListExceptions.CryptoListNotFound
        coEvery { cryptoRepository.getCoinList(any()) } throws cryptoListNotFoundException

        //ACT
        val result = runBlocking { getCryptoListUseCase.execute(CRYPTO_PER_PAGE) }

        //ASSERT
        assertEquals(result, Either.Left(cryptoListNotFoundException))

    }

    @Test
    fun `given the repository returns an CryptoListNotAvailable then the result is an Either CryptoListNotAvailable`() {
        //ASSIGN
        val cryptoListNotAvailableException = CryptoListExceptions.CryptoListNotAvailable
        coEvery { cryptoRepository.getCoinList(any()) } throws cryptoListNotAvailableException

        //ACT
        val result = runBlocking { getCryptoListUseCase.execute(CRYPTO_PER_PAGE) }

        //ASSERT
        assertEquals(result, Either.Left(cryptoListNotAvailableException))

    }

    companion object {
        private const val CRYPTO_PER_PAGE = 50
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