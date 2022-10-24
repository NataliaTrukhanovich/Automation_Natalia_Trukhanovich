package Lecture14;

import Lecture14.entity.Home;
import Lecture14.entity.SaucedemoBuilderLombok;
import lombok.extern.log4j.Log4j;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.LoginPage;

@Log4j

public class SaucedemoBuilderTest extends BaseTest {

    @Test
    public void saucedemoLoginBuilderTest() {
        get(LoginPage.class).openTestPage();
        Home home = new Home.HomeBuilder().create();

        SaucedemoBuilderLombok s = new SaucedemoBuilderLombok.SBuilder();
        SaucedemoBuilderLombok.SBuilder().withLogin("log").create();

    }
}

