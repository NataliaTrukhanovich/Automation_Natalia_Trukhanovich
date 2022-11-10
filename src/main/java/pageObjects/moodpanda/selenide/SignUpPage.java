package pageObjects.moodpanda.selenide;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.collections.SizeLessThan;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.enabled;
@Log4j
public class SignUpPage {
    private SelenideElement form = $("[class='box']");
    private SelenideElement firstName = $("[placeholder='Your first name']");
    private SelenideElement lastName = $(By.xpath("//div[@class='control']//input[contains(@placeholder,'e.g.')]"));
    private SelenideElement email = $("[placeholder='Your email address']");
    private SelenideElement password = $("[type='password']");
    private SelenideElement checkBox = $("[type='checkbox']");
    private SelenideElement signUpBtn = $(By.xpath("//*[@class='box']//button"));
    private SelenideElement emailConfirmation = $("[class='box']");
    private SelenideElement regConfirmationBtn = $("[class='field'] button");
    private SelenideElement firstNameError = $(By.xpath("//div[contains(text(),'First name is required')]"));
    private SelenideElement passwordError = $(By.xpath("//div[contains(text(),'Password')]"));

    public SignUpPage checkSignUpForm() {
        if ((form.isDisplayed() == true)) {
            log.debug("Registration form is displayed!");
        } else {
            log.debug("Registration form isn't displayed!");
        }
        return this;
    }

    public SignUpPage enterFirstName(String firstName) {
        this.firstName.shouldBe(enabled).sendKeys(firstName);
        log.debug("Enter First Name value : "+firstName);
        return this;
    }

    public SignUpPage enterLastName(String lastName) {
                this.lastName.shouldBe(enabled).sendKeys(lastName);
        log.debug("Enter Last Name value : "+lastName);
        return this;
    }

    public SignUpPage enterEmail(String email) {
        this.email.shouldBe(enabled).sendKeys(email);
        log.debug("Enter email value : "+email);
        return this;
    }

    public SignUpPage enterPassword(String password) {
        this.password.shouldBe(enabled).sendKeys(password);
        log.debug("Enter Password value : "+password);
        return this;
    }

    public SignUpPage clickCheckbox() {
        checkBox.click();
        log.debug("Click checkbox");
        return this;
    }

    public SignUpPage clickSignUp() {
        log.debug("Click signUp button");
        signUpBtn.shouldBe(enabled).click();
        return this;
    }
    public SignUpPage checkEmailConfirmation(){
        Assert.assertTrue(emailConfirmation.isDisplayed());
        log.debug("Email Confirmation is displayed");
        return this;
    }
    public SignUpPage clickRegConfirmationBtn(){
        log.debug("Click \"Yes.Sign me up\" button");
        regConfirmationBtn.click();
        return this;
    }
    public SignUpPage checkEmptyFieldError(){
        log.debug("Check Empty Field Error");
        Assert.assertEquals(firstNameError.text(), "First name is required");
        return this;
    }
    public SignUpPage checkShortPasswordError(){
        log.debug("Check Short Password Error");
        Assert.assertEquals(passwordError.text(), "The Password must be at least 8 characters.");
        return this;
    }

}
