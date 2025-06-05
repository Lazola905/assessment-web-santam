package com.adactin.tests.search;

import com.adactin.pages.login.LoginPage;
import com.adactin.pages.search.SearchHotelsPage;
import com.adactin.pages.search.SearchResultsPage;
import com.adactin.tests.BaseTest;
import jdk.jfr.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.adactin.utils.TestData.HOTEL_LOCATION;
import static com.adactin.utils.TestData.HOTEL_NAME;
import static org.testng.Assert.assertTrue;

@Test
public class SearchHotelsTest extends BaseTest {

    SearchHotelsPage searchPage;

    @BeforeMethod
    public void setup() {
        super.setup();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.enterLoginDetails(getCustomConfig().getUsername(), getCustomConfig().getPassword());
        searchPage = loginPage.clickLoginButton();
    }

    @Description("As a user, I should be able to search for a hotel by name.")
    public void searchForHotelByName() {
        searchPage.selectHotelName(HOTEL_NAME);
        SearchResultsPage searchResultsPage = searchPage.clickSubmitButton();
        assertTrue(searchResultsPage.isEachHotelNameValid(HOTEL_NAME));
    }

    @Description("As a user, I should be able to search for a hotel by location.")
    public void searchForHotelByLocation() {
        searchPage.selectLocation(HOTEL_LOCATION);
        SearchResultsPage searchResultsPage = searchPage.clickSubmitButton();
        assertTrue(searchResultsPage.isEachHotelLocationValid(HOTEL_LOCATION));
    }
}