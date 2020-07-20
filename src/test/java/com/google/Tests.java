package com.google;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;


public class Tests extends WebDriverSettings{
    private String URL = "https://www.google.com/";
    private String SEARCH_WORD = "гладиолус";

    public List<WebElement> getInputSearchResults(String url, String searchWord, String element) {
        chromeDriver.get(url);
        PageObjectChromeInput pageObjectInput = new PageObjectChromeInput(chromeDriver);
        pageObjectInput.findByPressEnter(searchWord);

        return pageObjectInput.getResults(element);
    }

    @Test
    public void moreThanThreeSearchResultsAWord() {
        List<WebElement> searchResults = getInputSearchResults(URL, SEARCH_WORD, "body");

        Assertions.assertTrue(
                searchResults.size() > 3,
                "Результатов поиска по заданному слову меньше трёх"
        );
    }

    @Test
    public void theLinkToWikipediaForTheRequestedWordExists() {
        List<WebElement> searchResults = getInputSearchResults(URL, SEARCH_WORD, "link");
        Assertions.assertTrue(
                searchResults.stream().anyMatch(x -> x.getText().contains("ru.wikipedia.org")),
                "Ссылка на википедию отсутствует"
        );
    }
}
