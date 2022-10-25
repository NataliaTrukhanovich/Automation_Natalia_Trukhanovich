package Lecture13;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.moodpanda.HomePage;
import pageObjects.moodpanda.NavigationPage;
import pageObjects.moodpanda.SignUpPage;
import pageObjects.moodpanda.entity.SignUpValOb;

public class SignUpValueObjectTest extends BaseTest {

    @Parameters({"url", "email", "password"})
    @Test
    public void loginTest(String url, String email, String password) {
        new HomePage().open(url);
        new NavigationPage().clickSignUp();

        SignUpValOb signUp = new SignUpValOb() {{
            setEmail("email");
            setCheckbox(true);
            setFirstName("First Name");
            setLastName("S");
            setPassword("password");
        }};

        new SignUpPage().enterData(signUp);
    }
}
