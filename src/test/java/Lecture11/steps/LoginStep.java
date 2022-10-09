package Lecture11.steps;

import io.qameta.allure.Step;
import pageObjects.baseObjects.BasePage;
import pageObjects.saucedemo.LoginPage;

public class LoginStep extends BasePage {

    @Step("Login step")
    public LoginStep login(String username, String password) {
        new LoginPage()
                .openTestPage()
                .setUsername(username)
                .setPassword(password)
                .clickLoginBtn();
        return this;
    }
}
