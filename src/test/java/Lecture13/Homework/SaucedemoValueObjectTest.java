package Lecture13.Homework;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.LoginPage;
import pageObjects.saucedemo.entity.SaucedemoValOb;

public class SaucedemoValueObjectTest extends BaseTest {

    @Parameters({"url"})
    @Test
    public void loginTest(String url) {
        get(LoginPage.class).openTestPage(url);

        SaucedemoValOb saucedemoValOb = new SaucedemoValOb() {{
            setUserName("standard_user");
            setPassword("secret_sauce");
        }};

        get(LoginPage.class)
                .enterData(saucedemoValOb)
                .verifyThatLoginPageIsClosed();
    }
}
