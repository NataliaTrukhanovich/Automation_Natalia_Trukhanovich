package pageObjects.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.baseObjects.BasePage;

public class DynamicLoadingPage extends BasePage {

    private By startBtn = By.xpath("//*[@id='start']//button");
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
        System.out.print("Текста на экране нет. Result is -> ");
        System.out.println(driver.findElement(By.xpath("//*[@id='finish']//h4")).isDisplayed());
        return this;
    }
    public void pageIsLoaded(){
        wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id='finish']//h4"), "Hello World!"));
        System.out.print("Waiting for \"Hello World!\". Now result is -> ");
        System.out.println(driver.findElement(By.xpath("//*[@id='finish']//h4")).isDisplayed());
    }
}
