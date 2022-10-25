package Lecture6;

import Driver.SimpleDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static Driver.SimpleDriver.getWebDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Task6 {
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


        /**   Создать отдельный Java-класс Task6 с тестом, сценарий:
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
        System.out.println("Price for Assert: " + price);
        String productName = getElementProduct(productName2).findElement(By.className("inventory_item_name")).getText();
        System.out.println("Name of the Product for Assert: " + productName);

        //xpath по атрибуту
        System.out.println(getElementProduct(productName1).findElement(By.xpath(".//div[@class='inventory_item_price']")).getText());

        //Кладем в корзину товары с именами productName1 и productName2
        getElementProduct(productName1).findElement(By.tagName("button")).click();
        getElementProduct(productName2).findElement(By.tagName("button")).click();
        //Кладем в корзину товар, следующий за productName2 (ancestor + following-sibling)
        getWebDriver().findElement(By.xpath("//div[@class='inventory_item_name' and text()='" + productName2 + "']/ancestor::div[@class='inventory_item']/following-sibling::div//button")).click();

        //xpath по частичному совпадению атрибута
        System.out.print("Кол-во продуктов в корзине: ");
        System.out.println(getWebDriver().findElement(By.xpath("//span[contains(@class,'cart_badge')]")).getText());

        //xpath с preceding-sibling (получаем название с верхней панели - PRODUCTS)
        System.out.println(getWebDriver().findElement(By.xpath("//div[@class='peek']/preceding-sibling::span[@class='title']")).getText());

        //Shopping Cart click
        getWebDriver().findElement(By.xpath("//a[@class='shopping_cart_link']")).click();


        //Cart Page
        String cartPrice = getElementCartItem(productName1).findElement(By.className("inventory_item_price")).getText();
        System.out.println("Cart Price: " + cartPrice);

        String cartItemName = getElementCartItem(productName2).findElement(By.className("inventory_item_name")).getText();
        System.out.println("Name of product #2: " + cartItemName);

        Assert.assertEquals(price, cartPrice);
        Assert.assertEquals(productName, cartItemName);

        //below (удаляем первый эл-т из корзины ч-з кнопку REMOVE)
        getWebDriver().findElement(with(By.xpath("//div[@class='cart_item']//button")).below(By.className("cart_desc_label"))).click();

        //Нажимаем на название товара Sauce Labs Onesie и переходим на его страницу (parent)
        getWebDriver().findElement(By.xpath("//div[@class='inventory_item_name' and text()='Sauce Labs Onesie']/parent::a")).click();

        //CSS Selectors

        //Страница с описанием товара (проверяем правильность описания и цену)
        // css по .class.class;  .class .class;  tagname; tagname.class
        String actualDescription;
        String expectedDescription = "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.";
        actualDescription = getWebDriver().findElement(By.cssSelector(".inventory_details_desc_container .inventory_details_desc.large_size")).getText();
        Assert.assertEquals(actualDescription, expectedDescription);

        String actualItemPrice = getWebDriver().findElement(By.cssSelector("div.inventory_details_price")).getText();
        String expectedItemPrice = "$7.99";
        Assert.assertEquals(actualItemPrice, expectedItemPrice);

        //Remove Item from Shopping Cart (css по #id)
        getWebDriver().findElement(By.cssSelector("#remove-sauce-labs-onesie")).click();

        //Кол-во товаров в корзине ([attribute=value]   [attribute^=value]   [attribute$=value]   [attribute*=value])
        System.out.println("Кол-во продуктов в корзине: " + getWebDriver().findElement(By.cssSelector("span[class='shopping_cart_badge']")).getText());
        System.out.println("Кол-во продуктов в корзине: " + getWebDriver().findElement(By.cssSelector("span[class^='shopping_cart']")).getText());
        System.out.println("Кол-во продуктов в корзине: " + getWebDriver().findElement(By.cssSelector("span[class$=badge]")).getText());
        System.out.println("Кол-во продуктов в корзине: " + getWebDriver().findElement(By.cssSelector("span[class*='_cart_']")).getText());

        //Вернулись к странице с товарами
        getWebDriver().findElement(By.cssSelector(".header_container.inventory_details .header_secondary_container button")).click();


    }

    private WebElement getElementProduct(String productName) {
        //xpath по атрибуту, ancestor, "and"
        return getWebDriver().findElement(By.xpath("//div[@class='inventory_item_name' and text()='" + productName + "']//ancestor::div[@class='inventory_item']"));
    }

    private WebElement getElementCartItem(String productName) {
        return getWebDriver().findElement(By.xpath("//div[@class='inventory_item_name' and text()='" + productName + "']//ancestor::div[@class='cart_item']"));
    }
}
