package pageObjects.moodpanda;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;
import pageObjects.saucedemo.entity.SaucedemoValOb;

@Log4j
public class LoginPage extends MoodPandaBasePage {

    private By email = By.cssSelector("[type='text']");
    private By password = By.cssSelector("[type='password']");
    private By loginBtn = By.xpath("//button[@class]");
    private By notification = By.cssSelector("[class^=notification]");

    public LoginPage() {
        isPageOpened();
    }

    public LoginPage enterPassword(String password) {
        enter(this.password, password);
        return this;
    }

    public LoginPage enterEmail(String email) {
        enter(this.email, email);
        return this;
    }

    public LoginPage clickLogin() {
        click(loginBtn);
        return this;
    }

    public LoginPage verifyErrorMessage(String message) {
        log.debug("Expected message: " + message);
        log.debug("Actual message: " + driver.findElement(notification).getText());
        Assert.assertEquals(getText(notification), message);
        return this;
    }

    @Override
    public void isPageOpened() {
        waitVisibilityOfElement(email);
    }
}
