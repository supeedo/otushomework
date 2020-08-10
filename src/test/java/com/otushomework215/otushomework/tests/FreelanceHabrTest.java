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
public class FreelanceHabrTest extends BaseTest {

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
    @Test(description = "")
    public void a() {
        landingFreelancePageStep
                .useButtonOnCategoryMenuByText("Разработка");
    }

    @Feature("Хабр Фриланс")
    @Test(description = "")
    public void b() {
        landingFreelancePageStep
                .useButtonOnCategoryMenuByText("Тестирование");
    }

    @Feature("Хабр Фриланс")
    @Test(description = "")
    public void c() {
        landingFreelancePageStep
                .useButtonOnCategoryMenuByText("Администрирование");
    }

    @Feature("Хабр Фриланс")
    @Test(description = "")
    public void d() {
        landingFreelancePageStep
                .useButtonOnCategoryMenuByText("Дизайн");
    }

    @Feature("Хабр Фриланс")
    @Test(description = "")
    public void e() {
        landingFreelancePageStep
                .useButtonOnCategoryMenuByText("Контент");
    }

    @Feature("Хабр Фриланс")
    @Test(description = "")
    public void f() {
        landingFreelancePageStep
                .useButtonOnCategoryMenuByText("Маркетинг");
    }

}
