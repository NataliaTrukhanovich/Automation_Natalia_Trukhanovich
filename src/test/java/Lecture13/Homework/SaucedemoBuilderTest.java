package Lecture13.Homework;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.LoginPage;
import pageObjects.saucedemo.entity.SaucedemoBuilder;

public class SaucedemoBuilderTest extends BaseTest {

    @Test
    public void saucedemoLoginBuilderTest(){
        get(LoginPage.class).openTestPage();

        SaucedemoBuilder saucedemoBuilder = new SaucedemoBuilder.Builder()
                .withLogin("standard_user")
               // .withPassword("secret_sauce")
                .build();

        get(LoginPage.class).authorizationBuilder(saucedemoBuilder);
    }
}
