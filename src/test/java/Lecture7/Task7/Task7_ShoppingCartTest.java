package Lecture7.Task7;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.HeaderPage;
import pageObjects.saucedemo.LoginPage;
import pageObjects.saucedemo.ProductsListPage;
import pageObjects.saucedemo.ShoppingCartPage;

public class Task7_ShoppingCartTest extends BaseTest {

    @BeforeClass
    public void login() {
        new LoginPage()
                .openTestPage()
                .setUsername("standard_user")
                .setPassword("secret_sauce")
                .clickLoginBtn();
    }

    @Test
    public void Test1ShoppingCartAdd() {
        String productName = "Sauce Labs Bolt T-Shirt";
        new ProductsListPage().clickAddToCartBtn(productName);
        new HeaderPage().clickShoppingCartLink();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        shoppingCartPage.verifyPageTitle();
        //Проверили, что в корзине лежит именно тот продукт, который мы добавляли (по имени)
        Assert.assertEquals(shoppingCartPage.getElementCartItemNameValue(productName), productName);
        //Проверили, что кол-во данного продукта не null, т.е. он там есть
        Assert.assertNotNull(shoppingCartPage.getElementCartItemQuantityValue(productName));
    }

    @Test
    public void Test2ShoppingCartRemove(){
        String productName = "Sauce Labs Bolt T-Shirt";
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        shoppingCartPage.clickRemoveProduct(productName);
        new HeaderPage().clickNavigationBtn();
        shoppingCartPage.click(By.id("inventory_sidebar_link"));
        ProductsListPage productsListPage = new ProductsListPage();
        String buttonCond = productsListPage.verifyBtnCondition(productName);
        //Проверили, что у продукта на кнопке ADD TO CART, т.е. он не в корзине
        Assert.assertEquals(buttonCond, "ADD TO CART");
    }
}
