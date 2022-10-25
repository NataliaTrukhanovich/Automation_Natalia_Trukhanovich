package pageObjects.herokuapp;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.baseObjects.BasePage;

@Log4j
public class DynamicLoadingPage extends BasePage {

    private By startBtn = By.xpath("//*[@id='start']//button");
    private By loading = By.id("loading");

    private By getByLink(String textLink) {

        return By.partialLinkText(textLink);
    }

    public DynamicLoadingPage clickOnExample(String textLink) {
        click(getByLink(textLink));
        return this;
    }

    public DynamicLoadingPage clickStart() {
        click(startBtn);
        System.out.print("Текста на экране нет. Result is -> ");
        log.debug(driver.findElement(By.xpath("//*[@id='finish']//h4")).isDisplayed());
        return this;
    }

    public void pageIsLoaded() {
        wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id='finish']//h4"), "Hello World!"));
        System.out.print("Waiting for \"Hello World!\". Now result is -> ");
        log.debug(driver.findElement(By.xpath("//*[@id='finish']//h4")).isDisplayed());
    }
}
