package pageObjects.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

public class LoginPage extends BasePage {

    private final By USERNAME = By.id("user-name");
    private final By PASSWORD = By.id("password");
    private final By LOGINBTN = By.id("login-button");
    private final By ERROR_MESSAGE = By.xpath("//h3[@data-test='error']");

    public LoginPage openTestPage() {
        driver.get("https://www.saucedemo.com/");
        return this;
    }
    public LoginPage openTestPage(String url){
        driver.get(url);
        return this;
    }

    public LoginPage setUsername(String username) {
        enter(this.USERNAME, username);
        return this;
    }

    public LoginPage setPassword(String password) {
        enter(this.PASSWORD, password);
        return this;
    }

    public LoginPage clickLoginBtn() {
        clickBtn(this.LOGINBTN);
        return this;
    }

    public LoginPage verifyLoginBtnExist() {
        elementExist(LOGINBTN);
        return this;
    }

    public void verifyErrorMessage() {
        Assert.assertEquals(getText(ERROR_MESSAGE), "Epic sadface: Sorry, this user has been locked out.");
    }

    public void verifyErrorMessageExist(){
       driver.findElement(ERROR_MESSAGE).isDisplayed();
    }

    public LoginPage verifyThatLoginPageIsClosed() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(LOGINBTN));
        return this;
    }
}
