package com.google;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PageObjectChromeInput {
    private WebDriver chromeDriver;
    private WebElement searchField;


    PageObjectChromeInput(WebDriver chromeDriver){
        this.chromeDriver = chromeDriver;
        this.searchField = chromeDriver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input"));
    }

    public void findByPressEnter(String wordFind){
        searchField.click();
        searchField.sendKeys(wordFind);
        searchField.sendKeys(Keys.ENTER);
    }
    public List<WebElement> getResults(String element) {
        String path = null;

        if(element.equals("body")){
            path = "//*[@id=\"rso\"]//*[@class=\"g\"]";
        }
        else if (element.equals("link")) {
            path = "//*[@class=\"iUh30 bc tjvcx\"]";
        }

        return chromeDriver.findElements(By.xpath(path));
    }
}

