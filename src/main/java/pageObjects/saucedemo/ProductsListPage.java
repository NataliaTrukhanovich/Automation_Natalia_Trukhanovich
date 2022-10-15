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

    public ProductsListPage verifyPageUri() {
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"));
        return this;
    }

    public ProductsListPage verifyPageTitle() {
        System.out.println(getText(TITLE));
        Assert.assertEquals(getText(TITLE), "PRODUCTS");
        return this;
    }

    private WebElement getElementProduct(String productName) {
        return driver.findElement(By.xpath("//*[@class = 'inventory_item_name' and text() = '" + productName + "']//ancestor::div[@class='inventory_item']"));
    }

    private WebElement getProductPrice(String productName) {
        return getElementProduct(productName).findElement(By.className("inventory_item_price"));
    }

    private WebElement getAddToCartBtn(String productName) {
        return getElementProduct(productName).findElement(By.tagName("button"));
    }

    public void elementsExist(By locator) {
        Assert.assertEquals(driver.findElements(locator).size(), 6);
    }

    public ProductsListPage clickAddToCartBtn(String productName) {
        click(getAddToCartBtn(productName));
        return this;
    }

    public String getProductCost(String productName) {
        return getText(getProductPrice(productName));
    }

    public void verifyProblemUser() {
        Assert.assertEquals(driver.findElements(ERROR_IMG).size(), 6);
    }

    public String verifyBtnCondition(String productName) {
        return getAddToCartBtn(productName).getText();
    }

}
