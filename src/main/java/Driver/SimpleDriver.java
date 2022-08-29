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

            //Ещё возможные варианты создания драйвера
            //WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
            //WebDriverManager.getInstance("chrome").setup();

            //Если мы не используем WebDriverManager, то тогда вызываем метод setWebDriver.
            //При использовании WebDriverManager метод setWebDriver не нужен, мы всё делаем в блоке инициализации
            //setWebDriver();
        }
    }

    public static WebDriver getWebDriver(){
        return webDriver;
    }

    private static void setWebDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        webDriver = new ChromeDriver(getChromeOptions());
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    private static ChromeOptions getChromeOptions(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        return chromeOptions;
    }
}
