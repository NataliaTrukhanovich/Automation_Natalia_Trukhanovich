package Lecture9.Homework9;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.*;

public class Hw9ShoppingCartTestWithDataProvider extends BaseTest {

    @BeforeClass
    @Parameters("url")
    public void preconditions(String url) {
        new LoginPage()
                .openTestPage(url)
                .setUsername("standard_user")
                .setPassword("secret_sauce")
                .clickLoginBtn();
    }

    @Test(dataProvider = "test data", priority = 1)
    public void addToShoppingCart(String productName) {
        new ProductsListPage().clickAddToCartBtn(productName);
    }

    @Test(priority = 2, dependsOnMethods = "addToShoppingCart")
    public void verifyFullShoppingCart() {
        HeaderPage headerPage = new HeaderPage();
        headerPage.clickShoppingCartLink();
        Assert.assertEquals(headerPage.quantityOfProducts(), "6");
    }

    @Test(dataProvider = "test data", priority = 3)
    public void removeFromShoppingCart(String productName) {
        new ShoppingCartPage().clickRemoveProduct(productName);
    }

    @Test(priority = 4, expectedExceptions = NoSuchElementException.class)
    public void verifyEmptyShoppingCart() {
        Assert.assertTrue(new HeaderPage().isEmptyShoppingCart());
    }

    @DataProvider(name = "test data")
    public Object[][] getData(ITestContext c) {
        return new Object[][]{
                {"Sauce Labs Backpack"},
                {"Sauce Labs Bike Light"},
                {"Sauce Labs Bolt T-Shirt"},
                {"Sauce Labs Fleece Jacket"},
                {"Sauce Labs Onesie"},
                {"Test.allTheThings() T-Shirt (Red)"},
        };
    }
}
