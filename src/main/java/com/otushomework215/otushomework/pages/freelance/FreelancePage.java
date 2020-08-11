package com.otushomework215.otushomework.pages.freelance;

import com.otushomework215.otushomework.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FreelancePage extends BasePage {

    private WebDriver driver;

    @FindBy(xpath = "//dd[@class='layout-block__content']/..")
    private WebElement activity;

    //_________________________________________

    public FreelancePage( WebDriver driver ) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Получение чекбокса по его тексту
    public WebElement getCheckboxOfActivityByText( String checkboxName ) {
        return activity
                .findElement(By
                        .xpath(".//span[contains(text(),'" + checkboxName + "')]/../.."));
    }

    public boolean checkActiveCheckbox (String checkboxName){
        WebElement buffer = getCheckboxOfActivityByText(checkboxName);
        return buffer
                .getAttribute("class")
                .contains("full");
    }
}
