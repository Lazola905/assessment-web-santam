package com.adactin.tests.login;

import com.adactin.pages.login.LoginPage;
import com.adactin.pages.search.SearchHotelsPage;
import com.adactin.tests.BaseTest;
import jdk.jfr.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    LoginPage loginPage;
    SearchHotelsPage searchHotelsPage;

    @BeforeMethod
    public void setup() {
        super.setup();
        loginPage = new LoginPage(getDriver());
    }

    @Test
    @Description("As a user, I should be able to login successfully.")
    public void loginAsUser() {
        loginPage.enterLoginDetails(getCustomConfig().getUsername(), getCustomConfig().getPassword());
        searchHotelsPage = loginPage.clickLoginButton();
        assertTrue(searchHotelsPage.isSearchPageDisplayed());
    }
}