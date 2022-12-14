package Lecture8;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.herokuapp.*;

import static pageObjects.herokuapp.NavigationItems.*;

public class Lecture8_2 extends BaseTest {
    @BeforeMethod
    public void precondition() {
        new NavigationPage()
                .open();
    }

    @Test(enabled = false)
    public void dynamicLoading_Test() {
        new NavigationPage()
                .navigateTo(DYNAMIC_LOADING);

        new DynamicLoadingPage()
                .clickOnExample("Example 1")
                .clickStart()
                .pageIsLoaded();
    }

    @Test(enabled = false)
    public void scrollPage_Test() {
        new NavigationPage()
                .navigateTo(INFINITE_SCROLL);
        new InfiniteScrollPage().infiniteScroll(10);
    }

    @Test(enabled = false)
    public void contextMenu_Test() {
        new NavigationPage()
                .navigateTo(CONTEXT_MENU);
        new ContextMenuPage().clickContext().verifyAlert("You selected a context menu");
    }

    @Test(enabled = false)
    public void FrameTest() {
        new NavigationPage()
                .navigateTo(FRAMES);
        new FramesPage()
                .clickFrameLink("iFrame")
                .switchToFrame()
                .enterText("HELLO WORLD!")
                .unSwitchFrame()
                .clickBoldTxt();
    }

    @Test(enabled = false)
    public void dynamicControlsTest() {
        new NavigationPage()
                .navigateTo(DYNAMIC_CONTROLS);
        DynamicControlsPage dynamicControlsPage = new DynamicControlsPage();
        dynamicControlsPage
                .clickCheckbox()
                .clickRemove();
        Assert.assertEquals(dynamicControlsPage.messageTxt(), "It's gone!");
        dynamicControlsPage
                .isExistCheckbox()
                .isDisableInput()
                .clickEnableBtn()
                .isEnableInput();
    }

    @Test
    public void FileUploadTest() {
        new NavigationPage()
                .navigateTo(FILE_UPLOAD);
        new FileUploadPage()
                .setFile()
                .clickUploadBtn()
                .verifyFileNames();
    }

    @Test
    public void FileDownloadTest() {
        new NavigationPage()
                .navigateTo(FILE_DOWNLOAD);
        new FileDownloadPage()
                .clickFileLinkForDownloading("some-file.txt")
                .checkDownloadedFile("some-file.txt");
    }
}
