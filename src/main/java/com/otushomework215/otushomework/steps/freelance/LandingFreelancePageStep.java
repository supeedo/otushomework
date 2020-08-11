package com.otushomework215.otushomework.steps.freelance;

import com.otushomework215.otushomework.base.BaseStep;
import com.otushomework215.otushomework.pages.freelance.LandingFreelancePage;
import com.otushomework215.otushomework.utils.ElementUseUtil;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LandingFreelancePageStep extends BaseStep<LandingFreelancePageStep> {

    private WebDriver driver;
    private LandingFreelancePage page;

    public LandingFreelancePageStep( WebDriver driver ) {
        this.driver = driver;
        this.page = new LandingFreelancePage(driver);
    }

    @Step("Сверяем Title-text страницы с ожидаемым")
    public LandingFreelancePageStep checkTitle( String title ) {
        Assert.assertEquals(driver.getTitle(), title, "Тайтл страницы не сходятся");
        return this;
    }

    @Step("Взаимодействие с кнопкой в Category-menu по тексту")
    public FreelancePageStep useButtonOnCategoryMenuByText( String buttonName ) {
        ElementUseUtil.useElement(driver, page.getButtonFromCategoryMenu(buttonName));
        return new FreelancePageStep(driver);
    }
}
