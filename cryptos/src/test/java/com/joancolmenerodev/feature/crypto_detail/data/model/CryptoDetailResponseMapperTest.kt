package com.joancolmenerodev.feature.crypto_detail.data.model

import com.joancolmenerodev.feature.crypto_detail.domain.model.CryptoDetail
import org.junit.Assert
import org.junit.Test


class CryptoDetailResponseMapperTest {

    @Test
    fun `crypto detail response mapper`() {
        //ASSIGN
        val expectedResult = CryptoDetail(
            logo = "https://s2.coinmarketcap.com/static/img/coins/64x64/6.png",
            name = "Novacoin",
            symbol = "NVC",
            description = "Novacoin (NVC) is a cryptocurrency. Users are able to generate NVC through the process of mining. Novacoin has a current supply of 2,335,756.714. The last known price of Novacoin is $0.286649 USD and is down -11.00% over the last 24 hours. It is currently trading on 2 active market(s) with $712.86 traded over the last 24 hours. More information can be found at http://novacoin.org.",
            website = "http://novacoin.org"
        )

        //ACT
        val result = cryptoDetailResponse.map()

        //ASSERT
        Assert.assertEquals(expectedResult, result)

    }


    companion object {
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
            statusDTO = StatusDTO(
                creditCount = 1,
                elapsed = 15,
                errorCode = 0,
                errorMessage = "pew",
                timestamp = "2019-11-19T14:44:11.576Z"
            )
        )
    }
}