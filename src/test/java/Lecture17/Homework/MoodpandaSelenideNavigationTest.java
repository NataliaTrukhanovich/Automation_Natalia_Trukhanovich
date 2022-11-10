package Lecture17.Homework;

import org.testng.annotations.Test;
import pageObjects.baseObjects.SelenideBaseTest;
import pageObjects.moodpanda.selenide.HomePage;
import pageObjects.moodpanda.selenide.NavigationBarPage;

public class MoodpandaSelenideNavigationTest extends SelenideBaseTest {
    @Test
    public void navigationTest() {
        get(NavigationBarPage.class).clickHomeImage();
        get(HomePage.class).checkHomeClick();

        get(NavigationBarPage.class).clickHomeLink();
        get(HomePage.class).checkHomeClick();

        get(NavigationBarPage.class).clickWhatLink();
        get(HomePage.class).checkWhatClick();

        get(NavigationBarPage.class).clickHowLink();
        get(HomePage.class).checkHowClick();

        get(NavigationBarPage.class).clickAboutLink();
        get(HomePage.class).checkAboutClick();

        get(NavigationBarPage.class).clickContactUsLink();
        get(HomePage.class).checkContactusClick();

    }
}
