package com.otushomework215.otushomework.tests;

import com.otushomework215.otushomework.base.BaseTest;
import com.otushomework215.otushomework.steps.FreelancePageStep;
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
    private FreelancePageStep freelancePageStep;

    @BeforeMethod
    public void setUpMethod() {
        mainPageStep = new MainPageStep(driver);
        mainPageStep
                .goToFreelancePageFromDropdownMenu("Удаленная работа для IT-специалистов");
        freelancePageStep = new FreelancePageStep(driver);
    }

    @Feature("Хабр Фриланс")
    @Test(description = "")
    public void a() {
        freelancePageStep
                .useButtonOnCategoryMenuByText("Разработка");
    }

    @Feature("Хабр Фриланс")
    @Test(description = "")
    public void b() {
        freelancePageStep
                .useButtonOnCategoryMenuByText("Тестирование");
    }

    @Feature("Хабр Фриланс")
    @Test(description = "")
    public void c() {
        freelancePageStep
                .useButtonOnCategoryMenuByText("Администрирование");
    }

    @Feature("Хабр Фриланс")
    @Test(description = "")
    public void d() {
        freelancePageStep
                .useButtonOnCategoryMenuByText("Дизайн");
    }

    @Feature("Хабр Фриланс")
    @Test(description = "")
    public void e() {
        freelancePageStep
                .useButtonOnCategoryMenuByText("Контент");
    }

    @Feature("Хабр Фриланс")
    @Test(description = "")
    public void f() {
        freelancePageStep
                .useButtonOnCategoryMenuByText("Маркетинг");
    }

}
