package com.adactin.pages.search;

import com.adactin.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

    @FindBy(xpath = "//td['Search Hotel ']")
    WebElement searchPageTitle;
    @FindBy(xpath = "//td['Welcome to Adactin Group of Hotels']")
    WebElement welcomeTitle;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSearchPageDisplayed() {
        return searchPageTitle.isDisplayed() && welcomeTitle.isDisplayed();
    }
}