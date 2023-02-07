package stepDefinition;

import base.TestBase;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class ProductPageDefinition {
    TestBase testBase = new TestBase();
    public ProductPageDefinition(TestBase testBase){
        this.testBase = testBase;
    }
    @Then("Verify Product Images Displayed Correctly")
    public void verify_product_images_displayed_correctly() {
        // Write code here that turns the phrase above into concrete actions
        testBase.getProductPage().verifyProductImages();
    }
    @Then("Verify All Product Page Items")
    public void verify_all_product_page_items() {
        // Write code here that turns the phrase above into concrete actions
        testBase.getProductPage().verifyProductPage();
    }

    @When("User Add Product To Cart")
    public void user_add_product_to_cart() {
        // Write code here that turns the phrase above into concrete actions
        testBase.getProductPage().addToCart();
    }
    @Then("Check Cart Quantity")
    public void check_cart_quantity() {
        // Write code here that turns the phrase above into concrete actions
        testBase.getProductPage().checkCartQuantity();
    }
    @Then("Check Cart Quantity and Verify Cart Quantity Increased")
    public void verify_cart_quantity_increased() {
        // Write code here that turns the phrase above into concrete actions
        testBase.getProductPage().verifyCartQuantityIncreased(testBase.getProductPage().cartCount);
    }
    @When("User Adds product to wishlist")
    public void user_adds_product_to_wishlist() {
        testBase.getProductPage().addToWishlist();
    }
    @Then("Verify Wishlist page appears")
    public void verify_wishlist_page_appears() {
        // Write code here that turns the phrase above into concrete actions
        testBase.getProductPage().verifyWishlistPage();
    }
    @Then("Add item to wishlist")
    public void add_item_to_wishlist() {
        // Write code here that turns the phrase above into concrete actions
        testBase.getProductPage().addproductToWishlist();
    }
    @Then("Go to Wishlist")
    public void go_to_wishlist() {
        // Write code here that turns the phrase above into concrete actions
        testBase.getTopnav().goToWishlist();
    }
    @Then("Verify Product Available in Wishlist")
    public void verify_product_available_in_wishlist() {
        // Write code here that turns the phrase above into concrete actions
        testBase.getLandingPage().verifyProductinWishlist(testBase.getResultPage().productName);
    }
    @Then("Delete Created Wishlist")
    public void delete_created_wishlist() {
        // Write code here that turns the phrase above into concrete actions
        testBase.getLandingPage().deleteCreatedWishlist();
    }
    @And("User Begins Checkout")
    public void user_begins_checkout() {
        // Write code here that turns the phrase above into concrete actions
        testBase.getProductPage().beginCheckout();
    }
    @Then("Verify that Checkout page appears")
    public void verify_that_checkout_page_appears() {
        // Write code here that turns the phrase above into concrete actions
        testBase.getLandingPage().verifyCheckoutPage();
    }
    @When("User clicks on Buy product now")
    public void user_clicks_on_buy_product_now() {
        // Write code here that turns the phrase above into concrete actions
        testBase.getProductPage().buyProductNow();
    }


}
