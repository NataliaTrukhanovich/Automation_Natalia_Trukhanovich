package pageObjects.saucedemo;

import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;
import pageObjects.saucedemo.entity.Saucedemo;
import pageObjects.saucedemo.entity.SaucedemoBuilder;
import pageObjects.saucedemo.entity.SaucedemoValOb;
import pageObjects.saucedemo.entity.SaucedemoValObL;


public class LoginPage extends BasePage {

    private final By USERNAME = By.id("user-name");
    private final By PASSWORD = By.id("password");
    private final By LOGINBTN = By.id("login-button");
    private final By ERROR_MESSAGE = By.xpath("//h3[@data-test='error']");

    public LoginPage openTestPage() {
        load();
        return this;
    }
    public LoginPage openTestPage(String url){
        load(url);
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
    public LoginPage setUsername() {
        enter(this.USERNAME, properties.getProperty("username"));
        return this;
    }
    public LoginPage setPassword() {
        enter(this.PASSWORD, properties.getProperty("password"));
        return this;
    }
    public LoginPage clickLoginBtn() {
        click(this.LOGINBTN);
        return this;
    }

    public LoginPage enterData(SaucedemoValOb saucedemoValOb){
         setUsername(saucedemoValOb.getUserName());
         setPassword(saucedemoValOb.getPassword());
         clickLoginBtn();
         return this;
    }
    public LoginPage enterData(SaucedemoValObL saucedemoValObl){
        setUsername(saucedemoValObl.getUserName());
        setPassword(saucedemoValObl.getPassword());
        clickLoginBtn();
        return this;
    }

    public LoginPage verifyLoginBtnExist() {
        Assert.assertEquals(driver.findElements(LOGINBTN).size(), 1);
        return this;
    }

    public LoginPage verifyErrorMessage() {
        Assert.assertEquals(getText(ERROR_MESSAGE), "Epic sadface: Sorry, this user has been locked out.");
        return this;
    }

    public void verifyErrorMessageExist(){
       driver.findElement(ERROR_MESSAGE).isDisplayed();
    }

    public LoginPage verifyThatLoginPageIsClosed() {
        Assert.assertTrue(elementNotExist(LOGINBTN));
        return this;
    }
    public void authorization(){
        openTestPage("https://www.saucedemo.com/")
                .setUsername("standard_user")
                .setPassword("secret_sauce")
                .clickLoginBtn();
    }
    public void authorizationBuilder(SaucedemoBuilder saucedemoBuilder){
        setUsername(saucedemoBuilder.getLogin());
        setPassword(saucedemoBuilder.getPassword());
        clickLoginBtn();
    }
    public LoginPage authorizationBuilderL(Saucedemo saucedemo){
        setUsername(saucedemo.getLogin());
        setPassword(saucedemo.getPassword());
        clickLoginBtn();
        return this;
    }
}
