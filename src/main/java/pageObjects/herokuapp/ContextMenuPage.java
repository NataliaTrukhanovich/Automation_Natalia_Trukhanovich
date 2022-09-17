package pageObjects.herokuapp;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

public class ContextMenuPage extends BasePage {
    private By hotSpotMenu = By.id("hot-spot");

    private WebElement getHotSpot(){
        return driver.findElement(hotSpotMenu);
    }


    public ContextMenuPage clickContext() {
        actions.contextClick(getHotSpot()).build().perform();
        return this;
    }

    public ContextMenuPage verifyAlert(String expectedText) {
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), expectedText);
        alert.accept();
        return this;
    }
}
