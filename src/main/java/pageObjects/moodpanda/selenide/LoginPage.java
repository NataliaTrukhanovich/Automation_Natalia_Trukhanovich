package pageObjects.moodpanda.selenide;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;

@Log4j
public class LoginPage {
    private SelenideElement loginForm = $("[class='box']");
    private SelenideElement email = $(By.xpath("//*[contains(@placeholder, 'email')]"));
    private SelenideElement password = $("[name='password']");
    private SelenideElement loginBtn = $("[class] button");
    private SelenideElement emailError = $(By.xpath("//div[contains(text(),'mail')]"));
    private SelenideElement passwordError = $(By.xpath("//div[contains(text(),'word')]"));
    public LoginPage checkSignUpForm() {
        if ((loginForm.isDisplayed() == true)) {
            log.debug("Authorization form is displayed!");
        } else {
            log.debug("Authorization form isn't displayed!");
        }
        return this;
    }

    public LoginPage setEmail(String email) {
        log.debug("Set email :: "+email);
        this.email.sendKeys(Keys.LEFT_CONTROL+"a", Keys.DELETE);
        this.email.sendKeys(email);
        return this;
    }

    public LoginPage setPassword(String password) {
        log.debug("Set password :: "+password);
        this.password.sendKeys(Keys.LEFT_CONTROL+"a", Keys.DELETE);
        this.password.sendKeys(password);
        return this;
    }

    public LoginPage clickLoginBtn(){
        log.debug("Click Login button");
        this.loginBtn.click();
        return this;
    }
    public LoginPage checkEmptyEmailError(){
        log.debug("Check Empty Email Field Error");
        Assert.assertEquals(emailError.text(), "Email address is required");
        return this;
    }
    public LoginPage checkEmptyPasswordError(){
        log.debug("Check Empty Password Field Error");
        Assert.assertEquals(passwordError.text(), "Password is required");
        return this;
    }
    public LoginPage checkInvalidEmailError(){
        log.debug("Check Invalid email address Error");
        Assert.assertEquals(emailError.text(), "Invalid email address");
        return this;
    }
}
