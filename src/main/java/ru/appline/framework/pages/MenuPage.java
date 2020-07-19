package ru.appline.framework.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.appline.framework.util.DriverManager;

import java.util.List;

/**
 * Created by Maria on 26.10.2017.
 */
public class MenuPage extends BasePage {

    @FindBy(xpath = "//ul[@id='desktopMenuMain']//a[text()]")
    private List<WebElement> mainMenuItem;

    @FindBy(xpath = "//ul[contains(@class,'main-menu__list-')]//a[text()]")
    private List<WebElement> subMenuItem;

    @FindBy(xpath = "//a[@title='Перейти в корзину']")
    private WebElement goToCart;


    public void selectMainMenuItem(String menuItem) {
        for (WebElement item : mainMenuItem) {
            if (item.getText().equalsIgnoreCase(menuItem)) {
                new WebDriverWait(DriverManager.getDriver(), 10)
                        .until(ExpectedConditions.elementToBeClickable(item)).click();
                return;
            }
        }
        Assert.fail("Не найден пункт меню - " + menuItem);
    }

    public void selectSubMenuItem(String menuItem) {
        for (WebElement item : subMenuItem) {
            if (item.getText().equalsIgnoreCase(menuItem)) {
                new WebDriverWait(DriverManager.getDriver(), 10)
                        .until(ExpectedConditions.elementToBeClickable(item)).click();
                return;
            }
        }
        Assert.fail("Не найден пункт меню - " + menuItem);
    }


    public void goToCart(){
        goToCart.click();
    }

}
