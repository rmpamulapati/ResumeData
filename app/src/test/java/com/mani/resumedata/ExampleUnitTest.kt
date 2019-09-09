package com.mani.resumedata

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun checkEmailCorrectness() {
        assertTrue(MainActivity().isValidEmail("sample@gmail.com"))
    }

    @Test
    fun checkEmailInCorrectness() {
        assertFalse(MainActivity().isValidEmail("234"))
    }
}
