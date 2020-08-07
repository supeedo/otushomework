package com.otushomework215.otushomework.configuration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;


public class WebDriverFactory {

    public ChromeDriver get() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    public WebDriver createNewDriver( String browserName ) {
        return createNewDriver(browserName, new DesiredCapabilities());
    }


    public WebDriver createNewDriver( String browserName, DesiredCapabilities options ) {
        browserName = browserName.toLowerCase();

        switch (browserName) {
            case "firefox":
                return getFFInstance(new FirefoxOptions().merge(options));
            case "chrome":
                return getChromeInstance(new ChromeOptions().merge(options));
            default:
                throw new IllegalArgumentException("This browser is not supported!");
        }
    }

    private ChromeDriver getChromeInstance( ChromeOptions options ) {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(options);
    }

    private FirefoxDriver getFFInstance( FirefoxOptions options ) {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver(options);
    }
}
