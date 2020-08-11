package com.otushomework215.otushomework.tests;

import com.otushomework215.otushomework.base.BaseTest;
import com.otushomework215.otushomework.steps.freelance.LandingFreelancePageStep;
import com.otushomework215.otushomework.steps.MainPageStep;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Epic("Тест сайта freelance.habr.com")
@Owner("Yakovlev Sergey")
public class LandingFreelanceHabrTest extends BaseTest {

    private MainPageStep mainPageStep;
    private LandingFreelancePageStep landingFreelancePageStep;

    @BeforeMethod
    public void setUpMethod() {
        mainPageStep = new MainPageStep(driver);
        mainPageStep
                .goToFreelancePageFromDropdownMenu("Удаленная работа для IT-специалистов");
        landingFreelancePageStep = new LandingFreelancePageStep(driver);
    }

    @Feature("Хабр Фриланс")
    @Test(description = "Проверяем Переход по меню 'Категории' с проверкой включения фильтра по категории 'Разработка'")
    public void checkButtonDevelopment() {
        landingFreelancePageStep
                .useButtonOnCategoryMenuByText("Разработка")
                .checkEnableCheckboxOfActivity("Разработка");
    }

    @Feature("Хабр Фриланс")
    @Test(description = "Проверяем Переход по меню 'Категории' с проверкой включения фильтра по категории 'Тестирование'")
    public void checkButtonTesting() {
        landingFreelancePageStep
                .useButtonOnCategoryMenuByText("Тестирование")
                .checkEnableCheckboxOfActivity("Тестирование");
    }

    @Feature("Хабр Фриланс")
    @Test(description =
            "Проверяем Переход по меню 'Категории' с проверкой включения фильтра по категории 'Администрирование'")
    public void checkButtonAdministration() {
        landingFreelancePageStep
                .useButtonOnCategoryMenuByText("Администрирование")
                .checkEnableCheckboxOfActivity("Администрирование");
    }

    @Feature("Хабр Фриланс")
    @Test(description = "Проверяем Переход по меню 'Категории' с проверкой включения фильтра по категории 'Дизайн'")
    public void checkButtonDesign() {
        landingFreelancePageStep
                .useButtonOnCategoryMenuByText("Дизайн")
                .checkEnableCheckboxOfActivity("Дизайн");
    }

    @Feature("Хабр Фриланс")
    @Test(description = "Проверяем Переход по меню 'Категории' с проверкой включения фильтра по категории 'Контент'")
    public void checkButtonContent() {
        landingFreelancePageStep
                .useButtonOnCategoryMenuByText("Контент")
                .checkEnableCheckboxOfActivity("Контент");
    }

    @Feature("Хабр Фриланс")
    @Test(description = "Проверяем Переход по меню 'Категории' с проверкой включения фильтра по категории 'Маркетинг'")
    public void checkButtonMarketing() {
        landingFreelancePageStep
                .useButtonOnCategoryMenuByText("Маркетинг")
                .checkEnableCheckboxOfActivity("Маркетинг");
    }

}
