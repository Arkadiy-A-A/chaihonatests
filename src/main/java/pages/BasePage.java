package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

import java.util.concurrent.TimeUnit;

public class BasePage {
    WebDriver driver = BaseSteps.getDriver();

    public BasePage(){
        PageFactory.initElements(driver, this);
    }

    public boolean isElementPresent(By by) {
        try {
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
        finally {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
    }

    public boolean isElementPresent(WebElement element) {
        try {
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
        finally {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
    }


    public void fillField(WebElement element, String value)  {
            element.clear();
            element.sendKeys(value);
    }

    public void click(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);
        Wait<WebDriver> wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }





}
