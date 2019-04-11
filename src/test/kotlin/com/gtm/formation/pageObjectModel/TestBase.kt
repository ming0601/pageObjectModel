package com.gtm.formation.pageObjectModel

import com.gtm.formation.pageObjectModel.utils.UtilResources
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import java.net.URI
import java.util.concurrent.TimeUnit

abstract class TestBase {
    lateinit var driver: WebDriver

    private set

    @BeforeEach
    fun setup() {
        System.setProperty(
            UtilResources.getProperties("nameDriver"),
            UtilResources.getProperties("pathDriver") +
                    UtilResources.getProperties("exeDriver")
        )
        driver = ChromeDriver()
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS)
        driver.get(URI(UtilResources.getProperties("pageURL")).toString())
    }

    @AfterEach
    fun driverClose() {
        driver.close()
    }
}