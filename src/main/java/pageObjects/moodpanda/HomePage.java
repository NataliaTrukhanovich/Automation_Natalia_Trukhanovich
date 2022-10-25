package pageObjects.moodpanda;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import pageObjects.baseObjects.BasePage;

public class HomePage extends MoodPandaBasePage {
    private By getStartedBtn = By.partialLinkText("Get started");
    private By title = By.cssSelector("[class^=container] > p[class^='title ']");

    public HomePage open(String url) {
        load(url);
        isPageOpened();
        return this;
    }

    public HomePage clickGetStarted() {
        click(getStartedBtn);
        return this;
    }

    @Override
    public void isPageOpened() {
        waitVisibilityOfElement(title);
        verifyElementClickable(getStartedBtn);
    }
}
