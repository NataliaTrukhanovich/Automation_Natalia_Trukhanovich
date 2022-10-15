package pageObjects.baseObjects;

import Driver.UIElement;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    protected WebElement findElement(By locator) {
        return driver.findElement(locator);
    }
    protected List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }
    protected void load(String url) {
        System.out.println("Open page :: " + url);
        driver.get(url);
    }

    protected String getPageUrl() {
        System.out.println("Get page URL :: ");
        return driver.getCurrentUrl();
    }

    public void enter(By locator, String enterData) {
        System.out.println("Enter text by locator :: " + locator);
       findElement(locator).clear();
        findElement(locator).sendKeys(enterData);
    }

    public void click(By locator) {
        System.out.println("Click on element by locator :: " + locator);
        verifyElementClickable(locator);
        findElement(locator).click();
    }

    public void click(WebElement webElement) {
        System.out.println("Click on webElement :: ");
        new UIElement(driver, wait, webElement).click();
    }

    public String getText(By locator) {
        System.out.println("Get element text by locator :: " + locator);
        return findElement(locator).getText();
    }

    public String getText(WebElement webElement) {
        System.out.println("Get element text by webElement :: " + webElement);
        return webElement.getText();
    }


    //Обычная реализация метода для получения коллекции из значений эл-тов с помощью
    // driver.findElements() и webElement.getText();
/*       public List<String> getTexts(By locator) {
        System.out.println("Get elements' texts by locator :: " + locator);
        List<String> data = new ArrayList<>();
        for(WebElement webElement : driver.findElements(locator)){
            data.add(webElement.getText());
        }
        return data;
    }
*/

    public List<String> getTexts(By locator) {
        System.out.println("Get elements' texts by locator :: " + locator);
        return findElements(locator).stream().map(WebElement::getText)
                .collect(Collectors.toList());
    }

    protected String getElementAttribute(By locator, String attribute) {
        System.out.println("Get element attribute " + attribute + " by locator :: " + locator);
        return findElement(locator).getAttribute(attribute);
    }

    protected List<String> getElementsAttributes(By locator, String attribute) {
        System.out.println("Get elements' attributes " + attribute + " by locator :: " + locator);
        return findElements(locator).stream().map(element -> element.getAttribute(attribute)).collect(Collectors.toList());
    }

    public Boolean elementNotExist(By by) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        for (int counter = 1; counter < 20; counter++) {
            System.out.println("Wait element for not exist counter = " + counter);
            if (findElements(by).size() == 0) {
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                return true;
            }
            waitUntil(1);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return false;
    }

    protected void waitUntil(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    protected void waitVisibilityOfElement(By locator) {
        System.out.println("Wait visibility of element -> " + locator);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void verifyElementTextToBe(By locator, String text) {
        System.out.println("Verify element text to be -> " + locator);
        wait.until(ExpectedConditions.textToBe(locator, text));
    }

    protected void verifyElementClickable(By locator) {
        System.out.println("Verify element clickable -> " + locator);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void select(By locator, Integer index) {
        System.out.println("Select by locator => " + locator + " with index => " + index);
        Select select = new Select(findElement(locator));
        select.selectByIndex(index);
    }

    protected void select(By locator, String value) {
        System.out.println("Select by locator => " + locator + " with value => " + value);
        Select select = new Select(findElement(locator));
        select.selectByValue(value);
    }
}

