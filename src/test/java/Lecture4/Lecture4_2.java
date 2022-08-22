package Lecture4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Lecture4_2 {

    WebDriver driver;

    @BeforeTest
    public void preconditions(){
        driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void beforeMethod(){
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
    }

    @Test
    public void test1(){
        WebElement zipcode = driver.findElement(By.name("zip_code"));
        WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
        zipcode.click();
        zipcode.sendKeys("1234");
        continueButton.click();
        pause(2);
        WebElement zipcodeUpdate = driver.findElement(By.name("zip_code"));
        Assert.assertTrue(zipcodeUpdate.isDisplayed());

    }

    @Test
    public void test2(){
        WebElement zipcode = driver.findElement(By.name("zip_code"));
        WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
        zipcode.clear();
        zipcode.click();
        zipcode.sendKeys("12345");
        continueButton.click();
        pause(2);
        WebElement zipcodeUpdate = driver.findElement(By.name("zip_code"));
        Assert.assertFalse(zipcodeUpdate.isDisplayed());

    }

    @Test
    public void test3(){
        WebElement zipcode = driver.findElement(By.name("zip_code"));
        WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
        zipcode.click();
        zipcode.sendKeys("123456");
        continueButton.click();
        pause(2);
        WebElement zipcodeUpdate = driver.findElement(By.name("zip_code"));
        Assert.assertFalse(zipcodeUpdate.isDisplayed());
        driver.close();

    }



    private void pause(Integer timeout){
        try {
            Thread.sleep(timeout * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
