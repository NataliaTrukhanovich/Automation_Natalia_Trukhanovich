package pageObjects.baseObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static Driver.SimpleDriver.getWebDriver;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    protected BasePage() {
        driver = getWebDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
    }
    protected FluentWait<WebDriver> fluentWait(long timeout, long pollingEvery) {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(pollingEvery))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
    }
    public void enter(By locator, String enterData) {
        System.out.println("Enter text by: "+locator);
        driver.findElement(locator).clear();
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

