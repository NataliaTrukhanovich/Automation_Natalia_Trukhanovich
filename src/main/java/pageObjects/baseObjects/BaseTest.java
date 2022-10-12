package pageObjects.baseObjects;

import Driver.SimpleDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import testNGUtils.ExtentReportListener;
import testNGUtils.InvokedMethodListener;

import java.lang.reflect.InvocationTargetException;

import static Driver.SimpleDriver.closeWebDriver;
@Listeners({InvokedMethodListener.class, ExtentReportListener.class})

public abstract class BaseTest {

    @BeforeTest()
    public void setUpDriver() {
        System.out.println("Starting new web driver!");
        new SimpleDriver();
    }

    protected <T> T get(Class<T> page){
        T instance = null;
        try {
            instance=page.getDeclaredConstructor().newInstance();
        } catch (InstantiationException|IllegalAccessException|InvocationTargetException|NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        return instance;
    }

    @AfterTest()
    public void stopDriver(){
        System.out.println("Closing web driver!");
        closeWebDriver();
    }
}
