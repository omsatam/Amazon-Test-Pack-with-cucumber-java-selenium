package stepDefinition;

import base.PageBase;
import base.TestBase;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Pages.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class SearchDefinition{

    TestBase testBase = new TestBase();
    public SearchDefinition(TestBase testBase){
        this.testBase = testBase;
    }
    @And("Default Search Dropdown Category is {string}")
    public void default_search_dropdown_category_is(String string) {
        testBase.getTopnav().verifyDefaultDropdown(string);
    }
    @When("User Changes Dropdown Category The same should be displayed")
    public void user_changes_dropdown_category_the_same_should_be_displayed() {
        // Write code here that turns the phrase above into concrete actions
        testBase.getTopnav().changeDropdownCategoryandVerify();
    }
    @Then("Check Recommendations are Displaying correctly")
    public void check_recommendations_are_displaying_correctly() {
        // Write code here that turns the phrase above into concrete actions
        testBase.getTopnav().checKRecommendations();
    }
    @When("User Type in Searchbox")
    public void user_type_in_searchbox() {
        // Write code here that turns the phrase above into concrete actions
        testBase.getTopnav().typeInSearchBox();
    }
    @When("User Search for Product")
    public void user_search_for_product() {
        // Write code here that turns the phrase above into concrete actions
        testBase.getTopnav().searchForProduct();
    }
    @When("User Search From Recommended Product")
    public void user_search_from_recommended_product() {
        // Write code here that turns the phrase above into concrete actions
        testBase.getTopnav().searchFromRecommendations();
    }
    @Then("Verify Search Results")
    public void verify_search_results() {
        // Write code here that turns the phrase above into concrete actions
        testBase.getTopnav().verifySearchResults();
    }

}
