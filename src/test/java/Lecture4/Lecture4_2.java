package Lecture4;

import Driver.SimpleDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static Driver.SimpleDriver.getWebDriver;

public class Lecture4_2 {

    @BeforeTest
    public void preconditions() {
        SimpleDriver simpleDriver = new SimpleDriver();
        getWebDriver().get("https://www.sharelane.com/cgi-bin/register.py");
    }

    @BeforeMethod
    public void beforeMethod() {
        getWebDriver().get("https://www.sharelane.com/cgi-bin/register.py");
    }

    @Test
    public void test1() {
        WebElement zipcode = getWebDriver().findElement(By.name("zip_code"));
        WebElement continueButton = getWebDriver().findElement(By.xpath("//input[@value='Continue']"));
        zipcode.click();
        zipcode.sendKeys("1234");
        continueButton.click();
        pause(2);
        WebElement zipcodeUpdate = getWebDriver().findElement(By.name("zip_code"));
        Assert.assertTrue(zipcodeUpdate.isDisplayed());

    }

    @Test
    public void test2() {
        WebElement zipcode = getWebDriver().findElement(By.name("zip_code"));
        WebElement continueButton = getWebDriver().findElement(By.xpath("//input[@value='Continue']"));
        zipcode.clear();
        zipcode.click();
        zipcode.sendKeys("12345");
        continueButton.click();
        pause(2);
        WebElement zipcodeUpdate = getWebDriver().findElement(By.name("zip_code"));
        Assert.assertFalse(zipcodeUpdate.isDisplayed());

    }

    @Test
    public void test3() {
        WebElement zipcode = getWebDriver().findElement(By.name("zip_code"));
        WebElement continueButton = getWebDriver().findElement(By.xpath("//input[@value='Continue']"));
        zipcode.click();
        zipcode.sendKeys("123456");
        continueButton.click();
        pause(2);
        WebElement zipcodeUpdate = getWebDriver().findElement(By.name("zip_code"));
        Assert.assertFalse(zipcodeUpdate.isDisplayed());
       }

    @AfterTest
    public void postconditions() {
        getWebDriver().close();
    }

    private void pause(Integer timeout) {
        try {
            Thread.sleep(timeout * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

