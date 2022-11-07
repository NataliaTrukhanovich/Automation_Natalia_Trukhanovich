package pageObjects.rabota;

import org.openqa.selenium.By;
import pageObjects.baseObjects.BasePage;

public class HomePage extends BasePage {
    private final By searchField = By.xpath("//input[@data-qa='search-input']");
    private final By searchButton = By.xpath("//button[@data-qa='search-button']");
    private final By result = By.xpath("//h1[@data-qa='bloko-header-3']");

    public HomePage(){}

    public HomePage openHomePage() {
        load();
        return this;
    }

    public HomePage enterSearch(String search) {
        enter(searchField, search);
        return this;
    }

    public HomePage clickSearchButton() {
        click(searchButton);
        return this;
    }

    public HomePage checkSearchName(String searchName) {
        System.out.println(findElement(result).getText());
        return this;
    }

    public HomePage checkResultsQuantity(String searchName) {
        System.out.println(findElement(result).getText());
        return this;
    }
}
