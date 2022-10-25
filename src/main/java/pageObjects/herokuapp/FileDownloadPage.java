package pageObjects.herokuapp;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

import java.io.File;
import java.util.Arrays;
@Log4j
public class FileDownloadPage extends BasePage {

    public FileDownloadPage clickFileLinkForDownloading(String fileName) {
        click(driver.findElement(By.partialLinkText(fileName)));
        return this;
    }

    public void checkDownloadedFile(String fileName) {
        File folder = new File(System.getProperty("user.home") + "\\Downloads\\");
        log.debug(folder);
        boolean status = false;

        for (int counter = 0; counter <= 60; counter++) {
            File[] listOfFiles = folder.listFiles();
            if (Arrays.stream(listOfFiles)
                    .filter(data -> data.getAbsoluteFile().getName().equals(fileName)).count() != 0) {
                status = true;
                break;
            } else {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        Assert.assertTrue(status, "File not found");
    }
}