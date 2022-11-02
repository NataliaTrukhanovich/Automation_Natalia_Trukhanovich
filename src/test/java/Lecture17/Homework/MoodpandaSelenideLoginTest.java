package Lecture17.Homework;

import org.testng.annotations.Test;
import pageObjects.baseObjects.SelenideBaseTest;
import pageObjects.moodpanda.selenide.LoginPage;
import pageObjects.moodpanda.selenide.NavigationBarPage;

public class MoodpandaSelenideLoginTest extends SelenideBaseTest {
    @Test(description = "Empty email field")
    public void test1() {
        get(NavigationBarPage.class).clickLoginLink();
        get(LoginPage.class)
                .checkSignUpForm()
                .setEmail("")
                .setPassword("password")
                .clickLoginBtn()
                .checkEmptyEmailError();
    }

    @Test(description = "Empty password field")
    public void test2() {
        get(LoginPage.class)
                .checkSignUpForm()
                .setEmail("test@test.com")
                .setPassword("")
                .clickLoginBtn()
                .checkEmptyPasswordError();
    }

    @Test(description = "Invalid email field")
    public void test3() {
        get(LoginPage.class)
                .checkSignUpForm()
                .setEmail("####")
                .setPassword("password")
                .clickLoginBtn()
                .checkInvalidEmailError();
    }
}
