package com.adactin.pages.login;

import com.adactin.pages.BasePage;
import com.adactin.pages.search.SearchHotelsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "username")
    WebElement usernameInput;
    @FindBy(id = "password")
    WebElement passwordInput;
    @FindBy(id = "login")
    WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterLoginDetails(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
    }

    public SearchHotelsPage clickLoginButton() {
        loginButton.click();
        return new SearchHotelsPage(driver);
    }
}