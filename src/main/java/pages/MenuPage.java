package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Optional;

/**
 * Created by Maria on 26.10.2017.
 */
public class MenuPage extends BasePage{

		@FindBy(xpath = "//ul[@id='desktopMenuMain']//a[text()]")
		List<WebElement> mainMenuItem;

		@FindBy(xpath = "//ul[contains(@class,'main-menu__list-')]//a[text()]")
		List<WebElement> subMenuItem;

		@FindBy(xpath = "//a[@title='Перейти в корзину']")
		public WebElement goToCart;


		public void selectMainMenuItem(String menuItem){
				for(WebElement item : mainMenuItem){
						if (item.getText().equalsIgnoreCase(menuItem)){
							new WebDriverWait(driver, 10)
									.until(ExpectedConditions.elementToBeClickable(item)).click();
							return;
						}
				}
			  Assert.fail("Не найден пункт меню - " + menuItem);
		}

		public void selectSubMenuItem(String menuItem){
			Optional<WebElement> findItem = subMenuItem.stream().filter(item -> item.getText().equalsIgnoreCase(menuItem)).findFirst();
			if (findItem.isPresent()) findItem.get().click();
			else Assert.fail("Не найден пункт меню - " + menuItem);
		}
}
