package pageFactory.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    WebElement userName;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(id = "login-button")
    WebElement loginBtn;
    @FindBy(xpath = "//h3[@data-test='error']")
    WebElement errorMessage;

    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    public LoginPage openTestPage(String url){
        load(url);
        return this;
    }

    public LoginPage setUsername(String userName) {
        enter(this.userName, userName);
        return this;
    }

    public LoginPage setPassword(String password) {
        enter(this.password, password);
        return this;
    }

    public LoginPage clickLoginBtn() {
        click(loginBtn);
        return this;
    }

    public LoginPage verifyLoginBtnExist() {
        Assert.assertEquals(driver.findElements(By.id("login-button")).size(), 1);
        return this;
    }

    public void verifyErrorMessage() {
        Assert.assertEquals(getText(errorMessage), "Epic sadface: Sorry, this user has been locked out.");
    }

    public void verifyErrorMessageExist(){
       errorMessage.isDisplayed();
    }

    public LoginPage verifyThatLoginPageIsClosed() {
        Assert.assertTrue(elementNotExist(By.id("login-button")));
        return this;
    }
}
