package cucumberSteps.rabota;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j;
import pageObjects.baseObjects.BaseTest;
import pageObjects.rabota.HomePage;

@Log4j
public class SearchSteps extends BaseTest {

    @Given("open home page Rabota by")
    public void openHomePageRabota() {
        log.debug("@Given annotation works");
        get(HomePage.class).openHomePage().setLocation();
    }

    @When("i input search field {string}")
    public void inputSearchField(String searchName) {
        log.debug("@When annotation works");
        log.debug("SearchName :: " + searchName);
        get(HomePage.class).enterSearch(searchName).clickSearchButton();
    }

    @Then("i check search Name {string}")
    public void checkSearchName(String searchName) {
        log.debug("@Then annotation works");
        get(HomePage.class).checkSearchName(searchName);
    }

    @And("i check results quantity {int}")
    public void checkResultsQuantity(int quantity){
        log.debug("@And annotation works");
        get(HomePage.class).checkResultsQuantity(quantity);
    }
}
