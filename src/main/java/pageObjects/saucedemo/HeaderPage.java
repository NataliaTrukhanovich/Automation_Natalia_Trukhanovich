package pageObjects.saucedemo;

import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

public class HeaderPage extends BasePage {

    By basketBtn = By.className("shopping_cart_link");
    By navigationBtn = By.id("react-burger-menu-btn");
    By quantityProducts = By.xpath("//a[@class='shopping_cart_link']//span");

    public HeaderPage clickShoppingCartLink() {
        clickBtn(basketBtn);
        return this;
    }

    public void clickNavigationBtn() {
        clickBtn(navigationBtn);
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
