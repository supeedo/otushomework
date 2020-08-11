package com.otushomework215.otushomework.pages.freelance;

import com.otushomework215.otushomework.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingFreelancePage extends BasePage {
    private WebDriver driver;

    @FindBy(xpath = "//ul[@class='landing-hero__categories']")
    private WebElement categoryMenu;

    //__________________________________________________

    public LandingFreelancePage( WebDriver driver ) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Получение кнопки центрального меню по тексту
    public WebElement getButtonFromCategoryMenu( String nameButton ) {
        return categoryMenu.findElement(By
                .xpath(".//../*[contains(text(),'" + nameButton + "')]"));
    }
}


//   //span[contains(text(),'Разработка')]//../div