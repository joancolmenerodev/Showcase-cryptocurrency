package com.joancolmenerodev.feature.crypto_list.data.repository

import com.joancolmenerodev.base.repository.CryptoRepository
import com.joancolmenerodev.base.repository.CryptoRepositoryImpl
import com.joancolmenerodev.base.retrofit.service.CryptoRetrofitService
import com.joancolmenerodev.feature.crypto_detail.data.model.CryptoDetailDataDTO
import com.joancolmenerodev.feature.crypto_detail.data.model.CryptoDetailResponse
import com.joancolmenerodev.feature.crypto_detail.data.model.UrlsDTO
import com.joancolmenerodev.feature.crypto_detail.domain.exceptions.CryptoDetailExceptions
import com.joancolmenerodev.feature.crypto_detail.domain.model.CryptoDetail
import com.joancolmenerodev.feature.crypto_list.data.model.CryptoResponse
import com.joancolmenerodev.feature.crypto_list.data.model.DataDTO
import com.joancolmenerodev.feature.crypto_list.data.model.StatusDTO
import com.joancolmenerodev.feature.crypto_list.domain.exceptions.CryptoListExceptions
import com.joancolmenerodev.feature.crypto_list.domain.model.Crypto
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
        coinListRepository =
            CryptoRepositoryImpl(mockApi)
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

    @Test
    fun `given the repository returns a coin detail`() {

        //ASSIGN
        coEvery { mockApi.getCryptoInfo(any()) } coAnswers { cryptoDetailResponse }

        //ACT
        val result = runBlocking {
            coinListRepository.getCoinDetail(CRYPTO_ID)
        }

        //ASSERT
        assertEquals(result, expectedCoinDetailResult)
    }

    @Test(expected = CryptoDetailExceptions.CryptoNotFound::class)
    fun `given the repository returns a ClientExceptionNotFound then return CryptoNotFound`() {

        //ASSIGN
        val clientException = ClientException.NotFound
        coEvery { mockApi.getCryptoInfo(any()) } throws clientException

        //ACT
        runBlocking {
            coinListRepository.getCoinDetail(CRYPTO_ID)
        }
    }

    @Test(expected = CryptoDetailExceptions.CryptoUnavailable::class)
    fun `given the repository returns a ClientException then return CryptoUnavailable`() {

        //ASSIGN
        val clientException = ClientException.RequestTimeout
        coEvery { mockApi.getCryptoInfo(any()) } throws clientException

        //ACT
        runBlocking {
            coinListRepository.getCoinDetail(CRYPTO_ID)
        }
    }

    companion object {
        const val CRYPTO_ID = 2
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

        val cryptoDetailResponse = CryptoDetailResponse(
            data = mapOf(
                "1" to CryptoDetailDataDTO(
                    category = "coin",
                    dateAdded = "2013-04-28T00:00:00.000Z",
                    description = "Novacoin (NVC) is a cryptocurrency. Users are able to generate NVC through the process of mining. Novacoin has a current supply of 2,335,756.714. The last known price of Novacoin is $0.286649 USD and is down -11.00% over the last 24 hours. It is currently trading on 2 active market(s) with $712.86 traded over the last 24 hours. More information can be found at http://novacoin.org.",
                    id = 6,
                    logo = "https://s2.coinmarketcap.com/static/img/coins/64x64/6.png",
                    name = "Novacoin",
                    platform = "null",
                    slug = "novacoin",
                    symbol = "NVC",
                    tags = listOf<String>("mineable"),
                    urlsDTO = UrlsDTO(
                        announcement = listOf(
                            "https://bitcointalk.org/index.php?topic=143221.0"
                        ),
                        chat = listOf<String>(),
                        explorer = listOf<String>("https://explorer.novaco.in/"),
                        messageBoard = emptyList<String>(),
                        reddit = listOf<String>("https://reddit.com/r/Novacoin"),
                        sourceCode = listOf<String>("https://github.com/novacoin-project/novacoin"),
                        twitter = emptyList<String>(),
                        website = listOf<String>("http://novacoin.org")
                    )
                )
            )
            ,
            statusDTO = com.joancolmenerodev.feature.crypto_detail.data.model.StatusDTO(
                creditCount = 1,
                elapsed = 15,
                errorCode = 0,
                errorMessage = "pew",
                timestamp = "2019-11-19T14:44:11.576Z"
            )
        )

        val expectedCoinDetailResult = CryptoDetail(
            logo = "https://s2.coinmarketcap.com/static/img/coins/64x64/6.png",
            name = "Novacoin",
            symbol = "NVC",
            description = "Novacoin (NVC) is a cryptocurrency. Users are able to generate NVC through the process of mining. Novacoin has a current supply of 2,335,756.714. The last known price of Novacoin is $0.286649 USD and is down -11.00% over the last 24 hours. It is currently trading on 2 active market(s) with $712.86 traded over the last 24 hours. More information can be found at http://novacoin.org.",
            website = "http://novacoin.org"
        )
    }
}