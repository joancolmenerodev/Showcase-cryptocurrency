package com.joancolmenerodev.library_base.repository

import io.mockk.mockk
import org.junit.Assert
import org.junit.Test

class BaseRepositoryTest {

    private var baseRepository: BaseRepository = mockk()

    @Test
    fun `given we want to execute a String then we receive the same String as a result`() {

        //Assign
        val word = "Woof"

        //Act
        val result = baseRepository.execute { word }

        //Assert
        Assert.assertEquals(word, result)
    }

}