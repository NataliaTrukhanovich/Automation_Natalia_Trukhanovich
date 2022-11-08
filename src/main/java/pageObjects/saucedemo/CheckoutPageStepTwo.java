package pageObjects.saucedemo;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;
@Log4j
public class CheckoutPageStepTwo extends BasePage {
    private By title = By.xpath("//span[@class='title']");
    private By finishBtn = By.id("finish");

    private WebElement getFinishBtn(){

        return driver.findElement(finishBtn);
    }
    public void clickFinishBtn(){
        log.debug("Click by WebElement:: "+ getFinishBtn());
        click(getFinishBtn());
    }
    public CheckoutPageStepTwo verifyCheckoutPageStepTwo() {
        log.debug("Verify Checkout Step Two: expected page title \"CHECKOUT: OVERVIEW\"");
        Assert.assertEquals(driver.findElement(title).getText(), "CHECKOUT: OVERVIEW");
        return this;
    }
}
