package Lecture7;

import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.LoginPage;
import pageObjects.saucedemo.ProductsListPage;

public class Lecture7_1 extends BaseTest {

    @Test
    public void loginTest(){
        LoginPage loginPage = new LoginPage();
        loginPage.openTestPage();
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginBtn();

        ProductsListPage productsListPage = new ProductsListPage();
        //Проверяем, что в шапке на странице стоит <title> PRODUCTS (т.е. мы перешли на др страницу после авторизации)
        productsListPage.verifyPageTitle();
    }

}
