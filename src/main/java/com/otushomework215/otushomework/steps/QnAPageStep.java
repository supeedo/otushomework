package com.otushomework215.otushomework.steps;

import com.otushomework215.otushomework.base.BaseStep;
import com.otushomework215.otushomework.pages.QnAPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class QnAPageStep extends BaseStep<QnAPageStep> {

    WebDriver driver;
    QnAPage page;

    public QnAPageStep( WebDriver driver ) {
        this.driver = driver;
        this.page = new QnAPage(driver);
    }

    public QnAPageStep checkTitle( String title ) {
        Assert.assertEquals(driver.getTitle(), title, "Тайтл страницы не сходятся");
        return this;
    }
}
