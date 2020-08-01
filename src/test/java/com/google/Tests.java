package com.google;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import java.util.List;


public class Tests extends WebDriverSettings{

    @Test
    public void Test1() {
        PageObjectChromeInput pageObjectChromeInput = new PageObjectChromeInput(chromeDriver, "гладиолус");
        Steps.checkCurrentPage(chromeDriver, "Google");
        pageObjectChromeInput.search();
        Steps.checkSearchPage(chromeDriver, "гладиолус - Поиск в Google");
        PageObjectChromeSearchResults pageObjectChromeSearchResults = new PageObjectChromeSearchResults(chromeDriver);
        List<WebElement> results = pageObjectChromeSearchResults.getResults();
        Steps.checkNumberOfResultsIsMoreThanThree(chromeDriver, results);
    }

    @Test
    public void Test2() {
        PageObjectChromeInput pageObjectChromeInput = new PageObjectChromeInput(chromeDriver, "гладиолус");
        Steps.checkCurrentPage(chromeDriver, "Google");
        pageObjectChromeInput.search();
        Steps.checkSearchPage(chromeDriver,"гладиолус - Поиск в Google");
        PageObjectChromeSearchResults pageObjectChromeSearchResults = new PageObjectChromeSearchResults(chromeDriver);
        List<WebElement> links = pageObjectChromeSearchResults.getResultsLinks();
        Steps.checkForLink(chromeDriver, links, "Шпажник — Википедия");
    }
}
