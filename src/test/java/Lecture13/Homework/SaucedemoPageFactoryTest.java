package Lecture13.Homework;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageFactory.saucedemo.LoginPage;
import pageFactory.saucedemo.ProductsListPage;
import pageObjects.baseObjects.BaseTest;


public class SaucedemoPageFactoryTest extends BaseTest {

    @Parameters({"url", "username", "password"})
    @Test
    public void loginTest(String url, String username, String password) {
        get(LoginPage.class)
                .openTestPage(url)
                .setUsername(username)
                .setPassword(password)
                .clickLoginBtn()
                .verifyThatLoginPageIsClosed();

        get(ProductsListPage.class).verifyPageUri().verifyPageTitle();
    }
}
