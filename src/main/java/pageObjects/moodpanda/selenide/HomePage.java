package pageObjects.moodpanda.selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.baseObjects.SelenideBaseTest;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.exist;

@Log4j
public class HomePage {
    private SelenideElement imgLogo = $(By.xpath("//img[contains(@alt,'logo')]"));
    private SelenideElement pageTitleMessage = $("p[class^=title]");
    private SelenideElement messageBtn = $("[class^=box] [class^=button]");



    public HomePage checkHomeClick() {
        log.debug("Check logo image exists");
        Assert.assertTrue(imgLogo.exists());
        return this;
    }

    public HomePage checkWhatClick() {
        log.debug("Check What? page exists");
        log.debug("Page title of What? page : " + pageTitleMessage.text());
        Assert.assertEquals(pageTitleMessage.text(), "Monitor your mood");
        return this;
    }
    public HomePage checkHowClick() {
        log.debug("Check How? page exists");
        log.debug("Page title of How? page : " + pageTitleMessage.text());
        Assert.assertEquals(pageTitleMessage.text(), "How to use a mood diary");
        return this;
    }
    public HomePage checkAboutClick() {
        log.debug("Check About page exists");
        log.debug("Page title of About page : " + pageTitleMessage.text());
        Assert.assertEquals(pageTitleMessage.text(), "About MoodPanda");
        return this;
    }
    public HomePage checkContactusClick() {
        log.debug("Check Contact us page exists");
        Assert.assertTrue(messageBtn.exists());
        return this;
    }
}
