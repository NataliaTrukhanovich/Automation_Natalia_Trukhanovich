package Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class SimpleDriver {

    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    {
        if (webDriver.get() == null) {
            WebDriverManager.chromedriver().setup();
            webDriver.set(new ChromeDriver(getChromeOptions()));
            webDriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            webDriver.get().manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
            webDriver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        }
    }
    public static WebDriver getWebDriver() {

        return webDriver.get();
    }
    public static void closeWebDriver() {
        if (webDriver != null) {
            webDriver.get().close();
            webDriver.get().quit();
            webDriver.remove();
        }
    }
    private static ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        return chromeOptions;
    }
}