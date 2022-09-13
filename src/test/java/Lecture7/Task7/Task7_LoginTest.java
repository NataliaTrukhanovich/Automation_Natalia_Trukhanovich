package Lecture7.Task7;

import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.LoginPage;
import pageObjects.saucedemo.ProductsListPage;

public class Task7_LoginTest extends BaseTest {
    String username;
    String password = "secret_sauce";


    @Test
    public void loginTest1(){
        username = "locked_out_user";
        new LoginPage()
                .openTestPage()
                .setUsername(username)
                .setPassword(password)
                .clickLoginBtn()
                .verifyLoginBtnExist()
                .verifyErrorMessage();
    }
    @Test
    public void loginTest2(){
        username = "problem_user";
        new LoginPage()
                .openTestPage()
                .setUsername(username)
                .setPassword(password)
                .clickLoginBtn();
        new ProductsListPage().verifyProblemUser();

    }
    @Test
    public void loginTest3() {
        username = "performance_glitch_user";
        new LoginPage()
                .openTestPage()
                .setUsername(username)
                .setPassword(password)
                .clickLoginBtn();
        new ProductsListPage().verifyPageTitle();
    }
    @Test
    public void loginTest4() {
        username = "standard_user";
        new LoginPage()
                .openTestPage()
                .setUsername(username)
                .setPassword(password)
                .clickLoginBtn();
        new ProductsListPage().verifyPageTitle();
    }

}
