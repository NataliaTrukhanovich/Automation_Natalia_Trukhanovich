package pageObjects.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

public class CheckoutPageStepOne extends BasePage {
    private final By FIRST_NAME = By.id("first-name");
    private final By LAST_NAME = By.id("last-name");
    private final By ZIP_NAME = By.id("postal-code");
private By title = By.xpath("//span[@class='title']");

    public CheckoutPageStepOne setFirstName(String firstName) {
        enter(this.FIRST_NAME, firstName);
        return this;
    }
    public CheckoutPageStepOne setLastName(String lastName){
        enter(this.LAST_NAME, lastName);
        return this;
    }
    public CheckoutPageStepOne setZipName(String zip){
        enter(this.ZIP_NAME, zip);
        return this;
    }
    private WebElement getCancelBtn(){
        return driver.findElement(By.id("cancel"));
    }
    private WebElement getContinueBtn(){
        return driver.findElement(By.id("continue"));
    }

    public void clickCancelBtn(){

        clickBtn(getCancelBtn());
    }
    public CheckoutPageStepOne clickContinueBtn(){
        clickBtn(getContinueBtn());
        return this;
    }
    public CheckoutPageStepOne verifyCheckoutPageStepOne(){
        Assert.assertEquals(driver.findElement(title).getText(), "CHECKOUT: YOUR INFORMATION");
        return this;
    }

}
