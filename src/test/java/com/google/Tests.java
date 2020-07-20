package com.google;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.List;


public class Tests extends WebDriverSettings{
    private String URL = "https://www.google.com/";
    private String SEARCH_WORD = "гладиолус";

    @Test
    public void moreThanThreeSearchResultsAWord() {
        chromeDriver.get(URL);
        PageObjectChromeInput pageObjectInput = new PageObjectChromeInput(chromeDriver);
        pageObjectInput.findByPressEnter(SEARCH_WORD);
        List<WebElement> searchResults = pageObjectInput.getSearchResults();

        Assertions.assertTrue(
                searchResults.size() > 3,
                "Результатов поиска по заданному слову меньше трёх"
        );
    }

    @Test
    public void theLinkToWikipediaForTheRequestedWordExists() {
        chromeDriver.get(URL);
        PageObjectChromeInput pageObjectInput = new PageObjectChromeInput(chromeDriver);
        pageObjectInput.findByPressEnter(SEARCH_WORD);
        List<WebElement> searchResults = pageObjectInput.getSearchResults();

        Assertions.assertTrue(
                searchResults.stream().anyMatch(x -> x.getText().contains("ru.wikipedia.org")),
                "Ссылка на википедию отсутствует"
        );
    }
}
