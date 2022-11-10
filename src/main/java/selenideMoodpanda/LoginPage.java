package selenideMoodpanda;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.moodpanda.MoodPandaBasePage;

import static com.codeborne.selenide.Selenide.$;

@Log4j
public class LoginPage{

    private SelenideElement email = $(By.cssSelector("[type='text']"));
    private SelenideElement password = $(By.cssSelector("[type='password']"));
    private SelenideElement loginBtn = $(By.xpath("//button[@class]"));
    private SelenideElement notification = $(By.cssSelector("[class^=notification]"));


    public LoginPage enterPassword(String password) {
        this.password.sendKeys(password);
        return this;
    }

    public LoginPage enterEmail(String email) {
        this.email.sendKeys(email);
        return this;
    }

    public LoginPage clickLogin() {
        loginBtn.click();
        return this;
    }

    public LoginPage verifyErrorMessage(String message) {
        notification.should(Condition.text(message));
        return this;


    }
 }
