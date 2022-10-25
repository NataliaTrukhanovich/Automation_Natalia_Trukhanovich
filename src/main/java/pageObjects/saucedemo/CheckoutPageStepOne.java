package pageObjects.saucedemo;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;
import pageObjects.saucedemo.entity.Saucedemo;
@Log4j
public class CheckoutPageStepOne extends BasePage {
    private final By FIRST_NAME = By.id("first-name");
    private final By LAST_NAME = By.id("last-name");
    private final By ZIP_NAME = By.id("postal-code");
    private By title = By.xpath("//span[@class='title']");

    public CheckoutPageStepOne setFirstName(String firstName) {
        enter(this.FIRST_NAME, firstName);
        return this;
    }

    public CheckoutPageStepOne setLastName(String lastName) {
        enter(this.LAST_NAME, lastName);
        return this;
    }

    public CheckoutPageStepOne setZipName(String zip) {
        enter(this.ZIP_NAME, zip);
        return this;
    }

    public CheckoutPageStepOne setData(Saucedemo saucedemo) {
        log.debug("Set data: First Name , Last Name , Zip Code ");
        setFirstName(saucedemo.getFirstName());
        setLastName(saucedemo.getLastName());
        setZipName(saucedemo.getZipName());
        click(getContinueBtn());
        return this;
    }

    private WebElement getCancelBtn() {
        return driver.findElement(By.id("cancel"));
    }

    private WebElement getContinueBtn() {
        return driver.findElement(By.id("continue"));
    }

    public void clickCancelBtn() {

        click(getCancelBtn());
    }

    public CheckoutPageStepOne clickContinueBtn() {
        click(getContinueBtn());
        return this;
    }

    public CheckoutPageStepOne verifyCheckoutPageStepOne() {
        log.debug("Verify Checkout Step One: expected page title \"CHECKOUT: YOUR INFORMATION\"");
        Assert.assertEquals(driver.findElement(title).getText(), "CHECKOUT: YOUR INFORMATION");
        return this;
    }

}
