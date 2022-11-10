package pageObjects.rabota;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

@Log4j
public class HomePage extends BasePage {
    private final By location = By.xpath("//button[@data-qa='mainmenu_areaSwitcher']");
    private final By locationRB = By.xpath("//div[@class='area-switcher-column']//span[@data-qa='area-switcher-title']");
    private final By searchField = By.xpath("//input[@data-qa='search-input']");
    private final By searchButton = By.xpath("//button[@data-qa='search-button']");
    private final By resultText = By.xpath("//h1[@data-qa='vacancies-catalog-header']");
   private final By resultQuantity = By.xpath("//span[@data-qa='vacancies-total-found']//span");

    public HomePage openHomePage() {
        load();
        return this;
    }
    public HomePage setLocation() {
        log.debug("Set location Belarus");
        log.debug("Is location Belarus? ::  " + findElement(location).getText().equals("Беларусь"));
        if (!findElement(location).getText().equals("Беларусь"))
        {
            click(location);
            click(locationRB);
        }
        return this;
    }

    public HomePage enterSearch(String search) {
        enter(searchField, search);
        return this;
    }

    public void clickSearchButton() {
        click(searchButton);
    }

    public void checkSearchName(String searchName) {
        log.debug("Verify searchName");
        Assert.assertTrue(findElement(resultText).getText().contains(searchName));
    }

    public void checkResultsQuantity(int quantity) {
        log.debug("Verify results quantity");
        System.out.println("Get text :: " + findElement(resultQuantity).getText());
        String str = findElement(resultQuantity).getText().substring(2,4);
        Assert.assertTrue(Integer.parseInt(str)>=quantity);
    }
}
