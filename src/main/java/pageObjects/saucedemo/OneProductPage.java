package pageObjects.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageObjects.baseObjects.BasePage;

public class OneProductPage extends BasePage {

private WebElement getElementProduct(String productName){
    return driver.findElement(By.xpath("//*[@class='inventory_details_name large_size']//ancestor::div[@class='inventory_details_desc_container']"));
}
private WebElement getElementProductName(String productName){
    return getElementProduct(productName).findElement(By.className("inventory_details_name large_size"));
}
private WebElement getElementProductPrice(String productName){
    return getElementProduct(productName).findElement(By.className("inventory_details_price"));
}
private WebElement getProductAddAndRemoveBtn(String productName){
    return getElementProduct(productName).findElement(By.xpath("//button[contains(@class,' btn_inventory')]"));
}
private WebElement getButtonBack(){
    return driver.findElement(By.xpath("//button[contains(@class,' inventory_details_back_button')]"));
}
public String getElementProductNameValue(String productName){
    return getElementProductName(productName).getText();
}
public String getElementProductPriceValue(String productName){
    return getElementProductPrice(productName).getText();
}
public void clickProductAddAndRemoveBtn(String productName){
    click(getProductAddAndRemoveBtn(productName));
}
public void clickBackToProducts(){
    click(getButtonBack());
}
}
