package com.gtm.formation.pageObjectModel.webPages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class HomePage(private val driver: WebDriver) {

    @FindBy(id = "ember888")
    private val searchBox: WebElement? = null

    @FindBy(id = "ember891")
    private val searchButton: WebElement? = null

    init {
        PageFactory.initElements(driver, this)
    }

    fun searchDocument(document: String) {
        searchBox?.sendKeys(document)
        searchButton?.click()
    }
}