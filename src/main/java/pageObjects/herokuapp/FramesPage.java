package pageObjects.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pageObjects.baseObjects.BasePage;

public class FramesPage extends BasePage {
    private By iframe = By.id("mce_0_ifr");
    private By textArea = By.id("tinymce");
    private By boldTxt = By.cssSelector("[aria-label='Bold']");
    private By clickLink(String linkText) {
        return By.linkText(linkText);
    }

    public FramesPage clickFrameLink(String linkText) {
        clickBtn(clickLink(linkText));
        return this;
    }
    public FramesPage switchToFrame() {
        driver.switchTo().frame(driver.findElement(iframe));
        return this;
    }
    public FramesPage unSwitchFrame(){
        driver.switchTo().defaultContent();
        return this;
    }
    public FramesPage enterText(String txt){
        enter(textArea, txt);
        driver.findElement(textArea).sendKeys(Keys.LEFT_CONTROL+"a");
        return this;
    }
    public void clickBoldTxt(){
        clickBtn(boldTxt);
    }

}
