package pageObjects.baseObjects;

import Driver.SimpleDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static Driver.SimpleDriver.getWebDriver;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected BasePage() {
        driver = getWebDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void enter(By locator, String enterData) {
        driver.findElement(locator).sendKeys(enterData);
    }

    public void clickBtn(By locator) {
        System.out.println("Click by: "+locator);
        driver.findElement(locator).click();
    }
    public void clickBtn(WebElement webElement) {

        webElement.click();
    }
    public String getText(By locator){
        System.out.println("GetText by: "+locator);
        return driver.findElement(locator).getText();
    }
    public String getText(WebElement webElement){

        return webElement.getText();
    }
    public void elementExist(By locator) {
       Assert.assertEquals(driver.findElements(locator).size(), 1);
    }

    public void elementsExist(By locator) {
        Assert.assertEquals(driver.findElements(locator).size(), 6);
    }

}

