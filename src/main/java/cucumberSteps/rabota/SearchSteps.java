package cucumberSteps.rabota;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.baseObjects.BaseTest;
import pageObjects.rabota.HomePage;

public class SearchSteps extends BaseTest {

@Given("open home page Rabota by")
    public void openHomePageRabota(){
    System.out.println("Given annotation works");
    get(HomePage.class).openHomePage();
}
@When("i input search field {string}")
public void inputSearchField(String searchName){
    get(HomePage.class).enterSearch(searchName).clickSearchButton();
}

@Then("i check search Name {string}")
    public void checkSearchName(String searchName){
    get(HomePage.class).checkResultsQuantity(searchName);
}
}
