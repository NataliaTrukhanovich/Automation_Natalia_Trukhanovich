package Lecture5;

import Driver.SimpleDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Driver.SimpleDriver.getWebDriver;

public class Task_5_2 {

    @BeforeTest
    public void preconditions() {
        SimpleDriver simpleDriver = new SimpleDriver();
        getWebDriver().get("https://calc.by/building-calculators/laminate.html");
        getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void test1() {
        enter("ln_room_id", "500");
        enter("wd_room_id", "400");
        enter("ln_lam_id", "2000");
        enter("wd_lam_id", "200");
        selectElement("с использованием отрезанного элемента");
        getWebDriver().findElement(By.id("direction-laminate-id1")).click();
        submit();
        List<String> actualData = getActualResults();
        actualData.forEach(str -> {
            System.out.println(str);
        });
        System.out.println();
        List<String> expectedData = Arrays.asList(
                "Требуемое количество досок ламината: 53",
                "Количество упаковок ламината: 7",
                "Ниже представлена схема укладки ламината"
        );
        Assert.assertEquals(actualData, expectedData);
    }

    @Test
    public void test2() {
        enter("ln_room_id", "700");
        enter("wd_room_id", "380");
        enter("ln_lam_id", "1391");
        enter("wd_lam_id", "203");
        selectElement("со смещение на 1/3 длины");
        getWebDriver().findElement(By.id("direction-laminate-id2")).click();
        submit();
        List<String> actualData = getActualResults();
        actualData.forEach(str -> {
            System.out.println(str);
        });
        System.out.println();
        List<String> expectedData = Arrays.asList(
                "Требуемое количество досок ламината: 111",
                "Количество упаковок ламината: 14",
                "Ниже представлена схема укладки ламината"
        );
        Assert.assertEquals(actualData, expectedData);
    }

    public void enter(String id, String value) {
        getWebDriver().findElement(By.id(id)).click();
        getWebDriver().findElement(By.id(id)).sendKeys(Keys.LEFT_CONTROL + "a", Keys.BACK_SPACE);
        getWebDriver().findElement(By.id(id)).sendKeys(value);
    }

    public void selectElement(String value) {
        Select select = new Select(getWebDriver().findElement(By.id("laying_method_laminate")));
        select.selectByVisibleText(value);
    }

    public void submit() {
        getWebDriver().findElement(By.cssSelector(".calc-btn-div .calc-btn")).click();
    }

    public List<String> getActualResults() {
        List<String> actualResults = new ArrayList<>();
        List<WebElement> result = getWebDriver().findElements(By.cssSelector("div.calc-result>div"));

        result.forEach(webElement -> {
            actualResults.add(webElement.getText());
        });


        return actualResults;
    }
    @AfterTest
    public void postconditions()
    {
        getWebDriver().close();
    }
}
