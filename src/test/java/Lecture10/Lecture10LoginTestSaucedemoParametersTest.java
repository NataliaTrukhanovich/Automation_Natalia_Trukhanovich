package Lecture10;

import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.LoginPage;
import pageObjects.saucedemo.ProductsListPage;

public class Lecture10LoginTestSaucedemoParameters extends BaseTest {
    @Test
    public void login() {
        new LoginPage()
                .openTestPage()
                .setUsername(System.getProperty("username"))
        .setPassword(System.getProperty("password"))
                .clickLoginBtn()
                .verifyThatLoginPageIsClosed();
        new ProductsListPage().verifyPageTitle();
    }
}
//.setUsername(System.getProperty("username"))
//        .setPassword(System.getProperty("password"))