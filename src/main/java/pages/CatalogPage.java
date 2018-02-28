package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

import java.util.List;

/**
 * Created by Maria on 26.10.2017.
 */
public class CatalogPage extends BasePage{

		@FindBy(xpath = "//ul[@class='products-grid']//*[@title]/ancestor::li")
		List<WebElement> productCollection;

	public CatalogPage(){
		PageFactory.initElements(driver, this);
	}

		public void addProduct(String productName){
			String price = getProduct(productName).findElement(By.xpath(".//span[@class='price']")).getText().replaceAll("\\D","");
			BaseSteps.setVariables(productName, price);
			getProduct(productName).findElement(By.xpath(".//button[@title='Заказать']")).click();
		}

		public WebElement getProduct(String productName){
			for (WebElement item : productCollection){
				if (item.findElement(By.xpath(".//a[@title]")).getAttribute("title").equalsIgnoreCase(productName)){
					return item;
				}
			}
			Assert.fail("Не найден продукт - " + productName);
			return null;
		}

}
