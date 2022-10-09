package Lecture10;

import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.LoginPage;
import pageObjects.saucedemo.ProductsListPage;

public class Lecture10LoginTestSaucedemoParametersTest extends BaseTest {
    @Test
    public void loginTest() {
        new LoginPage()
                .openTestPage()
                .setUsername(System.getProperty("username"))
                .setPassword(System.getProperty("password"))
                .clickLoginBtn()
                .verifyThatLoginPageIsClosed();
        new ProductsListPage().verifyPageTitle();
    }

    @Test
    public void exampleTest() {
        System.out.println("Test for example");
    }
}
