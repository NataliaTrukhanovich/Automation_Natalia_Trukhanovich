package pageObjects.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

import java.io.File;

public class FileUploadPage extends BasePage {
    private By chooseAFileBtn = By.id("file-upload");
    private By uploadBtn = By.id("file-submit");
    private String nameOfFile = "D:\\Temp\\Many Happies.jpg";
    private By nameOfUploadedFile = By.id("uploaded-files");

    private WebElement getChooseAFileBtn() {
        return driver.findElement(chooseAFileBtn);
    }

    private WebElement getUploadButton() {
        return driver.findElement(uploadBtn);
    }
private String getNameOfUploadedFile(){
        return driver.findElement(nameOfUploadedFile).getText();
}
    public FileUploadPage setFile() {
        getChooseAFileBtn().sendKeys(nameOfFile);
        ;
        return this;
    }

    public FileUploadPage clickUploadBtn() {
        clickBtn(getUploadButton());
        return this;
    }
    public FileUploadPage verifyFileNames(){
        Assert.assertEquals(getNameOfUploadedFile(),nameOfFile.substring(8));
        return this;
    }

    public void checkDownloadedFile(){
        System.out.println("Method checkDownloadedFile");
        File folder = new File(System.getProperty("D:\\Temp\\"));
        File[] listOfFiles =folder.listFiles();
        System.out.println(listOfFiles.length);
        boolean found = false;
        File f = null;
        for (File listOfFile : listOfFiles){
            if(listOfFile.isFile()) {
                String fileName = listOfFile.getName();
                System.out.println("File " + listOfFile.getName());
                if (fileName.matches("Many Happies.jpg")) {
                    f = new File(fileName);
                    found = true;
                }
            }
        }
        Assert.assertTrue(found, "not found");
        f.deleteOnExit();
    }
}
