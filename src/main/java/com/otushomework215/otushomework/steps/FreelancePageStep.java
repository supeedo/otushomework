package com.otushomework215.otushomework.steps;

import com.otushomework215.otushomework.base.BaseStep;
import com.otushomework215.otushomework.pages.FreelancePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class FreelancePageStep extends BaseStep<FreelancePageStep> {

    WebDriver driver;
    FreelancePage page;

    public FreelancePageStep( WebDriver driver ) {
        this.driver = driver;
        this.page = new FreelancePage(driver);
    }

    public FreelancePageStep checkTitle( String title ) {
        Assert.assertEquals(driver.getTitle(), title, "Тайтл страницы не сходятся");
        return this;
    }
}
