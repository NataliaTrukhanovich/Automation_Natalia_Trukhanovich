package Lecture13;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageFactory.moodpanda.HomePage;
import pageFactory.moodpanda.LoginPage;
import pageObjects.baseObjects.BaseTest;

public class LoginPageFactoryTest extends BaseTest {

    @Test
    public void login_Test() {
        new HomePage()
                .open()
                .clickGetStarted();
        new LoginPage()
                .enterEmail(properties.getProperty("email"))
                .enterPassword(properties.getProperty("password"))
                .clickLogin()
                .verifyErrorMessage("Your email or password is wrong");
    }
}
