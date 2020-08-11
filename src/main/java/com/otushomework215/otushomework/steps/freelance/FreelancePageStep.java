package com.otushomework215.otushomework.steps.freelance;

import com.otushomework215.otushomework.base.BaseStep;
import com.otushomework215.otushomework.pages.freelance.FreelancePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class FreelancePageStep  extends BaseStep<FreelancePageStep> {

    private WebDriver driver;
    private FreelancePage page;

    public FreelancePageStep( WebDriver driver ) {
        this.driver = driver;
        this.page = new FreelancePage(driver);
    }

    @Step("Сверяем Title-text страницы с ожидаемым")
    public FreelancePageStep checkTitle( String title ) {
        Assert.assertEquals(driver.getTitle(), title, "Тайтл страницы не сходятся");
        return this;
    }

    @Step("")
    public FreelancePageStep checkEnableCheckboxOfActivity( String checkboxName ) {
        Assert.assertTrue(page.checkActiveCheckbox(checkboxName), "Чекбокс не активен");
        return this;
    }
}
