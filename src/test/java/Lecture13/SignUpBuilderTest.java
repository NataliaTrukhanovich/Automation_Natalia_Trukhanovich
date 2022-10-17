package Lecture13;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.moodpanda.HomePage;
import pageObjects.moodpanda.NavigationPage;
import pageObjects.moodpanda.SignUpPage;
import pageObjects.moodpanda.entity.SignUpBuilder;

public class SignUpBuilderTest extends BaseTest {

    @Parameters("url")
    @Test
    public void loginTest(String url) {
        new HomePage().open(url);
        new NavigationPage().clickSignUp();

        SignUpBuilder signUpBuilder = new SignUpBuilder.Builder()
                .withFirstName("First name")
                .withLastName("S")
                .withPassword("pass")
                .withCheckbox(false)
                .withEmail("email")
                .build();

        System.out.println(signUpBuilder);
        new SignUpPage().enterData(signUpBuilder);

    }

}
