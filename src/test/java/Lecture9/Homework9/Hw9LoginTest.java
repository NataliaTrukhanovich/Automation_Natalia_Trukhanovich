package Lecture9.Homework9;

import lombok.extern.log4j.Log4j;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.LoginPage;
@Log4j
public class Hw9LoginTest extends BaseTest {

    @Parameters("url")
    @BeforeMethod
    public void preconditions(String url) {
        new LoginPage()
                .openTestPage(url);
    }

    @Test(dataProvider = "login data", description = "This is Login Test")
    public void loginTest(String username, String password, char status) {
        LoginPage loginPage = new LoginPage();
        loginPage.setUsername(username)
                .setPassword(password)
                .clickLoginBtn();
        if (status == 'p') {
            loginPage.verifyThatLoginPageIsClosed();
            log.debug("позитивный тест");
        } else {
            loginPage.verifyErrorMessageExist();
            log.debug("негативный тест");
        }
    }

    @DataProvider(name = "login data")
    public Object[][] getData(ITestContext c) {
        return new Object[][]{
                {"standard_user", "secret_sauce", 'p'},
                {"locked_out_user", "secret_sauce", 'n'},
                {"login#", "secret_sauce", 'n'},
                {"standard_user", "******", 'n'},
        };
    }
}