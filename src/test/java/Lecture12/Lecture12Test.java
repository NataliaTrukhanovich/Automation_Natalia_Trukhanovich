package Lecture12;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.HeaderPage;
import pageObjects.saucedemo.ProductsListPage;
import pageObjects.saucedemo.ShoppingCartPage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lecture12Test extends BaseTest {

    @Test
    public void productsListPageTest() {
        String productName = "Sauce Labs Backpack";
        String productCost = get(ProductsListPage.class).verifyPageTitle().getProductCost(productName);

        get(ProductsListPage.class).clickAddToCartBtn(productName);

        get(HeaderPage.class).clickShoppingCartLink();

        String cartProductCost = get(ShoppingCartPage.class).getElementCartItemPriceValue(productName);
        Assert.assertEquals(productCost, cartProductCost);

    }

    @Test
    public void test() {
        List<String> data1 = Arrays.asList("Audi", "BMW", "Lada");
        List<String> dataWithV = data1.stream().map(car -> car + " 2.0").collect(Collectors.toList());
        System.out.println(dataWithV);

        List<String> data2 = Arrays.asList("Audi RS", "WV Polo", "Lada Granta", "Audi Q3");
        List<String> audiData = data2.stream().map(car -> {
            if (car.contains("Audi")) {
                return car + " Quattro";
            }
            return car;
        }).collect(Collectors.toList());

        System.out.println(audiData);
    }
}
