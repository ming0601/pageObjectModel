package com.gtm.formation.pageObjectModel

import com.gtm.formation.pageObjectModel.utils.UtilResources
import com.gtm.formation.pageObjectModel.webPages.HomePage
import com.gtm.formation.pageObjectModel.webPages.ResultPage
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SearchDocumentTest: TestBase() {
    @Test
    fun searchDocument() {
        val homePage = HomePage(driver)
        homePage.searchDocument(UtilResources.getProperties("nameDocument"))

        val resultPage = ResultPage(driver)
        Assertions.assertTrue(resultPage.isPageOpened())

        resultPage.selectDocument("Black Holes")
        val browserTabs: Set<String> = driver.windowHandles
        driver.switchTo().window(browserTabs.elementAt(0))
        Assertions.assertEquals("Black Holes | NASA", driver.title)
    }
}