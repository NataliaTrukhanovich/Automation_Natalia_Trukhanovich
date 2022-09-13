package Lecture7.Task7;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.*;

public class Task7_CheckoutTest extends BaseTest {

    @BeforeClass
    public void login() {
        new LoginPage()
                .openTestPage()
                .setUsername("standard_user")
                .setPassword("secret_sauce")
                .clickLoginBtn();
        String productName = "Sauce Labs Bolt T-Shirt";
        new ProductsListPage().clickAddToCartBtn(productName);
        new HeaderPage().clickShoppingCartLink();
        new ShoppingCartPage().clickCheckoutBtn();
    }
    @Test
    public void Test1() {
        new CheckoutPageStepOne()
                .verifyCheckoutPageStepOne()
                .setFirstName("John")
                .setLastName("Smith")
                .setZipName("12345")
                .clickContinueBtn();
    }
    @Test
    public void Test2(){
        new CheckoutPageStepTwo()
                .verifyCheckoutPageStepTwo()
                .clickFinishBtn();
    }
    @Test
    public void Test3(){
        new CheckoutPageComplete()
                .verifyCheckoutComplete1()
                .verifyCheckoutComplete2();
    }
}
