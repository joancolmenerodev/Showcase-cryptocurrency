package com.joancolmenerodev.feature.crypto_list.data.model

import com.joancolmenerodev.feature.crypto_list.domain.model.Crypto
import org.junit.Assert.assertEquals
import org.junit.Test

class CryptoResponseMapperTest {

    @Test
    fun `cryptoCurrency mapper test`() {

        //ASSIGN
        val expectedResult = listOf(
            Crypto(1, "Bitcoin", "BTC"),
            Crypto(2, "Litecoin", "LTC")
        )

        //ACT
        val result = cryptoResponse.map()


        //ASSERT
        assertEquals(expectedResult, result)

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