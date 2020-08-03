package com.otushomework215.otushomework.steps;

import com.otushomework215.otushomework.base.BaseStep;
import com.otushomework215.otushomework.pages.CareerPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CareerPageStep extends BaseStep<CareerPageStep> {

    private WebDriver driver;
    private CareerPage page;

    public CareerPageStep( WebDriver driver ) {
        this.driver = driver;
        this.page = new CareerPage(driver);
    }

    @Step("Сверяем Title-text страницы с ожидаемым")
    public CareerPageStep checkTitle( String title ) {
        Assert.assertEquals(driver.getTitle(), title, "Тайтл страницы не сходятся");
        return this;
    }
}
