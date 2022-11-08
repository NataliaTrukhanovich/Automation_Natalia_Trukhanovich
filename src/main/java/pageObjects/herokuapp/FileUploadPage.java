package pageObjects.herokuapp;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

@Log4j
public class FileUploadPage extends BasePage {
    private By chooseAFileBtn = By.id("file-upload");
    private By uploadBtn = By.id("file-submit");
    private String pathToFile = System.getProperty("user.dir") + "\\files\\Many Happies.jpg";
    private By nameOfUploadedFileOnPage = By.id("uploaded-files");

    private WebElement getChooseAFileBtn() {
        return driver.findElement(chooseAFileBtn);
    }

    private WebElement getUploadButton() {
        return driver.findElement(uploadBtn);
    }

    //Имя файла на странице
    private String getNameOfUploadedFile() {
        return driver.findElement(nameOfUploadedFileOnPage).getText();
    }

    public FileUploadPage setFile() {
        getChooseAFileBtn().sendKeys(pathToFile);
        return this;
    }

    public FileUploadPage clickUploadBtn() {
        click(getUploadButton());
        return this;
    }

    public void verifyFileNames() {
        log.debug("Path to file   " + pathToFile);
        log.debug("Name of the Uploaded File on the Page:  " + getNameOfUploadedFile());
        Assert.assertTrue(pathToFile.contains(getNameOfUploadedFile()));
    }
}
