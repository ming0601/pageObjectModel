package com.gtm.formation.pageObjectModel.webPages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class BlackHolesPage(driver: WebDriver) {

    @FindBy(xpath = ".//*[@id=\"landing-page-banner\"]/div")
    private val pageBanner: WebElement? = null

    init {
        PageFactory.initElements(driver, this)
    }

    fun isBlackHolesPageOpened(): Boolean {
        return pageBanner?.text.toString().contains("Black Holes")
    }
}