package com.gtm.formation.pageObjectModel.webPages

import com.gtm.formation.pageObjectModel.TestBase
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class ResultPageTest: TestBase() {

    @DisplayName("Testing fun isPageOpened")
    @ParameterizedTest(name = "Case {index}: Testing {0}")
    @CsvSource("OK, true", "KO, false")
    fun testIsPageOpened(case: String, expectedResult: Boolean) {
        if (case == "OK")
        driver.get("https://nasasearch.nasa.gov/search?query=black+holes&affiliate=nasa&utf8=%E2%9C%93")
        val resultPage = ResultPage(driver)
        Assertions.assertEquals(expectedResult, resultPage.isPageOpened())
    }

    @DisplayName("Testing fun selectDocument")
    @ParameterizedTest(name = "Case {index}: Testing {0}")
    @CsvSource("OK,Black Holes", "KO,anything", "exception,Black Holes")
    fun testSelectDocument(case: String, doc: String) {
        val resultPage = ResultPage(driver)
        when (case) {
            "OK" -> {
                driver.get("https://nasasearch.nasa.gov/search?query=black+holes&affiliate=nasa&utf8=%E2%9C%93")
                Assertions.assertNotNull(resultPage.selectDocument(doc))
            }
            "KO" -> {
                driver.get("https://nasasearch.nasa.gov/search?query=black+holes&affiliate=nasa&utf8=%E2%9C%93")
                val exception = Assertions.assertThrows(Exception::class.java) {resultPage.selectDocument(doc)}
                Assertions.assertTrue(exception.message!!.contains("No matching text in fun selectDocument()!"))
            }
            "exception" -> Assertions.assertThrows(Exception::class.java) {resultPage.selectDocument(doc)}
        }
    }
}