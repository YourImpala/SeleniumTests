package com.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PageObjectChromeSearchResults {

    private  WebDriver driver;
    private WebElement searchResultsContainer;
    private List<WebElement> searchResults;
    private List<Map<String, Object>> collectResults = new ArrayList<>();

    private String selectorSearchResults = "//div[@id='rso']";
    private String selectorSearchResult = "./div[@class='g']";
    private String selectorLink = "./div[@class='rc']/div[@class='r']/a/h3";

    PageObjectChromeSearchResults(WebDriver chromeDriver) {
        this.driver = chromeDriver;
        searchResultsContainer = driver.findElement(By.xpath(selectorSearchResults));
    }

    public List<WebElement> getResults() {
        searchResults = searchResultsContainer.findElements(By.xpath(selectorSearchResult));
        return searchResults;
    }

    public List<Map<String, Object>> getCollectResults() {
        List<WebElement> searchItems = getResults();
        for(WebElement result : searchItems){
            collectResults.add(Map.of(
                    "WEB_ELEMENT", result,
                    "LINK", result.findElement(By.xpath(selectorLink))
            ));
        }
        return collectResults;
    }

    public List<WebElement> getResultsLinks() {
        List<WebElement> links = new ArrayList<>();

        getCollectResults()
                .stream().forEach(x ->  links.add((WebElement) x.get("LINK")));

        return links;
    }

}
