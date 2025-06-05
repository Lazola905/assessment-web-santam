package com.adactin.tests;

import com.adactin.utils.CustomConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class BaseTest {

    private WebDriver driver;
    private CustomConfig customConfig;

    @BeforeMethod
    public void setup() {
        Properties properties = new Properties();
        Path configPath = Paths.get("src", "test", "resources", "config.properties");

        try {
            InputStream inputStream = Files.newInputStream(configPath);
            properties.load(inputStream);
            customConfig = new CustomConfig(properties);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(properties.getProperty("uri"));
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public CustomConfig getCustomConfig() {
        return this.customConfig;
    }

    @AfterMethod
    public void tearDown() {
        if (this.driver != null) {
            driver.quit();
        }
    }
}
