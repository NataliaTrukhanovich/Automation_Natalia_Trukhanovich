package Lecture13;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.moodpanda.HomePage;
import pageObjects.moodpanda.NavigationPage;
import pageObjects.moodpanda.SignUpPage;
import pageObjects.moodpanda.entity.SignUpValOb;

public class SignUpValueObjectTest extends BaseTest {

    @Test
    public void loginTest() {
        new HomePage().open();
        new NavigationPage().clickSignUp();

        SignUpValOb signUp = new SignUpValOb() {{
            setEmail(properties.getProperty("email"));
            setCheckbox(true);
            setFirstName("First Name");
            setLastName("S");
            setPassword(properties.getProperty("password"));
        }};

        new SignUpPage().enterData(signUp);
    }
}
