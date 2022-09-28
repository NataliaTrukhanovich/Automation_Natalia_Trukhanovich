package Lecture9.Homework9;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.*;

public class Hw9RemoveThroughProductPage extends BaseTest {

    @BeforeClass
    public void preconditions(){
        new LoginPage().authorization();
    }

    @Test(dataProvider = "test data", priority = 1)
    public void addToShoppingCart(String productName) {
        new ProductsListPage().clickAddToCartBtn(productName);
    }

    @Test(dataProvider = "test data", priority = 2)
    public void removeFromProductPage(String productName) {
        new HeaderPage().clickShoppingCartLink();
        new ShoppingCartPage().clickOneProductPage(productName);
        new OneProductPage().clickProductAddAndRemoveBtn(productName);
    }

    @Test(priority = 3, expectedExceptions = NoSuchElementException.class)
    public void verifyEmptyShoppingCart(){
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


