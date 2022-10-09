package Lecture11;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.LoginPage;

public class LoginTest extends BaseTest {

    @Parameters({"username", "password"})
    @Test
    public void login(String username, String password) {
        get(LoginPage.class)
                .openTestPage()
                .setUsername(username)
                .setPassword(password)
                .clickLoginBtn()
                .verifyThatLoginPageIsClosed();
    }
}

