package pageObjects.saucedemo;

import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

public class CheckoutPageComplete extends BasePage {
    private By title = By.xpath("//span[@class='title']");
    private By confirmationText = By.tagName("h2");

    public CheckoutPageComplete verifyCheckoutComplete1() {
        Assert.assertEquals(driver.findElement(title).getText(), "CHECKOUT: COMPLETE!");
        return this;
    }
    public CheckoutPageComplete verifyCheckoutComplete2() {
        Assert.assertEquals(driver.findElement(confirmationText).getText(), "THANK YOU FOR YOUR ORDER");
        return this;
    }
}
