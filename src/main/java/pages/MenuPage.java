package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Maria on 26.10.2017.
 */
public class MenuPage extends BasePage{

		@FindBy(xpath = "//ul[@id='desktopMenuMain']")
		WebElement mainMenuItem;

		@FindBy(xpath = "//ul[contains(@class,'main-menu__list-')]")
		WebElement subMenuItem;

		@FindBy(xpath = "//a[@title='Перейти в корзину']")
		public WebElement goToCart;

	public MenuPage(){
		PageFactory.initElements(driver, this);
	}

		public void selectMainMenuItem(String menuItem){
				new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(mainMenuItem));
				mainMenuItem.findElement(By.xpath(".//a[text()='" + menuItem + "']")).click();
		}

		public void selectSubMenuItem(String menuItem){
			subMenuItem.findElement(By.xpath(".//a[text()='" + menuItem + "']")).click();
		}
}
