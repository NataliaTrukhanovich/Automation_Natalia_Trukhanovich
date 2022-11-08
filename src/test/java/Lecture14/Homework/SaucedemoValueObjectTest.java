package Lecture14.Homework;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.HeaderPage;
import pageObjects.saucedemo.LoginPage;
import pageObjects.saucedemo.ProductsListPage;
import pageObjects.saucedemo.entity.SaucedemoValOb;
import pageObjects.saucedemo.entity.SaucedemoValObL;

public class SaucedemoValueObjectTest extends BaseTest {

    @Test
    public void loginTest() {
        get(LoginPage.class).openTestPage();

        SaucedemoValObL saucedemoValObl = new SaucedemoValObL() {{
            setUserName("standard_user");
            setPassword("secret_sauce");
            setProd1("Sauce Labs Backpack");
            setProd2("Sauce Labs Bike Light");
            setProd3("Sauce Labs Bolt T-Shirt");
            setProd4("Sauce Labs Fleece Jacket");
            setProd5("Sauce Labs Onesie");
            setProd6("Test.allTheThings() T-Shirt (Red)");
        }};

        get(LoginPage.class)
                .enterData(saucedemoValObl)
                .verifyThatLoginPageIsClosed();
        get(ProductsListPage.class).clickAddToCartBtn(saucedemoValObl);
        Assert.assertEquals(get(HeaderPage.class).quantityOfProducts(), "6");
    }
}
