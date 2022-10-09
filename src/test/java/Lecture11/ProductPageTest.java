package Lecture11;

import Lecture11.steps.LoginStep;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.ProductsListPage;

public class ProductPageTest extends BaseTest {

    @Parameters({"username","password","steps"})
    @Test
    public void verifyProductPage(String username, String password, @Optional("0") String steps)
    {
        if (steps.equals("0")) get(LoginStep.class).login(username, password);
        get(ProductsListPage.class).verifyPageTitle();
    }
}
