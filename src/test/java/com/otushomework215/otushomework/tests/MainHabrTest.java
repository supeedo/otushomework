package com.otushomework215.otushomework.tests;

import com.otushomework215.otushomework.base.BaseTest;
import com.otushomework215.otushomework.steps.MainPageStep;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


@Epic("Тест сайта HABR.COM/RU")
@Owner("Yakovlev Sergey")
public class MainHabrTest extends BaseTest {

    private MainPageStep mainPageStep;

    @BeforeMethod
    public void setUpMethod() {
        mainPageStep = new MainPageStep(driver);
    }

    @Feature("Главная страница")
    @Test(description = "Проверка открытия главной страницы")
    public void checkMainPage() {
        mainPageStep
                .checkHeaderTextOnPage("Все потоки");
    }

    @Feature("Главная страница")
    @Test(description = "Проверка отрабатывания кнопок верхнего навигационного меню")
    public void checkButtonOnTopMenu() {
        mainPageStep
                .checkHeaderTextOnPage("Все потоки")
                .useButtonOnTopMenu("Разработка")
                .checkHeaderTextOnPage("Разработка")
                .useButtonOnTopMenu("Администрирование")
                .checkHeaderTextOnPage("Администрирование")
                .useButtonOnTopMenu("Дизайн")
                .checkHeaderTextOnPage("Дизайн")
                .useButtonOnTopMenu("Менеджмент")
                .checkHeaderTextOnPage("Менеджмент")
                .useButtonOnTopMenu("Маркетинг")
                .checkHeaderTextOnPage("Маркетинг")
                .useButtonOnTopMenu("Научпоп")
                .checkHeaderTextOnPage("Научпоп")
        ;
    }

    @Feature("Главная страница")
    @Test(description = "Проверка соответствия URL, при взаимодействии с кнопками центрального меню")
    public void checkUrlOnUseTabsMenu() {
        mainPageStep
                .useButtonOnTabsMenu("Новости")
                .checkURL("https://habr.com/ru/news/")
                .useButtonOnTabsMenu("Хабы")
                .checkURL("https://habr.com/ru/hubs/")
                .useButtonOnTabsMenu("Авторы")
                .checkURL("https://habr.com/ru/users/")
                .useButtonOnTabsMenu("Компании")
                .checkURL("https://habr.com/ru/companies/");
    }

    @Feature("Главная страница")
    @Test(description = "Проверка соответствия Title, при взаимодействии с кнопками центрального меню" +
            "")
    public void checkTitleOnUseTabsMenu() {
        mainPageStep
                .useButtonOnTabsMenu("Новости")
                .checkTitle("ИТ Новости на Хабре: главные новости технологий")
                .useButtonOnTabsMenu("Хабы")
                .checkTitle("Хабы / Хабр")
                .useButtonOnTabsMenu("Авторы")
                .checkTitle("Пользователи - Топ 100 / Хабр")
                .useButtonOnTabsMenu("Компании")
                .checkTitle("Компании / Хабр");
    }

    @Feature("Главная страница")
    @Test(description = "Проверка отрабатывания поиска по компаниям")
    public void CHeckCompanySearch() {
        mainPageStep
                .useButtonOnTabsMenu("Компании")
                .checkNameSearchField("Найти компанию")
                .useCenterSearchField("OTUS");
    }

    @Feature("Главная страница")
    @Test(description = "Проверка отрабатывания поиска по авторам")
    public void checkSearchAuthors() {
        mainPageStep
                .useButtonOnTabsMenu("Авторы")
                .checkNameSearchField("Найти пользователя")
                .useCenterSearchField("Philipp Ranzhin");
    }

    @Feature("Главная страница")
    @Test(description = "")
    public void checkSearchHubs() {
        mainPageStep
                .useButtonOnTabsMenu("Хабы")
                .checkNameSearchField("Найти хаб")
                .useCenterSearchField("Programming");
    }

    @Feature("Главная страница")
    @Test(description = "")
    public void checkCountOfCompanyRating() {
        mainPageStep
                .checkCompanyRatingCount(10);
    }

    @Feature("Главная страница")
    @Test(description = "")
    public void checkTransitionOnMainPage() {
        mainPageStep
                .goToMainPageFromDropdownMenu("Сообщество IT-специалистов")
                .checkHeaderTextOnPage("Все потоки");
    }

    @Feature("Главная страница")
    @Test(description = "")
    public void checkTransitionOnQnAPage() {
        mainPageStep
                .goToQnAPageFromDropdownMenu("любые вопросы")
                .checkTitle("Интересные вопросы — Хабр Q&A");
    }

    @Feature("Главная страница")
    @Test(description = "")
    public void checkTransitionOnFreelancePage() {
        mainPageStep
                .goToFreelancePageFromDropdownMenu("Удаленная работа для IT-специалистов")
                .checkTitle("Хабр Фриланс");
    }

    @Feature("Главная страница")
    @Test(description = "")
    public void checkTransitionOnCareerPage() {
        mainPageStep
                .goToCareerPageFromDropdownMenu("Профессиональное развитие")
                .checkTitle("Работа в IT-индустрии — Хабр Карьера");
    }
}
