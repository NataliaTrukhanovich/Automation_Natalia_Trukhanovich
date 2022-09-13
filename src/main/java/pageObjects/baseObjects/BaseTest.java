package pageObjects.baseObjects;

import Driver.SimpleDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static Driver.SimpleDriver.closeWebDriver;

public abstract class BaseTest {

    @BeforeTest
    public void preconditions() {
        System.out.println("Starting new web driver!");
        new SimpleDriver();
    }

    @AfterTest
    public void postconditions(){
        System.out.println("Closing web driver!");
       // closeWebDriver();
    }
}
