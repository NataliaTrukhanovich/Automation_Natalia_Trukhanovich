package pageObjects.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

public class ShoppingCartPage extends BasePage {

    final String TITLE = getText(driver.findElement(By.xpath("//span[@class='title']")));

    public void verifyPageTitle() {
        System.out.println(TITLE);
        Assert.assertEquals(TITLE, "YOUR CART");
    }

    public WebElement getElementCartItem(String productName) {
        return driver.findElement(By.xpath("//*[@class='inventory_item_name' and text()='" + productName + "']//ancestor::div[@class='cart_item']"));
    }

    private WebElement getElementCartItemPrice(String productName) {
        return getElementCartItem(productName).findElement(By.className("inventory_item_price"));
    }

    private WebElement getElementCartItemQuantity(String productName) {
        return getElementCartItem(productName).findElement(By.className("cart_quantity"));
    }

    private WebElement getElementCartItemName(String productName) {
        return getElementCartItem(productName).findElement(By.className("inventory_item_name"));
    }

    private WebElement getRemoveBtn(String productName) {
        return getElementCartItem(productName).findElement(By.tagName("button"));
    }

    public String getElementCartItemPriceValue(String productName) {
        String price = getElementCartItemPrice(productName).getText();
        System.out.println(price);
        // return getElementCartItemPrice(productName).getText();
        return price;
    }

    public String getElementCartItemQuantityValue(String productName) {
        String quantity = getElementCartItemQuantity(productName).getText();
        System.out.println(quantity);
        return quantity;
        //   return getElementCartItemQuantity(productName).getText();

    }

    public String getElementCartItemNameValue(String productName) {
        return getElementCartItemName(productName).getText();
    }

    public void clickRemoveProduct(String productName) {
        clickBtn(getRemoveBtn(productName));
    }

    public void clickRemoveAnyProduct(){
        clickBtn(By.xpath("//div[@class='cart_item']//button"));
    }

    public void clickOneProductPage(String productName) {
        clickBtn(getElementCartItemName(productName));
    }

    public void clickCheckoutBtn() {
        clickBtn(driver.findElement(By.xpath("//*[contains(@class,'checkout_button')]")));
    }

}
