package com.otushomework215.otushomework.pages;

import com.otushomework215.otushomework.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FreelancePage extends BasePage {
    private WebDriver driver;

    public FreelancePage( WebDriver driver ) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
