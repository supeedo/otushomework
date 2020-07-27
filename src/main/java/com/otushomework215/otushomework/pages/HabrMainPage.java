package com.otushomework215.otushomework.pages;

import com.otushomework215.otushomework.base.BasePage;
import com.otushomework215.otushomework.utils.ElementUseUtil;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Getter
public class HabrMainPage extends BasePage {
    private WebDriver driver;


    //------  панель сервисов ----
    @FindBy(css = "span#dropdown-control")
    private WebElement dropDown;

    //----------------------------

    // кнопка "как стать автором"
    @FindBy(xpath = "//a[@class='bmenu__conversion']")
    private WebElement autorButton;

    // текст в хидере страницы
    @FindBy(xpath = "//div[contains(@class, 'page-header')]")
    private WebElement title;

    // главное навигационное меню
    @FindBy(xpath = "//div[@class='main-navbar']")
    private WebElement navigationBar;

    // меню в центре страницы
    @FindBy(css = "div.tabs__level.tabs-level_top")
    private WebElement tabsMenu;

    //  ----- Компании ----

    // поисковая строка в центре
    @FindBy(xpath = "//div[contains(@class,'search-field')]/input")
    private WebElement centerSearchField;

    // список результатов поиска
    @FindBy(xpath = "//ul[contains(@class,'content-list')]//li")
    private List<WebElement> listCompanies;

    @FindBy(xpath = "//ul[@class= 'companies-rating__list']/li")
    private List<WebElement> listRatingCompanies;

    //_____________________________________

    public HabrMainPage( WebDriver driver ) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Получение кнопки навигационного меню по тексту
    public WebElement getButtonFromNavigationMenu( String nameButton ) {
        return navigationBar
                .findElement(By.xpath(".//li[@class='nav-links__item']/a[contains(text(),'" + nameButton + "')]"));
    }

    // Получение кнопки центрального меню по тексту
    public WebElement getButtonFromTabsMenu( String nameButton ) {
        return tabsMenu.findElement(By
                .xpath(".//a[contains(@class,'tabs-menu__item')]/h3[contains(text(),'" + nameButton + "')]"));
    }

    // получение кнопки сервисов из dropdown меню
    public WebElement getButtonFromDropdownMenu( String messageButton ) {
        return driver.findElement(By.xpath("//div[@class='dropdown']/a/p[contains(text(),'" + messageButton + "')]"));
    }
}
