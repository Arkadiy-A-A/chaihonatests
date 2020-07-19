package ru.appline.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Maria on 26.10.2017.
 */
public class CartPage extends BasePage {

    @FindBy(xpath = "//table[@id = 'shopping-cart-table']//*[text()]/ancestor::tr//td[@class='product-name']/a[text()]")
    List<WebElement> shoppingCartTable;

    @FindBy(xpath = "//*[contains(text(),'Итого к оплате:')]/parent::div//span[@class='price']")
    WebElement totalAmount;

    public boolean productExist(String productName) {
        for (WebElement item : shoppingCartTable) {
            if (isElementPresent(item) && item.getText().equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }
}
