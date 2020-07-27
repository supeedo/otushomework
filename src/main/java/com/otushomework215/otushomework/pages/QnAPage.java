package com.otushomework215.otushomework.pages;

import com.otushomework215.otushomework.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class QnAPage extends BasePage {
    private WebDriver driver;

    public QnAPage( WebDriver driver ) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
