package Lecture11;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void login() {
        get(LoginPage.class)
                .openTestPage()
                .setUsername()
                .setPassword()
                .clickLoginBtn()
                .verifyThatLoginPageIsClosed();
    }
}

