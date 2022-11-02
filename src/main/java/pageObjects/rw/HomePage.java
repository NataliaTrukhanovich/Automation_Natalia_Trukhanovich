package pageObjects.rw;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

@Log4j
public class HomePage {
    private final SelenideElement from = $("#acFrom");
    private final SelenideElement to = $(By.id("acTo"));
    private final SelenideElement date = $("#yDate");
    private final SelenideElement searchBtn = $("[class=std-button]");

    public HomePage enterFrom(String from) {
        log.debug("Set from : " + from);
        this.from.sendKeys(from);
        return this;
    }

    public HomePage enterTo(String to) {
        log.debug("Set to : " + to);
        this.to.sendKeys(to);
        return this;
    }

    private SelenideElement getMiddleCalendar(String date) {
        log.debug("Get calendar table");
        return $(byXpath("//*[contains(@class, 'group-middle')]"))
                .should(visible)
                .find(By.xpath("table"))
                .find(By.linkText(date));
    }

    public HomePage enterMiddleCalendar(String date) {
        this.date.click();
        getMiddleCalendar(date).click();
        log.debug("Choose date : " + date);
        return this;
    }

    public HomePage clickSearch() {
        log.debug("Click button \" Поиск \"");
        searchBtn.shouldBe(enabled).click();
        return this;
    }
}
