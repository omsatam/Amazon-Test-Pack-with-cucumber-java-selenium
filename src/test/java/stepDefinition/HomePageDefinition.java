package stepDefinition;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import base.TestBase;
import Pages.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Objects;


public class HomePageDefinition{
TestBase testBase = new TestBase();
public HomePageDefinition(TestBase testBase){
    this.testBase = testBase;
}
//
//    public HomePageDefinition(WebDriver driver) {
//        super(driver);
//    }
//    HomePage homePage = new HomePage(driver);
    @AfterStep
    public void takeScreenshot(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
    //            System.out.println("taking screenshot");
            File screenshot= ((TakesScreenshot)testBase.getDriver()).getScreenshotAs(OutputType.FILE);
            scenario.attach(FileUtils.readFileToByteArray(screenshot),"image/png","image");
        }
    }
    @Given("User is on Amazon Landing Page")
    public void user_is_on_amazon_landing_page() throws IOException {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        testBase.initializePageObjects(testBase);
        testBase.getHomePage().goToApplication();
    }
    @Given("User Close Browser")
    public void user_close_browser() {
        // Write code here that turns the phrase above into concrete actions
        testBase.getHomePage().closeBrowser();
    }

    @Given("Verify Default language is {string}")
    public void verify_default_language_is(String string) {
        // Write code here that turns the phrase above into concrete actions
        testBase.getHomePage().verifyDefaultLangusge(string);
    }
    @When("User Changes Default Language to {string}")
    public void user_changes_default_language_to(String string) {
        // Write code here that turns the phrase above into concrete actions
        testBase.getHomePage().changeDefaultLanguageTo(string);
    }
    @Then("Verify Language Changed to {string}")
    public void verify_language_changed_to(String string) {
        // Write code here that turns the phrase above into concrete actions
        testBase.getHomePage().verifytChangedLanguage(string);
    }

    @When("User Opens Menu")
    public void user_opens_menu() {
        // Write code here that turns the phrase above into concrete actions
        testBase.getLandingPage().openMenu();
    }
    @Then("Check Menu Opened Successfully")
    public void check_menu_opened_successfully() {
        // Write code here that turns the phrase above into concrete actions
        testBase.getLandingPage().checkMenuOpened();
    }
    @When("User Opens {string} Page")
    public void user_opens_page(String string) {
        // Write code here that turns the phrase above into concrete actions
        testBase.getLandingPage().goToPage(string);
    }
    @Then("Check {string} Page Opened Successfully")
    public void check_page_opened_successfully(String string) {
        // Write code here that turns the phrase above into concrete actions
        testBase.getLandingPage().verifyPageOpened(string);
    }
    @When("Opens Mini TV")
    public void opens_mini_tv() {
        // Write code here that turns the phrase above into concrete actions
        testBase.getLandingPage().openMiniTv();
    }
    @Then("Check Mini TV opened")
    public void check_mini_tv_opened() {
        // Write code here that turns the phrase above into concrete actions
        testBase.getLandingPage().checkMiniTvOpened();
    }

    @When("User Opens Amazon Fresh Page")
    public void user_opens_amazon_fresh_page() {
        // Write code here that turns the phrase above into concrete actions
        testBase.getLandingPage().openAmazonFreshPage();
    }
    @Then("Check Amazon Fresh Page opened")
    public void check_amazon_fresh_page_opened() {
        // Write code here that turns the phrase above into concrete actions
        testBase.getLandingPage().checkAmazonFreshPageOpened();
    }
    @Then("Verify Username Displayed")
    public void verify_username_displayed() {
        // Write code here that turns the phrase above into concrete actions
        testBase.getHomePage().verifyUserNameforAuthorisedUser(testBase.getSigninPage().UserName);
    }

    @Then("Verify Returns & Orders is Displayed")
    public void verify_returns_orders_is_displayed() {
        // Write code here that turns the phrase above into concrete actions
        testBase.getTopnav().openReturnsOrders();
        testBase.getLandingPage().verifyReturnsOrdersPageDisplayed();
    }

    @Then("Verify Every Item of Your Account Section for Authorised User")
    public void verify_every_item_of_your_account_section_for_authorised_user() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        testBase.getTopnav().openYourAccount();
        testBase.getLandingPage().verifyYourAccountPage();
        testBase.getTopnav().openYourOrders();
        testBase.getLandingPage().verifyReturnsOrdersPageDisplayed();
        testBase.getTopnav().goToWishlist();
        testBase.getLandingPage().verifyWishListPage();
        testBase.getTopnav().openYourRecommendations();
        testBase.getLandingPage().verifyYourRecommendationsPage();
        testBase.getTopnav().openYourPrimeMembership();
        testBase.getLandingPage().verifyPrimeMembershipPage();
        testBase.getTopnav().openYourPrimeVideo();
        testBase.getLandingPage().verifyYourPrimeVideoPage();
        testBase.getHomePage().goToApplication();
        testBase.getTopnav().openYourSubscribeSaveItems();
        testBase.getLandingPage().verifyYourSubscribeSavePage();
        testBase.getTopnav().openMembershipsSubscriptions();
        testBase.getLandingPage().verifyMembershipsSubscriptionsPage();
        testBase.getTopnav().openYourAmazonBusinessAccount();
        testBase.getLandingPage().verifyYourAmazonBusinessAccountPage();
        testBase.getTopnav().openYourSellerAccount();
        testBase.getLandingPage().verifyPageOpened("Sell");
        testBase.getTopnav().openManageYourContentDevices();
        testBase.getLandingPage().verifyManageYourContentDevicesPage();
        testBase.getTopnav().openSwitchAccounts();
        testBase.getLandingPage().VerifySwitchAccountsPage();
    }
    @Then("Verify Username is not Displayed")
    public void verify_username_is_not_displayed() {
        // Write code here that turns the phrase above into concrete actions
        testBase.getHomePage().verifyUserNameforUnauthorisedUser();
    }
    @Then("Verify Returns & Orders is not Displayed")
    public void verify_returns_orders_is_not_displayed() {
        // Write code here that turns the phrase above into concrete actions
        testBase.getTopnav().openReturnsOrders();
        testBase.getSigninPage().verifySignInPage();
    }
    @Then("Verify Every Item of Your Account Section for Unauthorised User")
    public void verify_every_item_of_your_account_section_for_unauthorised_user() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        testBase.getTopnav().openYourAccount();
        testBase.getLandingPage().verifyYourAccountPage();
        testBase.getTopnav().openYourOrders();
        testBase.getSigninPage().verifySignInPage();
        testBase.getHomePage().goToApplication();
        testBase.getTopnav().goToWishlist();
        testBase.getLandingPage().verifyWishListPage();
        testBase.getTopnav().openYourRecommendations();
        testBase.getLandingPage().verifyYourRecommendationsPage();
        testBase.getTopnav().openYourPrimeMembership();
        testBase.getSigninPage().verifySignInPage();
        testBase.getHomePage().goToApplication();
        testBase.getTopnav().openYourPrimeVideo();
        testBase.getLandingPage().verifyYourPrimeVideoPage();
        testBase.getHomePage().goToApplication();
        testBase.getTopnav().openYourSubscribeSaveItems();
        testBase.getSigninPage().verifySignInPage();
        testBase.getHomePage().goToApplication();
        testBase.getTopnav().openMembershipsSubscriptions();
        testBase.getSigninPage().verifySignInPage();
        testBase.getHomePage().goToApplication();
        testBase.getTopnav().openYourAmazonBusinessAccount();
        testBase.getLandingPage().verifyYourAmazonBusinessAccountPage();
        testBase.getTopnav().openYourSellerAccount();
        testBase.getLandingPage().verifyPageOpened("Sell");
        testBase.getTopnav().openManageYourContentDevices();
        testBase.getSigninPage().verifySignInPage();
    }
}
