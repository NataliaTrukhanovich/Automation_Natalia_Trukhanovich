package Lecture13;

import lombok.extern.log4j.Log4j;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.moodpanda.HomePage;
import pageObjects.moodpanda.NavigationPage;
import pageObjects.moodpanda.SignUpPage;
import pageObjects.moodpanda.entity.SignUpBuilder;
@Log4j
public class SignUpBuilderTest extends BaseTest {

    @Test
    public void loginTest() {
        new HomePage().open();
        new NavigationPage().clickSignUp();

        SignUpBuilder signUpBuilder = new SignUpBuilder.Builder()
                .withFirstName("First name")
                .withLastName("S")
                .withPassword(properties.getProperty("password"))
                .withCheckbox(false)
                .withEmail(properties.getProperty("email"))
                .build();

        log.debug(signUpBuilder);
        new SignUpPage().enterData(signUpBuilder);

    }

}
