package com.gtm.formation.pageObjectModel.webPages

import com.gtm.formation.pageObjectModel.TestBase
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class BlackHolesPageTest: TestBase() {

    @DisplayName("Testing fun isBlackHolesPageOpened")
    @ParameterizedTest(name = "Case {index}: Testing {0}")
    @CsvSource("OK,true", "KO,false")
    fun testIsBlackHolesPageOpened(case: String, expectedResult: Boolean) {
        if (case == "OK") driver.get("https://www.nasa.gov/black-holes")
        val blackHolesPage = BlackHolesPage(driver)
        Assertions.assertEquals(expectedResult, blackHolesPage.isBlackHolesPageOpened())
    }
}