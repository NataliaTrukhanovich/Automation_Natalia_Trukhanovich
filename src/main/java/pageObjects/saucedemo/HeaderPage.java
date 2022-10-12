package pageObjects.saucedemo;

import org.openqa.selenium.By;
import pageObjects.baseObjects.BasePage;

public class HeaderPage extends BasePage {

    By basketBtn = By.className("shopping_cart_link");
    By navigationBtn = By.id("react-burger-menu-btn");
    By quantityProducts = By.xpath("//a[@class='shopping_cart_link']//span");

    public HeaderPage clickShoppingCartLink() {
        click(basketBtn);
        return this;
    }

    public HeaderPage clickNavigationBtn() {
        click(navigationBtn);
        return this;
    }

    public String quantityOfProducts() {
        return driver.findElement(quantityProducts).getText();
    }

    public boolean isEmptyShoppingCart() {
        boolean status = false;
        if (driver.findElement(quantityProducts).isDisplayed() == false) {status = true;
        }
        return status;
    }
}
