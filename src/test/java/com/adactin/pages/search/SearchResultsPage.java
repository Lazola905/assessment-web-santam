package com.adactin.pages.search;

import com.adactin.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Objects;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "(//form//table)[2]//tr[position() > 1]//td[2]//input")
    List<WebElement> hotelNames;
    @FindBy(xpath = "(//form//table)[2]//tr[position() > 1]//td[3]//input")
    List<WebElement> hotelLocations;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isEachHotelNameValid(String selectedHotel) {
        return hotelNames.stream()
                .map(input -> input.getAttribute("value"))
                .filter(Objects::nonNull)
                .allMatch(name -> name.equals(selectedHotel));
    }

    public boolean isEachHotelLocationValid(String selectedLocation) {
        return hotelLocations.stream()
                .map(input -> input.getAttribute("value"))
                .filter(Objects::nonNull)
                .allMatch(name -> name.equals(selectedLocation));
    }
}