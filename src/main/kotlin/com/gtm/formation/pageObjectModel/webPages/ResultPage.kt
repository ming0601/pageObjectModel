package com.gtm.formation.pageObjectModel.webPages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import java.lang.Exception

class ResultPage(private val driver: WebDriver) {

    @FindBy(id = "best-bets")
    private val bestResult: WebElement? = null

    @FindBy(xpath = ".//*[@id='best-bet-1']/h4/a")
    private val bestResultTitle: WebElement? = null

    init {
        PageFactory.initElements(driver, this)
    }

    fun isPageOpened(): Boolean {
        return bestResult?.text.toString().contains("Recommended by NASA")
    }

    fun selectDocument(selectDoc: String) {
        if (bestResultTitle?.text.toString().contains(selectDoc)) bestResultTitle?.click()
        else throw Exception("No matching text in fun selectDocument()!")
    }
}