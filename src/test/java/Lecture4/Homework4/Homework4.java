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

public class Homework4 {

    WebDriver driver;

    @BeforeTest
    public void beforeTest(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void test1(){
        driver.findElement(By.name("q")).sendKeys("Привет, мир");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        Assert.assertEquals(driver.findElement(By.name("q")).getAttribute("value"), "Привет, мир", "So sad...");
    }

    @Test
    public void test2(){
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("/***");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        Assert.assertEquals(driver.findElement(By.cssSelector("p:nth-child(1)")).getText(), "По запросу /*** ничего не найдено. ", "So sad...");
        driver.close();
    }

}
