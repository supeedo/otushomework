package com.otushomework215.otushomework.base;


import com.otushomework215.otushomework.configuration.WebDriverFactory;
import com.otushomework215.otushomework.configuration.Config;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import java.util.concurrent.TimeUnit;


public class BaseTest {

    protected WebDriverFactory driverFactory = new WebDriverFactory();
    public WebDriver driver;
    protected Config cfg = ConfigFactory.create(Config.class);

    @BeforeTest
    protected void setUp() {
        String browserType = System.getProperty("browser");

        if (browserType == null) driver = driverFactory.createNewDriver("chrome");
        else driver = driverFactory.createNewDriver(browserType);

        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void startUp() {
        driver.navigate().to(cfg.URL());
    }

    @AfterMethod
    public void cleanUp() {
        driver.manage().deleteAllCookies();
    }

    //  @AfterTest
    protected void setDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
