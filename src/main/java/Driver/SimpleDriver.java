package Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class SimpleDriver {

    private static WebDriver webDriver;

    {
        if (webDriver == null) {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver(getChromeOptions());
            /* Ожидание, указывающее на то какое максимальное количество времени Selenium будет
            дожидаться появления элемента. По сути срабатывает каждый раз при вызове
            функции driver.findElement(). */
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            //Ожидание выполнения java скрипта
            webDriver.manage().timeouts().scriptTimeout(Duration.ofSeconds(20));
            //Ожидание прогрузки страницы
            webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        }
    }

    public static WebDriver getWebDriver() {

        return webDriver;
    }

    public static void closeWebDriver() {
        webDriver.close();
        webDriver.quit();
        webDriver = null;
    }

    private static ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        return chromeOptions;
    }

}