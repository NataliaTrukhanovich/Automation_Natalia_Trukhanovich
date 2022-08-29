package Lecture4.Homework4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Homework4 {

    /*Написать пару автоматических тестов с использованием библиотек testng и selenium
      Портал => https://www.google.by/
      - проверить поиск, если ввести “Привет, мир”. Проверить, что этот текст отображается в поисковой строке.
      - проверить поиск, если ввести “*//*” (проверить что отображается текст “По запросу *//* ничего не найдено.”)
     */

    WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void test1() {
        driver.findElement(By.name("q")).sendKeys("Привет, мир", Keys.ENTER);
        Assert.assertEquals(driver.findElement(By.name("q")).getAttribute("value"), "Привет, мир", "No such element");
    }

    @Test
    public void test2() {
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("/***");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        Assert.assertEquals(driver.findElement(By.cssSelector("p:nth-child(1)")).getText(), "По запросу /*** ничего не найдено. ", "No such element");
        driver.close();
    }


}
