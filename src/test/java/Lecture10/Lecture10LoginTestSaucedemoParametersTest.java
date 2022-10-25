package Lecture10;

import lombok.extern.log4j.Log4j;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.LoginPage;
import pageObjects.saucedemo.ProductsListPage;
@Log4j
public class Lecture10LoginTestSaucedemoParametersTest extends BaseTest {
    @Test
    public void loginTest() {
        new LoginPage()
                .openTestPage("https://www.saucedemo.com/")
                .setUsername(System.getProperty("username"))
                .setPassword(System.getProperty("password"))
                .clickLoginBtn()
                .verifyThatLoginPageIsClosed();
        new ProductsListPage().verifyPageTitle();
    }

    @Test
    public void exampleTest() {
        log.debug("Test for example");
    }
}
