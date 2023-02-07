package stepDefinition;

import base.TestBase;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class SearchresultsPageDefinition {
    TestBase testBase = new TestBase();
    public SearchresultsPageDefinition(TestBase testBase){
        this.testBase = testBase;
    }
    @When("User Selects Product From Search Results")
    public void user_selects_product_from_search_results() {
        // Write code here that turns the phrase above into concrete actions
        testBase.getResultPage().selectProductFromResults();
    }
    @Then("Open Product Image and Verify it Opened")
    public void open_product_image_and_verify_it_opened() {
        // Write code here that turns the phrase above into concrete actions
        testBase.getProductPage().openProductImageandVerify();
    }
    @Then("Select Product Images and Verify Results")
    public void select_product_images_and_verify_results() {
        // Write code here that turns the phrase above into concrete actions
        testBase.getProductPage().selectProductImageandVerify();
    }
    @Then("Verify Correct Product Opened")
    public void verify_correct_product_opened() {
        // Write code here that turns the phrase above into concrete actions
        testBase.getProductPage().verifyCorrectProductOpened(testBase.getResultPage().productName);
    }

    @Then("^User Changes to (.+) stars & up and verify results$")
    public void userChangesToGivenStarsStarsUpAndVerifyResults(int stars) {
        testBase.getResultPage().selectGivenStarsVerifyResults(stars);
    }

    @Then("User Changes Filter To {string}")
    public void userChangesFilterTo(String arg0) {
        
    }

    @Then("Verify Default Sort By Feature")
    public void verifyDefaultSortByFeature() {
        testBase.getResultPage().verifyDefaultSortBy();
    }

    @Then("^User Changes Filter To (.+) and Verify Results$")
    public void user_changes_filter_to_and_verify_results(String filterValue) {
        testBase.getResultPage().changeFilterVerifyResults(filterValue);
    }

    @Then("^User Changes Brands (.+) and Verify Results")
    public void userChangesBrandsBrandNamesAndVerifyResults(String brandName) {
        testBase.getResultPage().selectBrandNameVerifyResults(brandName);
    }

    @Then("^User Changes Discount Category to (.+) and Verify Results$")
    public void userChangesDiscountCategoryToDiscountCategoryAndVerifyResults(String DiscountCategory) {
        testBase.getResultPage().changeDiscountCategoryVerifyResults(DiscountCategory);
    }

    @Then("^User Changes to Given Price Range (.+) and verify results$")
    public void userChangesToGivenPriceRangeGivenPriceRangeAndVerifyResults(int priceRange) {
        testBase.getResultPage().changePriceRangeVerifyResults(priceRange);
    }
}
