package pageObjects.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

public class DynamicControlsPage extends BasePage {
    private By checkboxBtn = By.xpath("//input[@type='checkbox']");
    private By RemoveBtn = By.xpath("//button[text()='Remove']");
    private By message = By.id("message");
    private By inputTxt = By.xpath("//input[@type='text']");
    private By enableBtn = By.xpath("//button[text()='Enable']");

    private WebElement getCheckboxBtn() {
        return driver.findElement(checkboxBtn);
    }

    private WebElement getRemoveBtn() {
        return driver.findElement(RemoveBtn);
    }

    private WebElement getMessage() {
        return driver.findElement(message);
    }

    private WebElement getInputTxt() {
        return driver.findElement(inputTxt);
    }

    public DynamicControlsPage clickCheckbox() {
        clickBtn(getCheckboxBtn());
        return this;
    }

    public DynamicControlsPage clickRemove() {
        clickBtn(getRemoveBtn());
        return this;
    }

    public String messageTxt() {
        return getMessage().getText();
    }

    public DynamicControlsPage isExistCheckbox() {
        Assert.assertEquals(driver.findElements(checkboxBtn).size(), 0, "Checkbox is still here");
        return this;
    }

    public DynamicControlsPage isDisableInput() {
        System.out.println("Input is " + getInputTxt().isEnabled());
        Assert.assertFalse(getInputTxt().isEnabled());
        return this;
    }

    public DynamicControlsPage clickEnableBtn() {
        clickBtn(enableBtn);
        return this;
    }

    public DynamicControlsPage isEnableInput() {
        wait.until(ExpectedConditions.elementToBeClickable(getInputTxt()));
        System.out.println("Input is " + getInputTxt().isEnabled());
        Assert.assertTrue(getInputTxt().isEnabled());
        return this;
    }
}
