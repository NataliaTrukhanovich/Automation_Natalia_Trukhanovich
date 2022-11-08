package Lecture11.steps;

import io.qameta.allure.Step;
import pageObjects.baseObjects.BasePage;
import pageObjects.saucedemo.LoginPage;

public class LoginStep extends BasePage {

    @Step("Login step")
    public LoginStep login() {
        new LoginPage()
                .openTestPage()
                .setUsername()
                .setPassword()
                .clickLoginBtn();
        return this;
    }
}
