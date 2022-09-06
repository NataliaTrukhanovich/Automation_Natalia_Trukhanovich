package Lecture5;

import Driver.SimpleDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static Driver.SimpleDriver.getWebDriver;

public class Lecture5_1 {

    /*Написать автоматический тест с использованием библиотек testng и selenium
     *Портал => https://www.google.by/
     *Ввести в строку поиска “Привет, мир”. Проверить, что в ссылках после поиска отображается текст “Привет, мир”.
     */
    //Работает пока некорректно, т.к. не до конца изучены css селекторы и используется неполный селектор при
    //формировании списка

    @BeforeTest
    public void preconditions() {
        SimpleDriver simpleDriver = new SimpleDriver();
        getWebDriver().get("https://www.google.com");
    }

    @Test
    public void test1() {
        getWebDriver().findElement(By.name("q")).sendKeys("Привет мир", Keys.ENTER);
        List<WebElement> results = getWebDriver().findElements(By.xpath("//a//h3[@class='LC20lb MBeuO DKV0Md' and (contains(text(),'Привет мир') or contains(text(),'Привет, Мир'))]"));
        for (WebElement element : results) {
           //Assert.assertTrue(element.getText().contains("Мир") || element.getText().contains("мир"));
            System.out.println(element.getText());
        }
    }

    @AfterTest
    public void postconditions() {
        getWebDriver().close();
    }
}

