package com.otushomework215.otushomework.steps;

import com.otushomework215.otushomework.steps.career.CareerPageStep;
import com.otushomework215.otushomework.steps.freelance.LandingFreelancePageStep;
import com.otushomework215.otushomework.steps.qna.QnAPageStep;
import com.otushomework215.otushomework.utils.ElementUseUtil;
import com.otushomework215.otushomework.base.BaseStep;
import com.otushomework215.otushomework.pages.HabrMainPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MainPageStep extends BaseStep<MainPageStep> {

    private WebDriver driver;
    private HabrMainPage page;

    public MainPageStep( WebDriver driver ) {
        this.driver = driver;
        this.page = new HabrMainPage(driver);
    }

    @Step("Сверяем Header-text страницы с ожидаемым")
    public MainPageStep checkHeaderTextOnPage( String titleText ) {
        Assert.assertEquals(page.getTitle().getText(), titleText, "Header-текст не сходятся");
        return this;
    }

    @Step("")
    public MainPageStep checkAuthorButton() {
        ElementUseUtil.useElement(driver, page.getAutorButton());
        return this;
    }

    @Step("Сверяем Title-text страницы с ожидаемым")
    public MainPageStep checkTitle( String title ) {
        Assert.assertEquals(driver.getTitle(), title, "Тайтл страницы не сходятся");
        return this;
    }

    @Step("Сверяем URL-страницы с ожидаемым")
    public MainPageStep checkURL( String url ) {
        Assert.assertEquals(driver.getCurrentUrl(), url, "URL страницы отличается от ожидаемого");
        return this;
    }

    @Step("Взаимодействие с кнопкой в Top-menu по тексту")
    public MainPageStep useButtonOnTopMenu( String buttonName ) {
        ElementUseUtil.useElement(driver, page.getButtonFromNavigationMenu(buttonName));
        return this;
    }

    @Step("Взаимодействие с кнопкой в Tabs-menu ")
    public MainPageStep useButtonOnTabsMenu( String buttonName ) {
        ElementUseUtil.useElement(driver, page.getButtonFromTabsMenu(buttonName));
        return this;
    }

    @Step("Взаимодействие с центральной поисковой строкой")
    public MainPageStep useCenterSearchField( String textMessage ) {
        ElementUseUtil.sendDataInElement(driver, page.getCenterSearchField(), textMessage);
        //  временное решение, так как результат поиска обновляется хаотично от 1 до 5 секунд
        // Можно поставить проверку на изменение списка...
        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        checkSearchResult(textMessage);
        return this;
    }

    @Step("Проверка названия поисковой строки")
    public MainPageStep checkNameSearchField( String nameField ) {
        Assert.assertEquals(page
                .getCenterSearchField()
                .getAttribute("placeholder"), nameField, "Название строки поиска несоответствует");
        return this;
    }

    @Step("Проверка содержания запроса в результатах поиска")
    public MainPageStep checkSearchResult( String textResult ) {
        String result = page.getListCompanies().get(0).getText();
        Assert.assertEquals(true, result
                .contains(textResult), "Результат поиска не содержит запрос");
        return this;
    }

    @Step("Проверяем количество компаний в рейтинге")
    public MainPageStep checkCompanyRatingCount( int count ) {
        Assert.assertEquals(page
                .getListRatingCompanies().size(), count, "Количество компаний в блоке не сходится");
        return this;
    }

    @Step("Переход на Main страницу через выпадающее меню")
    public MainPageStep goToMainPageFromDropdownMenu( String descriptionText ) {
        ElementUseUtil.useElement(driver, page.getDropDown());
        ElementUseUtil.useElement(driver, page.getButtonFromDropdownMenu(descriptionText));
        return this;
    }

    @Step("Переход на QnA страницу через выпадающее меню")
    public QnAPageStep goToQnAPageFromDropdownMenu( String descriptionText ) {
        ElementUseUtil.useElement(driver, page.getDropDown());
        ElementUseUtil.useElement(driver, page.getButtonFromDropdownMenu(descriptionText));
        return new QnAPageStep(driver);
    }

    @Step("Переход на Freelance страницу через выпадающее меню")
    public LandingFreelancePageStep goToFreelancePageFromDropdownMenu( String descriptionText ) {
        ElementUseUtil.useElement(driver, page.getDropDown());
        ElementUseUtil.useElement(driver, page.getButtonFromDropdownMenu(descriptionText));
        return new LandingFreelancePageStep(driver);
    }

    @Step("Переход на Career страницу через выпадающее меню")
    public CareerPageStep goToCareerPageFromDropdownMenu( String descriptionText ) {
        ElementUseUtil.useElement(driver, page.getDropDown());
        ElementUseUtil.useElement(driver, page.getButtonFromDropdownMenu(descriptionText));
        return new CareerPageStep(driver);
    }
}
