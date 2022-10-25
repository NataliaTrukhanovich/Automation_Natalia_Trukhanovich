package Lecture11;

import Lecture11.steps.AddProductToBasketStep;
import Lecture11.steps.LoginStep;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.HeaderPage;

public class ShoppingCartTest extends BaseTest {

    @Test(description = "Test with two steps")
    public void verifyFullBasket(){
        new LoginStep().login();
        new AddProductToBasketStep().addToBasket();
        Assert.assertEquals(new HeaderPage().quantityOfProducts(), "5");
    }
}
