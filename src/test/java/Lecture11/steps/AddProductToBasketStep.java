package Lecture11.steps;

import io.qameta.allure.Step;
import pageObjects.baseObjects.BasePage;
import pageObjects.saucedemo.ProductsListPage;

import java.util.Arrays;
import java.util.List;

public class AddProductToBasketStep extends BasePage {
    @Step("Add to basket all products")
    public void addToBasket() {
        List<String> productNames = Arrays.asList("Sauce Labs Backpack",
                "Sauce Labs Bike Light",
                "Sauce Labs Bolt T-Shirt",
                "Sauce Labs Fleece Jacket",
                "Sauce Labs Onesie",
                "Test.allTheThings() T-Shirt (Red)");
        for (String productName : productNames) {
            new ProductsListPage().clickAddToCartBtn(productName);
        }
    }
}

