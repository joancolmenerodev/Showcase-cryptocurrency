package com.joancolmenerodev.feature.crypto_detail.domain.usecase

import com.joancolmenerodev.base.repository.CryptoRepository
import com.joancolmenerodev.feature.crypto_detail.domain.exceptions.CryptoDetailExceptions
import com.joancolmenerodev.feature.crypto_detail.domain.model.CryptoDetail
import com.joancolmenerodev.library_base.Either
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test


class GetCryptoDetailUseCaseTest {

    private lateinit var getCryptoDetailUseCase: GetCryptoDetailUseCase
    private val cryptoRepository: CryptoRepository = mockk()

    @Before
    fun setUp() {
        getCryptoDetailUseCase = GetCryptoDetailUseCase(cryptoRepository)
    }

    @Test
    fun `given the repository returns the detail of crypto then the result is the crypto`() {
        //ASSIGN
        coEvery { cryptoRepository.getCoinDetail(any()) } answers { cryptoDetail }

        //ACT
        val result = runBlocking { getCryptoDetailUseCase.execute(CRYPTO_ID) }

        //ASSERT
        assertEquals(result, Either.Right(cryptoDetail))

    }

    @Test
    fun `given the repository returns an CryptoDetailNotFound then the result is an Either Left with CryptoDetailNotFound`() {
        //ASSIGN
        val cryptoDetailNotFoundException = CryptoDetailExceptions.CryptoNotFound
        coEvery { cryptoRepository.getCoinDetail(any()) } throws cryptoDetailNotFoundException

        //ACT
        val result = runBlocking { getCryptoDetailUseCase.execute(CRYPTO_ID) }

        //ASSERT
        assertEquals(result, Either.Left(cryptoDetailNotFoundException))

    }

    @Test
    fun `given the repository returns an CryptoListNotAvailable then the result is an Either Left with CryptoListNotAvailable`() {
        //ASSIGN
        val cryptoDetailNotAvailableException = CryptoDetailExceptions.CryptoUnavailable
        coEvery { cryptoRepository.getCoinDetail(any()) } throws cryptoDetailNotAvailableException

        //ACT
        val result = runBlocking { getCryptoDetailUseCase.execute(CRYPTO_ID) }

        //ASSERT
        assertEquals(result, Either.Left(cryptoDetailNotAvailableException))

    }

    companion object {
        const val CRYPTO_ID = 2
        val cryptoDetail = CryptoDetail(
            logo = "bitcoin.png",
            name = "Bitcoin",
            symbol = "BTC",
            description = "Best crypto ever",
            website = "www.cryptopew.com"
        )
    }


}