package com.otushomework215.otushomework.steps;

import com.otushomework215.otushomework.base.BaseStep;
import com.otushomework215.otushomework.pages.CareerPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CareerPageStep extends BaseStep<CareerPageStep> {

    WebDriver driver;
    CareerPage page;

    public CareerPageStep( WebDriver driver ) {
        this.driver = driver;
        this.page = new CareerPage(driver);
    }

    public CareerPageStep checkTitle( String title ) {
        Assert.assertEquals(driver.getTitle(), title, "Тайтл страницы не сходятся");
        return this;
    }
}
