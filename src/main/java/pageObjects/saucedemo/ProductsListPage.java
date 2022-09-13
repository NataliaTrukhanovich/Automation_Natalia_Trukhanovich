package pageObjects.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

public class ProductsListPage extends BasePage {

    private final By TITLE = By.xpath("//span[@class='title']");
    private final By ERROR_IMG = By.xpath("//img[@src='/static/media/sl-404.168b1cce.jpg']");

    public void ProductsListPage() {
        verifyPageUri();
    }
    public void verifyPageUri() {
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"));
    }
    public void verifyPageTitle() {
        System.out.println(getText(TITLE));
        Assert.assertEquals(getText(TITLE), "PRODUCTS");
    }
    private WebElement getElementProduct(String productName) {
        return driver.findElement(By.xpath("//*[@class = 'inventory_item_name' and text() = '" + productName + "']//ancestor::div[@class='inventory_item']"));
    }

    private WebElement getProductPrice(String productName){
        return getElementProduct(productName).findElement(By.className("inventory_item_price"));
    }
    private WebElement getAddToCartBtn(String productName) {
        return getElementProduct(productName).findElement(By.tagName("button"));
    }

    public void clickAddToCartBtn(String productName){
        clickBtn(getAddToCartBtn(productName));
    }

    public String getProductCost(String productName){
        return getText(getProductPrice(productName));
    }

    public void verifyProblemUser() {
        elementsExist(ERROR_IMG);
    }
    public String verifyBtnCondition(String productName){
        return getAddToCartBtn(productName).getText();
    }

}
