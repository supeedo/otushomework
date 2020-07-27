package com.otushomework215.otushomework.steps;

import com.otushomework215.otushomework.utils.ElementUseUtil;
import com.otushomework215.otushomework.base.BaseStep;
import com.otushomework215.otushomework.pages.HabrMainPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MainPageStep extends BaseStep<MainPageStep> {

    WebDriver driver;
    HabrMainPage page;

    public MainPageStep( WebDriver driver ) {
        this.driver = driver;
        this.page = new HabrMainPage(driver);
    }

    @Step("")
    public MainPageStep checkHeaderTextOnPage( String titleText ) {
        Assert.assertEquals(page.getTitle().getText(), titleText, "Header-текст не сходятся");
        return this;
    }

    @Step("")
    public MainPageStep checkAuthorButton() {
        ElementUseUtil.useElement(driver, page.getAutorButton());
        return this;
    }

    @Step("")
    public MainPageStep checkTitle( String title ) {
        Assert.assertEquals(driver.getTitle(), title, "Тайтл страницы не сходятся");
        return this;
    }

    @Step("")
    public MainPageStep checkURL( String url ) {
        Assert.assertEquals(driver.getCurrentUrl(), url, "URL страницы отличается от ожидаемого");
        return this;
    }

    @Step("")
    public MainPageStep useButtonOnTopMenu( String buttonName ) {
        ElementUseUtil.useElement(driver, page.getButtonFromNavigationMenu(buttonName));
        return this;
    }

    @Step("")
    public MainPageStep useButtonOnTabsMenu( String buttonName ) {
        ElementUseUtil.useElement(driver, page.getButtonFromTabsMenu(buttonName));
        return this;
    }

    @Step("")
    public MainPageStep useCenterSearchField( String textMessage ) {
        ElementUseUtil.sendDataInElement(driver, page.getCenterSearchField(), textMessage);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        checkSearchResult(textMessage);
        return this;
    }

    @Step("")
    public MainPageStep checkNameSearchField( String nameField ) {
        Assert.assertEquals(page
                .getCenterSearchField()
                .getAttribute("placeholder"), nameField, "Название строки поиска несоответствует");
        return this;
    }

    @Step("")
    public MainPageStep checkSearchResult( String textResult ) {
        String result = page.getListCompanies().get(0).getText();
        Assert.assertEquals(true, result
                .contains(textResult), "Результат поиска не содержит запрос");

        return this;
    }

    @Step("")
    public MainPageStep checkCompanyRatingCount( int count ) {
        Assert.assertEquals(page
                .getListRatingCompanies().size(), count, "Количество компаний в блоке не сходится");
        return this;
    }

    @Step("")
    public MainPageStep goToMainPageFromDropdownMenu( String descriptionText ) {
        ElementUseUtil.useElement(driver, page.getDropDown());
        ElementUseUtil.useElement(driver, page.getButtonFromDropdownMenu(descriptionText));
        return this;
    }

    @Step("")
    public QnAPageStep goToQnAPageFromDropdownMenu( String descriptionText ) {
        ElementUseUtil.useElement(driver, page.getDropDown());
        ElementUseUtil.useElement(driver, page.getButtonFromDropdownMenu(descriptionText));
        return new QnAPageStep(driver);
    }

    @Step("")
    public FreelancePageStep goToFreelancePageFromDropdownMenu( String descriptionText ) {
        ElementUseUtil.useElement(driver, page.getDropDown());
        ElementUseUtil.useElement(driver, page.getButtonFromDropdownMenu(descriptionText));
        return new FreelancePageStep(driver);
    }

    @Step("")
    public CareerPageStep goToCareerPageFromDropdownMenu( String descriptionText ) {
        ElementUseUtil.useElement(driver, page.getDropDown());
        ElementUseUtil.useElement(driver, page.getButtonFromDropdownMenu(descriptionText));
        return new CareerPageStep(driver);
    }
}
