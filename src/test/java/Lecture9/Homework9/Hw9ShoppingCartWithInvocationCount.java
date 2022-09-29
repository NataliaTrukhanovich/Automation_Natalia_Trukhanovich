package Lecture9.Homework9;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.HeaderPage;
import pageObjects.saucedemo.LoginPage;
import pageObjects.saucedemo.ProductsListPage;
import pageObjects.saucedemo.ShoppingCartPage;

public class Hw9ShoppingCartWithInvocationCount extends BaseTest {

    @BeforeClass
    public void preconditions() {
        new LoginPage().authorization();
    }

    @Test(dataProvider = "test data")
    public void addToShoppingCart(String productName) {
        new ProductsListPage().clickAddToCartBtn(productName);
    }

    @Test(priority = 2)
    public void verifyFullShoppingCart() {
        HeaderPage headerPage = new HeaderPage();
        headerPage.clickShoppingCartLink();
        Assert.assertEquals(headerPage.quantityOfProducts(), "6");
    }

    @Test(invocationCount = 6, priority = 3)
    public void RemoveProducts() {
        new ShoppingCartPage().clickRemoveAnyProduct();
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