package ru.appline.framework.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Maria on 26.10.2017.
 */
public class CatalogPage extends BasePage {

    @FindBy(xpath = "//ul[@class='products-grid']//*[@title]/ancestor::li")
    List<WebElement> productCollection;


    public void addProduct(String productName) {
        getProduct(productName).findElement(By.xpath(".//button[@title='Заказать']")).click();
    }

    public WebElement getProduct(String productName) {
        for (WebElement item : productCollection) {
            if (item.findElement(By.xpath(".//a[@title]")).getAttribute("title").equalsIgnoreCase(productName)) {
                return item;
            }
        }
        Assert.fail("Не найден продукт - " + productName);
        return null;
    }

}
