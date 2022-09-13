package Lecture7;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.*;

public class Lecture7_2 extends BaseTest {

    @BeforeClass
    public void login() {
        new LoginPage()
                .openTestPage()
                .setUsername("standard_user")
                .setPassword("secret_sauce")
                .clickLoginBtn();
    }

    @Test
    public void productTest() {
        String productName1 = "Sauce Labs Bolt T-Shirt";
        String productName2 = "Sauce Labs Fleece Jacket";
        ProductsListPage productsListPage = new ProductsListPage();
        productsListPage.verifyPageTitle();
        productsListPage.clickAddToCartBtn(productName1);
        String productCost = productsListPage.getProductCost(productName1);
        productsListPage.clickAddToCartBtn(productName2);

        HeaderPage headerPage = new HeaderPage();
        headerPage.clickNavigationBtn();
        headerPage.clickShoppingCartLink();

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        shoppingCartPage.verifyPageTitle();
        shoppingCartPage.getElementCartItemPriceValue(productName1);
        shoppingCartPage.getElementCartItemPriceValue(productName2);
        shoppingCartPage.getElementCartItemQuantityValue(productName1);
        shoppingCartPage.getElementCartItemQuantityValue(productName2);
        String cartProductCost = shoppingCartPage.getElementCartItemPriceValue(productName1);
        Assert.assertEquals(shoppingCartPage.getElementCartItemQuantityValue(productName1), "1");
        shoppingCartPage.clickOneProductPage(productName1);

        OneProductPage oneProductPage = new OneProductPage();
        oneProductPage.clickProductAddAndRemoveBtn(productName1);
        oneProductPage.clickBackToProducts();

        headerPage.clickShoppingCartLink();
        shoppingCartPage.clickCheckoutBtn();

        Assert.assertEquals(productCost, cartProductCost);

    }
}
