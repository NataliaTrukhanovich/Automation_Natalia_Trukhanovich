package Lecture8;

import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.LoginPage;
import pageObjects.saucedemo.ProductsListPage;

public class Lecture8_1 extends BaseTest {

    @Test
    public void login() {
        new LoginPage()
                .openTestPage()
                .setUsername("standard_user")
                .setPassword("secret_sauce")
                .clickLoginBtn()
                .verifyThatLoginPageIsClosed();
        new ProductsListPage().verifyPageTitle();
    }
}
