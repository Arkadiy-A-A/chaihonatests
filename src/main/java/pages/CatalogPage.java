package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

/**
 * Created by Maria on 26.10.2017.
 */
public class CatalogPage extends BasePage{

		@FindBy(xpath = "//ul[@class='products-grid']")
		WebElement productCollection;

	public CatalogPage(){
		PageFactory.initElements(driver, this);
	}

		public void addProduct(String productName){
			String price = productCollection.findElement(By.xpath(".//*[@title='"+productName+"']/ancestor::li//span[@class='price']")).getText().replaceAll("\\D","");
			BaseSteps.setVariables(productName, price);
			productCollection.findElement(By.xpath(".//*[@title='"+productName+"']/ancestor::li//button[@title='Заказать']")).click();
		}
}
