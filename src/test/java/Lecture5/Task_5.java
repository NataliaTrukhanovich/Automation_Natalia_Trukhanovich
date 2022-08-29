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

import java.util.ArrayList;
import java.util.List;

import static Driver.SimpleDriver.getWebDriver;

public class Task_5 {

    @BeforeTest
    public void preconditions() {
        SimpleDriver simpleDriver = new SimpleDriver();
        getWebDriver().get("https://masterskayapola.ru/kalkulyator/laminata.html");
    }

    @Test
    public void test1() {
        enter("calc_roomwidth", "10");
        enter("calc_roomheight", "5");

        enter("calc_lamwidth", "1300");
        enter("calc_lamheight", "192");
        enter("calc_inpack", "12");
        enter("calc_price", "500");

        select("calc_direct", "По длине комнаты");
        enter("calc_bias", "300");
        enter("calc_walldist", "20");

        submit();

        List<String> actualResults = getActualResults();
        List<String> expectedResults = new ArrayList<>() {{
            add("Площадь укладки: 49.40 м2.");
            add("Кол-во панелей: 202 шт.");
            add("Кол-во упаковок: 17 шт.");
            add("Стоимость: 25459 руб.");
            add("Остатки: 2 шт.");
            add("Отрезки: 9 шт.");
        }};
        Assert.assertEquals(actualResults, expectedResults);
    }

    @Test
    public void test2() {
        enter("calc_roomwidth", "15");
        enter("calc_roomheight", "4");

        enter("calc_lamwidth", "1300");
        enter("calc_lamheight", "170");
        enter("calc_inpack", "24");
        enter("calc_price", "900");

        select("calc_direct", "По ширине комнаты");
        enter("calc_bias", "300");
        enter("calc_walldist", "15");

        submit();

        List<String> actualResults = getActualResults();
        List<String> expectedResults = new ArrayList<>() {{
            add("Площадь укладки: 59.43 м2.");
            add("Кол-во панелей: 290 шт.");
            add("Кол-во упаковок: 13 шт.");
            add("Стоимость: 62056 руб.");
            add("Остатки: 22 шт.");
            add("Отрезки: 46 шт.");
        }};
        Assert.assertEquals(actualResults, expectedResults);
    }

    @Test
    public void test3() {
        enter("calc_roomwidth", "8");
        enter("calc_roomheight", "6");

        enter("calc_lamwidth", "650");
        enter("calc_lamheight", "192");
        enter("calc_inpack", "20");
        enter("calc_price", "750");

        select("calc_direct", "По длине комнаты");
        enter("calc_bias", "250");
        enter("calc_walldist", "10");

        submit();

        List<String> actualResults = getActualResults();
        List<String> expectedResults = new ArrayList<>() {{
            add("Площадь укладки: 47.72 м2.");
            add("Кол-во панелей: 405 шт.");
            add("Кол-во упаковок: 21 шт.");
            add("Стоимость: 39312 руб.");
            add("Остатки: 15 шт.");
            add("Отрезки: 11 шт.");
        }};
        Assert.assertEquals(actualResults, expectedResults);
    }

    @AfterTest
    public void postconditions() {
        getWebDriver().close();
    }

    public void enter(String name, String value) {
        getWebDriver().findElement(By.name(name)).click();
        getWebDriver().findElement(By.name(name)).sendKeys(Keys.LEFT_CONTROL+"a", Keys.BACK_SPACE);
        getWebDriver().findElement(By.name(name)).sendKeys(value);
    }

    public void select(String name, String value) {
        Select select = new Select(getWebDriver().findElement(By.name(name)));
        select.selectByVisibleText(value);
    }

    public void submit() {
        getWebDriver().findElement(By.cssSelector("[value='Рассчитать']")).click();
    }

    public List<String> getActualResults() {
        List<String> actualResults = new ArrayList<>();
        List<WebElement> result = getWebDriver().findElements(By.cssSelector(".whiteback [class='form_element']"));
        result.forEach(webElement -> {
            actualResults.add(webElement.getText());
        });

        return actualResults;
    }

}
