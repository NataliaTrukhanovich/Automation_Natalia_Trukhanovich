package Lecture14.Homework;

import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.*;
import pageObjects.saucedemo.entity.Saucedemo;
import pageObjects.saucedemo.entity.SaucedemoValObL;

public class SaucedemoCheckoutBuilderTest extends BaseTest {

    @Test
    public void checkoutBuilderTest(){

        Saucedemo saucedemoLogin = Saucedemo
                .builder()
                .withLogin("standard_user")
                .withPassword("secret_sauce")
                .create();

        get(LoginPage.class).openTestPage().authorizationBuilderL(saucedemoLogin);

        SaucedemoValObL saucedemoValObL = new SaucedemoValObL(){{
            setProd1("Sauce Labs Backpack");
            setProd2("Sauce Labs Bike Light");
            setProd3("Sauce Labs Bolt T-Shirt");
            setProd4("Sauce Labs Fleece Jacket");
            setProd5("Sauce Labs Onesie");
            setProd6("Test.allTheThings() T-Shirt (Red)");
        }};
        get(ProductsListPage.class).clickAddToCartBtn(saucedemoValObL);
        get(HeaderPage.class).clickShoppingCartLink();
        get(ShoppingCartPage.class).clickCheckoutBtn();

        Saucedemo saucedemoCheckoutForm = Saucedemo
                .builder()
                .withFirstName("John")
                .withLastName("Smith")
                .withZipName("12345")
                .create();
        get(CheckoutPageStepOne.class)
                .verifyCheckoutPageStepOne()
                .setData(saucedemoCheckoutForm);
        get(CheckoutPageStepTwo.class).verifyCheckoutPageStepTwo();
    }
}
