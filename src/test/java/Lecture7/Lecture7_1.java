package Lecture7;

import Driver.SimpleDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.saucedemo.LoginPage;
import pageObjects.saucedemo.ProductsListPage;

public class Lecture7 {


    @BeforeTest
    public void preconditions() {
        new SimpleDriver();
    }

    @Test
    public void loginTest(){
        LoginPage loginPage = new LoginPage();
        loginPage.openTestPage();
        loginPage.setUsername("standard_user");
        loginPage.setPASSWORD("secret_sauce");
        loginPage.clickLoginBtn();

        ProductsListPage productsListPage = new ProductsListPage();
        //Проверяем, что в шапке на странице стоит <title> PRODUCTS (т.е. мы перешли на др страницу после авторизации)
        productsListPage.verifyPageTitle();
    }



}
