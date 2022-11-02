package pageObjects.moodpanda.selenide;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
@Log4j
public class NavigationBarPage {
    private final SelenideElement homeImage = $("img[alt='MoodPanda home']");
    private final SelenideElement homeLink = $(By.xpath("//div//a[contains(text(),'Home')]"));
    private final SelenideElement whatLink = $(By.xpath("//div//a[contains(text(),'What')]"));
    private final SelenideElement howLink = $(By.xpath("//div//a[contains(text(),'How')]"));
    private final SelenideElement aboutLink = $(By.xpath("//div//a[contains(text(),'About')]"));
    private final SelenideElement contactUsLink = $(By.xpath("//div//a[contains(text(),'Contact')]"));
    private final SelenideElement signUpLink = $(By.xpath("//div[@class='buttons']//a[contains(@href,'signup')]"));
    private final SelenideElement loginLink = $(By.xpath("//div[@class='buttons']//a[contains(@href,'login')]"));


    public NavigationBarPage clickHomeImage(){
        log.debug("Click Home Image by Selenide element :: "+homeImage);
        homeImage.should(exist).click();
        return this;
    }
    public NavigationBarPage clickHomeLink(){
        log.debug("Click Home Link by Selenide element :: "+homeLink);
        homeLink.shouldBe(exist).click();
        return this;
    }
    public NavigationBarPage clickWhatLink(){
        log.debug("Click What? link by Selenide element :: "+whatLink);
        whatLink.shouldBe(exist).click();
        return this;
    }
    public NavigationBarPage clickHowLink(){
        log.debug("Click How Link by Selenide element :: "+howLink);
        howLink.shouldBe(exist).click();
        return this;
    }
    public NavigationBarPage clickAboutLink(){
        log.debug("Click About Link by Selenide element :: "+aboutLink);
        aboutLink.shouldBe(exist).click();
        return this;
    }
    public NavigationBarPage clickContactUsLink(){
        log.debug("Click Contact us Link by Selenide element :: "+contactUsLink);
        contactUsLink.shouldBe(exist).click();
        return this;
    }
    public NavigationBarPage clickSignUpLink(){
        log.debug("Click SignUp Link by Selenide element :: "+signUpLink);
        signUpLink.shouldBe(exist).click();
        return this;
    }
    public NavigationBarPage clickLoginLink(){
        log.debug("Click Login Link by Selenide element :: "+loginLink);
        loginLink.shouldBe(exist).click();
        return this;
    }
}
