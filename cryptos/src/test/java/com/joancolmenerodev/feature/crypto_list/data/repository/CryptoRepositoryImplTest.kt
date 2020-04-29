package com.joancolmenerodev.feature.crypto_list.data.repository

import com.joancolmenerodev.feature.crypto_list.data.model.CryptoResponse
import com.joancolmenerodev.feature.crypto_list.data.model.DataDTO
import com.joancolmenerodev.feature.crypto_list.data.model.StatusDTO
import com.joancolmenerodev.feature.crypto_list.data.retrofit.service.CryptoRetrofitService
import com.joancolmenerodev.feature.crypto_list.domain.exceptions.CryptoListExceptions
import com.joancolmenerodev.feature.crypto_list.domain.model.Crypto
import com.joancolmenerodev.feature.crypto_list.domain.repository.CryptoRepository
import com.joancolmenerodev.library_base.service.ClientException
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test


class CryptoRepositoryImplTest {

    private lateinit var coinListRepository: CryptoRepository

    private val mockApi: CryptoRetrofitService = mockk()

    @Before
    fun setUp() {
        coinListRepository = CryptoRepositoryImpl(mockApi)
    }

    @Test
    fun `given the repository returns a coin list`() {

        //ASSIGN
        coEvery { mockApi.getCryptoCurrency() } coAnswers { cryptoResponse }

        val expectedResult = listOf(
            Crypto(1, "Bitcoin", "BTC"),
            Crypto(2, "Litecoin", "LTC")
        )

        //ACT
        val result = runBlocking {
            coinListRepository.getCoinList()
        }

        //ASSERT
        assertEquals(result, expectedResult)
    }

    @Test(expected = CryptoListExceptions.CryptoListNotFound::class)
    fun `given the repository returns a ClientExceptionNotFound then return CryptoListNotFound`() {

        //ASSIGN
        val clientException = ClientException.NotFound
        coEvery { mockApi.getCryptoCurrency() } throws clientException

        //ACT
        runBlocking {
            coinListRepository.getCoinList()
        }
    }

    @Test(expected = CryptoListExceptions.CryptoListNotAvailable::class)
    fun `given the repository returns a ClientException then return CryptoListNotAvailable`() {

        //ASSIGN
        val clientException = ClientException.RequestTimeout
        coEvery { mockApi.getCryptoCurrency() } throws clientException

        //ACT
        runBlocking {
            coinListRepository.getCoinList()
        }
    }

    companion object {
        val cryptoResponse = CryptoResponse(
            data = listOf(
                DataDTO(
                    firstHistoricalData = "2013-04-28T18:47:21.000Z",
                    id = 1,
                    isActive = 1,
                    lastHistoricalData = "2019-11-19T14:29:01.000Z",
                    name = "Bitcoin",
                    platform = "wut",
                    slug = "bitcoin",
                    symbol = "BTC",
                    rank = 2
                ),
                DataDTO(
                    firstHistoricalData = "2013-04-28T18:47:22.000Z",
                    id = 2,
                    isActive = 1,
                    lastHistoricalData = "2019-11-19T14:29:01.000Z",
                    name = "Litecoin",
                    platform = "wut",
                    slug = "litecoin",
                    symbol = "LTC",
                    rank = 2
                )
            ),
            statusDTO = StatusDTO(
                creditCount = 1,
                elapsed = 1,
                errorCode = 1,
                errorMessage = "pew",
                timestamp = "2013-04-28T18:47:22.000Z",
                notice = null
            )
        )
    }
}