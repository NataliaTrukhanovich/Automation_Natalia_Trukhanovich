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
            /* Ожидание, указывающее на то какое максимальное количество времени Selenium будет
            дожидаться появления элемента. По сути срабатывает каждый раз при вызове
            функции driver.findElement(). */
            webDriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            //Ожидание выполнения java скрипта
            webDriver.get().manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
            //Ожидание прогрузки страницы
            webDriver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        }
    }

    public static WebDriver getWebDriver() {

        return webDriver.get();
    }

    public static void closeWebDriver() {
        webDriver.get().close();
        webDriver.get().quit();
        webDriver.remove();
    }

    private static ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        return chromeOptions;
    }

}