package com.gtm.formation.pageObjectModel.webPages

import com.gtm.formation.pageObjectModel.TestBase
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class HomePageTest: TestBase() {

    @DisplayName("Testing fun searchDocument")
    @ParameterizedTest(name = "Case {index}: Testing {0}")
    @CsvSource("OK,some-doc", "KO,some-doc")
    fun testSearchDocument(case: String, doc: String) {
        val homePage = HomePage(driver)
        when (case) {
            "OK" -> Assertions.assertNotNull(homePage.searchDocument(doc))
            "KO" -> {
                driver.get("https://notworkingsite.com")
                Assertions.assertThrows(Exception::class.java) {homePage.searchDocument(doc)}
            }
        }
    }
}