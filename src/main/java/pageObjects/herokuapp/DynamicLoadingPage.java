package pageObjects.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.baseObjects.BasePage;

public class DynamicLoadingPage extends BasePage {

    private By startBtn = By.id("start");
    private By loading = By.id("loading");
    private By getByLink(String textLink){

        return By.partialLinkText(textLink);
    }

    public DynamicLoadingPage clickOnExample(String textLink){
        clickBtn(getByLink(textLink));
        return this;
    }
    public DynamicLoadingPage clickStart(){
        clickBtn(startBtn);
        return this;
    }
    public String pageIsLoaded(){
        wait.until(ExpectedConditions.textToBe(loading, "Loading..."));
        return getText(loading);
    }
}
