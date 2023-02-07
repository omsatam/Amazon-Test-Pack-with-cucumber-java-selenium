package stepDefinition;

import base.TestBase;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class SignuppageDefinition {
    TestBase testBase = new TestBase();
    public SignuppageDefinition(TestBase testBase){
        this.testBase = testBase;
    }
    @Given("User Navigate to Sign Up page")
    public void user_navigate_to_sign_up_page() {
        // Write code here that turns the phrase above into concrete actions
        testBase.getTopnav().goToSignUp();
    }
    @Then("Check all Manadotory Fields of SignUp page")
    public void check_all_manadotory_fields_of_sign_up_page() {
        // Write code here that turns the phrase above into concrete actions
        testBase.getSignupPage().checkAllManadotoryFields();
    }
    @When("User Enters Name Field (.+)$")
    public void user_enters_name_field_(String Name) {
        // Write code here that turns the phrase above into concrete actions
        testBase.getSignupPage().enterName(Name);
    }
    @Then("Verify that User Navigated To Next Screen on Signup page")
    public void verify_that_user_navigated_to_next_screen_on_signup_page() {
        // Write code here that turns the phrase above into concrete actions
        testBase.getSignupPage().verifyNextPageSignup();
    }
    @When("^User User Enters Incorrect Phone Number (.+) on Signup page then Error message should displayed")
    public void user_user_enters_incorrect_phone_number_on_signup_page_then_error_message_should_displayed(String PhoneNumber) {
        // Write code here that turns the phrase above into concrete actions
        testBase.getSignupPage().checkForIncorrectNumber(PhoneNumber);
    }
    @Then("User Enters Correct Phone Number (.+)$")
    public void user_enters_correct_phone_number_(String PhoneNumber) {
        // Write code here that turns the phrase above into concrete actions
        testBase.getSignupPage().checkForCorrectNumber(PhoneNumber);
    }
    @When("^User User Enters Incorrect Email Address (.+) on Signup page then Error message should displayed")
    public void user_user_enters_incorrect_email_address_on_signup_page_then_error_message_should_displayed(String EmailAddress) {
        // Write code here that turns the phrase above into concrete actions
        testBase.getSignupPage().checkForIncorrectEmail(EmailAddress);
    }
    @Then("User Enters Correct Email Address (.+)$")
    public void user_enters_correct_email_address_(String EmailAddress) {
        // Write code here that turns the phrase above into concrete actions
        testBase.getSignupPage().checkForCorrectEmail(EmailAddress);
    }
    @When("^User Enters Incorrect Password (.+) on Signup page then Error message should displayed$")
    public void user_enters_incorrect_password_on_signup_page_then_error_message_should_displayed(String Password) {
        // Write code here that turns the phrase above into concrete actions
        testBase.getSignupPage().checkForIncorrectPassword(Password);
    }
    @Then("User Enters Correct Password (.+)$")
    public void user_enters_correct_password_(String Password) {
        // Write code here that turns the phrase above into concrete actions
        testBase.getSignupPage().checkForCorrectPassword(Password);
    }

}
