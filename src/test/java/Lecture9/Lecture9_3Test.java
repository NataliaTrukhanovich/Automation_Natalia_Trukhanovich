package Lecture9;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.LoginPage;

public class Lecture9_3Test extends BaseTest {

    @Parameters ("url")
    @BeforeMethod
    public void preconditions(String url){
        new LoginPage()
                .openTestPage(url);
    }
    @Test(dataProvider = "login data")
    public void login(String username, String password) {
        new LoginPage()
                .setUsername(username)
                .setPassword(password)
                .clickLoginBtn();
    }
   @DataProvider(name = "login data")
    public Object[][] getData(){
        return new Object[][]{
                {"standard_user", "secret_sauce"},
                {"locked_out_user", "secret_sauce"},
                {"", "secret_sauce"},
                {"performance_glitch_user", "secret_sauce"},
        };
    }
}
