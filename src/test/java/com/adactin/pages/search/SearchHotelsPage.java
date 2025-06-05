package com.adactin.pages.search;

import com.adactin.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchHotelsPage extends BasePage {

    @FindBy(xpath = "//td['Search Hotel ']")
    WebElement searchPageTitle;
    @FindBy(xpath = "//td['Welcome to Adactin Group of Hotels']")
    WebElement welcomeTitle;
    @FindBy(id = "location")
    WebElement locationsDropdown;
    @FindBy(id = "hotels")
    WebElement hotelNamesDropdown;
    @FindBy(id = "Submit")
    WebElement submitButton;

    public SearchHotelsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSearchPageDisplayed() {
        return searchPageTitle.isDisplayed() && welcomeTitle.isDisplayed();
    }

    public void selectHotelName(String hotelName) {
        hotelNamesDropdown.click();
        driver.findElement(By.xpath(String.format("//option[text()='%s']", hotelName))).click();
    }

    public void selectLocation(String location) {
        locationsDropdown.click();
        driver.findElement(By.xpath(String.format("//option[text()='%s']", location))).click();
    }

    public SearchResultsPage clickSubmitButton() {
        submitButton.click();
        return new SearchResultsPage(driver);
    }
}