package com.google;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class PageObjectChromeInput {
    private WebDriver driver;

    private String searchWord;
    private String selectorSearchField = "//input[@class='gLFyf gsfi']";
    private WebElement searchField;


    PageObjectChromeInput(WebDriver chromeDriver, String word){
        this.driver = chromeDriver;
        this.driver.get("https://www.google.ru/");
        searchWord = word;
        searchField = driver.findElement(By.xpath(selectorSearchField));

    }


    public void search() {
        searchField.click();
        searchField.sendKeys(searchWord);
        searchField.sendKeys(Keys.ENTER);
    }


}

