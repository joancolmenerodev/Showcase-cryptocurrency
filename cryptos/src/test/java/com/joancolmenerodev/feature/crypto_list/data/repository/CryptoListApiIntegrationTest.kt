package com.joancolmenerodev.feature.crypto_list.data.repository

import com.joancolmenerodev.IntegrationTest
import com.joancolmenerodev.feature.crypto_list.data.model.CryptoResponse
import com.joancolmenerodev.feature.crypto_list.data.model.DataDTO
import com.joancolmenerodev.feature.crypto_list.data.model.StatusDTO
import com.joancolmenerodev.library_base.exceptions.ServiceException
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import java.net.HttpURLConnection

class CryptoListApiIntegrationTest : IntegrationTest() {

    @Test
    fun `given that the coin list is called then it returns success`() {
        // ASSIGN
        val expectedResult = cryptoResponse
        mockHttpResponse("coin_list_response.json", HttpURLConnection.HTTP_OK)

        // ACT
        val response = runBlocking {
            apiService.getCryptoCurrency(CRYPTO_PER_PAGE)
        }

        // ASSERT
        assertEquals(expectedResult.toString(), response.toString())
    }

    @Test(expected = ServiceException::class)
    fun `given that the coin list return a failure then it returns failure`() {
        // ASSIGN
        mockHttpResponse("coin_list_response.json", HttpURLConnection.HTTP_UNAVAILABLE)

        // ACT
        runBlocking {
            apiService.getCryptoCurrency(CRYPTO_PER_PAGE)
        }
    }


    companion object {
        private const val CRYPTO_PER_PAGE = 50
        val cryptoResponse = CryptoResponse(
            data = listOf(
                DataDTO(
                    firstHistoricalData = "2013-04-28T18:47:21.000Z",
                    id = 1,
                    isActive = 1,
                    lastHistoricalData = "2019-11-20T14:09:00.000Z",
                    name = "Bitcoin",
                    platform = null,
                    slug = "bitcoin",
                    symbol = "BTC",
                    rank = 1
                ),
                DataDTO(
                    firstHistoricalData = "2013-04-28T18:47:22.000Z",
                    id = 2,
                    isActive = 1,
                    lastHistoricalData = "2019-11-20T14:09:00.000Z",
                    name = "Litecoin",
                    platform = null,
                    slug = "litecoin",
                    symbol = "LTC",
                    rank = 6
                )
            ),
            statusDTO = StatusDTO(
                creditCount = 1,
                elapsed = 15,
                errorCode = 0,
                errorMessage = null,
                timestamp = "2019-11-20T14:10:48.012Z",
                notice = null
            )
        )
    }
}