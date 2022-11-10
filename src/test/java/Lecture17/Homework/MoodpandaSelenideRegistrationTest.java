package Lecture17.Homework;

import org.testng.annotations.Test;
import pageObjects.baseObjects.SelenideBaseTest;
import pageObjects.moodpanda.selenide.NavigationBarPage;
import pageObjects.moodpanda.selenide.SignUpPage;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;

public class MoodpandaSelenideRegistrationTest extends SelenideBaseTest {

    @Test(priority = 1)
    public void positiveTest() {
        get(NavigationBarPage.class).clickSignUpLink();
        get(SignUpPage.class)
                .checkSignUpForm()
                .enterFirstName("John")
                .enterLastName("S")
                .enterEmail("test@test.com")
                .enterPassword("password")
                .clickCheckbox()
                .clickSignUp()
                .checkEmailConfirmation()
                .clickRegConfirmationBtn();

    }

    @Test(priority = 2, description = "Empty First Name Field")
    public void negativeTest1() {
        open(baseUrl);
        get(NavigationBarPage.class).clickSignUpLink();
        get(SignUpPage.class)
                .checkSignUpForm()
                .enterFirstName("")
                .enterLastName("S")
                .enterEmail("test@test.com")
                .enterPassword("password")
                .clickCheckbox()
                .clickSignUp()
                .checkEmailConfirmation()
                .clickRegConfirmationBtn()
                .checkEmptyFieldError();
    }

    @Test(priority = 3, description = "Short Password")
    public void negativeTest2() {
        open(baseUrl);
        get(NavigationBarPage.class).clickSignUpLink();
        get(SignUpPage.class)
                .checkSignUpForm()
                .enterFirstName("Mike")
                .enterLastName("S")
                .enterEmail("test@test.com")
                .enterPassword("pass")
                .clickCheckbox()
                .clickSignUp()
                .checkEmailConfirmation()
                .clickRegConfirmationBtn()
                .checkShortPasswordError();
    }
}
