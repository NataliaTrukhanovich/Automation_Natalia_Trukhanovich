package Lecture17;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.enabled;


public class SelenideTest {

    @BeforeTest
    public void preconditions(){
        baseUrl="https://www.rw.by/";
    }

    @Test
    public void openPageTest(){
        open(baseUrl);
        $("#acFrom").sendKeys("Витебск");
        $(By.id("acTo")).sendKeys("Минск");
        $("#yDate").click();
        $(byXpath("//*[contains(@class, 'group-middle')]"))
                .find(By.xpath("table"))
                .find(By.linkText("1")).click();

        SelenideElement button = $("[class=std-button]");
        button.should(enabled).click();

        ElementsCollection collection = $$("[class=sch-table__body-wrap] [class=sch-table__row]");
        collection.should(sizeGreaterThan(0));
        System.out.println(collection.filterBy(matchText("Санкт-Петербург-Витеб")).texts());
    }

}
