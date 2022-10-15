package pageObjects.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

public class CheckoutPageStepTwo extends BasePage {
    private By title = By.xpath("//span[@class='title']");
    private By finishBtn = By.id("finish");

    private WebElement getFinishBtn(){

        return driver.findElement(finishBtn);
    }
    public void clickFinishBtn(){
        click(getFinishBtn());
    }
    public CheckoutPageStepTwo verifyCheckoutPageStepTwo() {
        Assert.assertEquals(driver.findElement(title).getText(), "CHECKOUT: OVERVIEW");
        return this;
    }
}
