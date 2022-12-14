package pageObjects.baseObjects;

import org.testng.annotations.Listeners;
import testNGUtils.SelenideListener;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.driver;

@Listeners(SelenideListener.class)

public class SelenideBaseTest {
    protected <T> T get(Class<T> page) {
        return driver().hasWebDriverStarted() ? page(page) : open(baseUrl, page);
    }
    protected <T> T get(Class<T> page, String url) {
        return driver().hasWebDriverStarted() ? page(page) : open(url, page);
    }
}
