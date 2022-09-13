package pageObjects.saucedemo;

import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

public class HeaderPage extends BasePage {

    By basketBtn = By.className("shopping_cart_link");
    By navigationBtn = By.id("react-burger-menu-btn");

    public void clickShoppingCartLink() {
        clickBtn(basketBtn);
    }

    public void clickNavigationBtn() {
        clickBtn(navigationBtn);
    }
    public boolean isEmptyShoppingCart(By locator){
        return driver.findElement(locator).isDisplayed();
    }
}
