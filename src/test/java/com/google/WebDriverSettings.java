package com.google;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverSettings {
    WebDriver chromeDriver;

    @BeforeEach
    public void initSettings() {
        System.setProperty("webdriver.chrome.driver", System.getenv("CHROME_DRIVER"));

        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
    }

    @AfterEach
    public void closeBrowser() {
        chromeDriver.quit();
    }



}
