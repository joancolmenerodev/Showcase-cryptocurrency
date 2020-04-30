package com.joancolmenerodev.feature.crypto_detail.repository

import com.joancolmenerodev.IntegrationTest
import com.joancolmenerodev.feature.crypto_detail.data.model.CryptoDetailDataDTO
import com.joancolmenerodev.feature.crypto_detail.data.model.CryptoDetailResponse
import com.joancolmenerodev.feature.crypto_detail.data.model.StatusDTO
import com.joancolmenerodev.feature.crypto_detail.data.model.UrlsDTO
import com.joancolmenerodev.library_base.exceptions.ServiceException
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import java.net.HttpURLConnection

class CryptoDetailApiIntegrationTest : IntegrationTest() {
    @Test
    fun `given that the detail coin is called then it returns success`() {
        // ASSIGN
        val expectedResult = cryptoDetailResponse
        mockHttpResponse(COIN_DETAIL_RESPONSE_JSON, HttpURLConnection.HTTP_OK)

        val response = runBlocking {
            // ACT
            apiService.getCryptoInfo(CRYPTO_ID)
        }

        // ASSERT
        assertEquals(expectedResult.data.keys, response.data.keys)
    }

    @Test(expected = ServiceException::class)
    fun `given that the detail coin is called then it returns failure`() {
        // ASSIGN
        mockHttpResponse(COIN_DETAIL_RESPONSE_JSON, HttpURLConnection.HTTP_INTERNAL_ERROR)

        runBlocking {
            // ACT
            apiService.getCryptoInfo(CRYPTO_ID)
        }
    }

    companion object {
        const val CRYPTO_ID = 2
        const val COIN_DETAIL_RESPONSE_JSON = "coin_detail_response.json"
        val cryptoDetailResponse = CryptoDetailResponse(
            data = mapOf(
                "2" to CryptoDetailDataDTO(
                    category = "coin",
                    dateAdded = "2013-04-28T00:00:00.000Z",
                    description = "Litecoin is a peer-to-peer cryptocurrency created by Charlie Lee. It was created based on the Bitcoin protocol but differs in terms of the hashing algorithm used. Litecoin uses the memory intensive Scrypt proof of work mining algorithm. Scrypt allows consumer-grade hardware such as GPU to mine those coins.",
                    id = 2,
                    logo = "https://s2.coinmarketcap.com/static/img/coins/64x64/2.png",
                    name = "Litecoin",
                    platform = "null",
                    slug = "litecoin",
                    symbol = "LTC",
                    tags = listOf<String>("mineable"),
                    urlsDTO = UrlsDTO(
                        announcement = listOf(
                            "https://bitcointalk.org/index.php?topic=47417.0"
                        ),
                        chat = listOf<String>("https://telegram.me/litecoin"),
                        explorer = listOf<String>(
                            "https://blockchair.com/litecoin",
                            "https://chainz.cryptoid.info/ltc/",
                            "http://explorer.litecoin.net/chain/Litecoin",
                            "https://ltc.tokenview.com/en",
                            "https://explorer.viabtc.com/ltc"
                        ),
                        messageBoard = listOf<String>(
                            "https://litecointalk.io/",
                            "https://litecoin-foundation.org/"
                        ),
                        reddit = listOf<String>("https://reddit.com/r/litecoin"),
                        sourceCode = listOf<String>("https://github.com/litecoin-project/litecoin"),
                        twitter = listOf<String>("https://twitter.com/LitecoinProject"),
                        website = listOf<String>("https://litecoin.org/")
                    )
                )
            )
            ,
            statusDTO = StatusDTO(
                creditCount = 1,
                elapsed = 8,
                errorCode = 0,
                errorMessage = "null",
                timestamp = "2019-11-20T14:12:25.772Z"
            )
        )
    }

}