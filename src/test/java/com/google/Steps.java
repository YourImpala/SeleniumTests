package com.google;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Steps {
    @Step("Шаг 1. Зайти на {name}")
    public static void  checkCurrentPage(WebDriver driver, String name) {
        if (driver.getTitle().equals(name)) {
            Assertions.assertTrue(true);
        }
        else {
            CustomUtils.getScreen(driver);
            Assertions.assertTrue(false, "Открыта не верная страница");
        }
    }

    @Step("Шаг 2. Выполнить поиск по слову гладиолус, title: {name}")
    public  static void checkSearchPage(WebDriver driver, String name){
        if (driver.getTitle().equals(name)){
            Assertions.assertTrue(true);
        }
        else {
            CustomUtils.getScreen(driver);
            Assertions.assertTrue(false, "Открыта не верная страница");
        }
    }

    @Step("Шаг 3. Проверить, что результатов поиска больше трёх")
    public  static void checkNumberOfResultsIsMoreThanThree(WebDriver driver, List<WebElement> results) {
        CustomUtils.getScreen(driver);
        Assertions.assertTrue(
                results.size() > 3,
                "Результатов поиска по заданному слову меньше трёх"
        );
    }

    @Step("Шаг 3. Убедится что есть ссылка {name}")
    public  static void checkForLink(WebDriver driver, List<WebElement> linkList, String name) {
        CustomUtils.getScreen(driver);
        Assertions.assertTrue(
                linkList.stream().anyMatch(x -> x.getText().contains(name)),
                "Ссылка на википедию отсутствует"
        );

    }

}
