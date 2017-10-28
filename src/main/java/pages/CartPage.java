package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

/**
 * Created by Maria on 26.10.2017.
 */
public class CartPage extends BasePage{


	@FindBy(id = "shopping-cart-table")
	WebElement shoppingCartTable;

	@FindBy(xpath = "//*[text()='Итого']/ancestor::tr[@class='order-total']//span[@id]")
	WebElement totalAmount;

	public CartPage(){
		PageFactory.initElements(driver, this);
	}


	public Integer getSizeShoppingTable(){
		 return shoppingCartTable.findElements(By.xpath(".//tr[@class='cart-item']")).size();
	}

	public String getProductPrice(String productName){
		return shoppingCartTable.findElement(By.xpath(".//*[text()='"+productName+"']/ancestor::tr//span[@class='cart-price']")).getText();
	}

	public boolean productExist(String productName){
		return isElementPresent(By.xpath(".//*[text()='"+productName+"']/ancestor::tr//span[@class='cart-price']"));
	}

	public String getTotalAmount(){
		return totalAmount.getText();
	}
}
