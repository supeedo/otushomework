package com.otushomework215.otushomework.steps.qna;

import com.otushomework215.otushomework.base.BaseStep;
import com.otushomework215.otushomework.pages.QnAPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class QnAPageStep extends BaseStep<QnAPageStep> {

    private WebDriver driver;
    private QnAPage page;

    public QnAPageStep( WebDriver driver ) {
        this.driver = driver;
        this.page = new QnAPage(driver);
    }

    @Step("Сверяем Title-text страницы с ожидаемым")
    public QnAPageStep checkTitle( String title ) {
        Assert.assertEquals(driver.getTitle(), title, "Тайтл страницы не сходятся");
        return this;
    }
}
