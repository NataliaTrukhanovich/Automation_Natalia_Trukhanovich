package Lecture6;

import Driver.SimpleDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static Driver.SimpleDriver.getWebDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Task_6 {
    @BeforeTest
    public void preconditions() {
        SimpleDriver simpleDriver = new SimpleDriver();
        getWebDriver().get("https://www.saucedemo.com/");
    }

    @Test
    public void testExample() {

        getWebDriver().findElement(By.id("user-name")).sendKeys("standard_user");   //id
        getWebDriver().findElement(By.name("password")).sendKeys("secret_sauce");   //name
        getWebDriver().findElement(By.className("submit-button")).click();                     //classname
        getWebDriver().findElement(By.tagName("select")).click();                              //tagName
        System.out.println(getWebDriver().findElement(By.linkText("Twitter")).getText());      //linkText
        System.out.println(getWebDriver().findElement(By.partialLinkText("Face")).getText());  //partialLinkText

        //xpath по частичному совпадению текста (LinkedIn) + descendant
        System.out.println(getWebDriver().findElement(By.xpath("//ul//descendant::a[contains(text(),'Link')]")).getText());
        //xpath по тексту
        System.out.println("Product Name: " + getWebDriver().findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).getText());


        /**    Создать отдельный Java-класс Task_6 с тестом, сценарий:
         a.	Залогиниться https://www.saucedemo.com/
         b.	Добавить товар в корзину
         c.	Перейти в корзину
         d.	Проверить (assertEquals) стоимость товара и его имя в корзине
         */

        //Два товара для корзины. У первого проверяем цену, у второго - наименование
        String productName1 = "Sauce Labs Bike Light";
        String productName2 = "Sauce Labs Fleece Jacket";

        //Цена первого продукта для Assert и наименование второго продукта для Assert
        String price = getElementProduct(productName1).findElement(By.className("inventory_item_price")).getText();
        System.out.println("Price: " + price);
        String productName = getElementProduct(productName2).findElement(By.className("inventory_item_name")).getText();
        System.out.println("Name of the Product for Assert: " + productName);

        //СЛЕДУЮЩАЯ СТРОКА ВОЗВРАЩАЕТ НЕВЕРНУЮ ЦЕНУ. ПРИХОДИТ ЦЕНА ПЕРВОГО ПРОДУКТА НА СТРАНИЦЕ,ХОТЯ ЕСЛИ ВВЕСТИ ЭТО В КОНСОЛИ РАЗРАБОТЧИКА,
        //ТО ПОДСВЕЧИВАЕТСЯ ПРАВИЛЬНЫЙ ТЕГ
        System.out.println(getElementProduct(productName1).findElement(By.xpath("//div[@class='inventory_item_price']")).getText());

        getElementProduct(productName1).findElement(By.tagName("button")).click();
        getElementProduct(productName2).findElement(By.tagName("button")).click();

        //xpath по частичному совпадению атрибута
        System.out.print("Кол-во продуктов в корзине: ");
        System.out.println(getWebDriver().findElement(By.xpath("//span[contains(@class,'cart_badge')]")).getText());

        //НЕ РАБОТАЕТ. ПОЧЕМУ?
        //   System.out.println(getWebDriver().findElement(By.xpath("//div[@class='header_secondary_container']/following-sibling::span[@class='title']")).getText());

        //Shopping Cart click
        getWebDriver().findElement(By.xpath("//a[@class='shopping_cart_link']")).click();

        //Cart Page
        String cartPrice = getElementCartItem(productName1).findElement(By.className("inventory_item_price")).getText();
        System.out.println("Cart Price: " + cartPrice);

        String cartItemName = getElementCartItem(productName2).findElement(By.className("inventory_item_name")).getText();
        System.out.println("Name of product #2: " + cartItemName);

        Assert.assertEquals(price, cartPrice);
        Assert.assertEquals(productName, cartItemName);

        //below
        getWebDriver().findElement(with(By.tagName("button")).below(By.className("cart_desc_label"))).click();

    }

    private WebElement getElementProduct(String productName) {
        //xpath по атрибуту, ancestor, "and"
        return getWebDriver().findElement(By.xpath("//div[@class='inventory_item_name' and text()='" + productName + "']//ancestor::div[@class='inventory_item']"));
    }

    private WebElement getElementCartItem(String productName) {
        return getWebDriver().findElement(By.xpath("//div[@class='inventory_item_name' and text()='" + productName + "']//ancestor::div[@class='cart_item']"));
    }
}
