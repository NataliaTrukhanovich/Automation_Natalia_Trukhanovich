package Lecture14.Homework;

import pageObjects.saucedemo.ProductsListPage;
import pageObjects.saucedemo.entity.Saucedemo;
import lombok.extern.log4j.Log4j;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.LoginPage;

@Log4j
public class SaucedemoLoginBuilderTest extends BaseTest {

    @Test
    public void saucedemoLoginBuilderTest() {
        LoginPage loginPage = get(LoginPage.class).openTestPage();

        Saucedemo s1 = new Saucedemo.SaucedemoBuilder().withLogin("standard_user").withPassword("$").create();
        loginPage.openTestPage().authorizationBuilderL(s1).verifyErrorMessageExist();

        Saucedemo s2 = new Saucedemo.SaucedemoBuilder().withLogin("standard_user").withPassword("").create();
        loginPage.openTestPage().authorizationBuilderL(s2).verifyErrorMessageExist();

        Saucedemo s3 = new Saucedemo.SaucedemoBuilder().withLogin("locked_out_user").withPassword("secret_sauce").create();
        loginPage.openTestPage().authorizationBuilderL(s3).verifyErrorMessage();

        Saucedemo s4 = new Saucedemo.SaucedemoBuilder().withLogin("problem_user").withPassword("secret_sauce").create();
        loginPage.openTestPage().authorizationBuilderL(s4);
        get(ProductsListPage.class).verifyProblemUser();

        Saucedemo s5 = new Saucedemo.SaucedemoBuilder().withLogin("standard_user").withPassword("secret_sauce").create();
        loginPage.openTestPage().authorizationBuilderL(s5).verifyThatLoginPageIsClosed();

    }
}

