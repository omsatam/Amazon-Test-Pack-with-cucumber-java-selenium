package stepDefinition;

import base.TestBase;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class SigninPageDefinition {
    TestBase testBase = new TestBase();
    public SigninPageDefinition(TestBase testBase){
        this.testBase = testBase;
    }

    @Given("User Navigate to Sign In page")
    public void user_navigate_to_sign_in_page() {
        // Write code here that turns the phrase above into concrete actions
        testBase.getTopnav().goToSignIn();
    }
    @Then("Verify Signin Page appears")
    public void verify_signin_page_appears() {
        // Write code here that turns the phrase above into concrete actions
        testBase.getSigninPage().verifySignInPage();
    }

    @When("User Click Continue Button")
    public void user_click_continue_button() {
        // Write code here that turns the phrase above into concrete actions
        testBase.getSigninPage().clickContinueWithoutInput();
    }
    @When("Verify Error message")
    public void verify_error_message() {
        // Write code here that turns the phrase above into concrete actions
        testBase.getSigninPage().verifyErrorWithoutInput();
    }
    @When("User Enters incorrect email address (.+)$")
    public void user_enters_incorrect_email_address_(String EmailAddress) {
        // Write code here that turns the phrase above into concrete actions
        testBase.getSigninPage().enterEmail(EmailAddress);
    }
    @Then("Verify Error Message for Incorrect Email")
    public void verify_error_message_for_incorrect_email() {
        // Write code here that turns the phrase above into concrete actions
        testBase.getSigninPage().verifyIncorrectEmailNumberError();
    }
    @When("User Enters correct email address (.+)$")
    public void user_enters_correct_email_address_(String EmailAddress) {
        // Write code here that turns the phrase above into concrete actions
        testBase.getSigninPage().enterEmail(EmailAddress);
    }
    @Then("Verify User is Navigated to Passwords Page")
    public void verify_user_is_navigated_to_passwords_page() {
        // Write code here that turns the phrase above into concrete actions
        testBase.getSigninPage().verifyPasswordsPage();
    }
    @When("User Enters incorrect Phone Number (.+)$")
    public void user_enters_incorrect_phone_number_(String PhoneNumber) {
        // Write code here that turns the phrase above into concrete actions
        testBase.getSigninPage().enterEmail(PhoneNumber);
    }
    @Then("Verify Error Message for Incorrect Phone Number")
    public void verify_error_message_for_incorrect_phone_number() {
        // Write code here that turns the phrase above into concrete actions
        testBase.getSigninPage().verifyIncorrectEmailNumberError();
    }
    @When("Enters correct Phone Number (.+)$")
    public void enters_correct_phone_number_(String PhoneNumber) {
        // Write code here that turns the phrase above into concrete actions
        testBase.getSigninPage().enterEmail(PhoneNumber);
    }
    @When("User Click Submit Button Error message should appear")
    public void user_click_submit_button_error_message_should_appear() {
        // Write code here that turns the phrase above into concrete actions
        testBase.getSigninPage().submitWithoutPassword();
    }
    @When("^User Enters incorrect OTP (.+) and Verify Error message$")
    public void user_enters_incorrect_otp_and_verify_error_message(String OTP) {
        // Write code here that turns the phrase above into concrete actions
        testBase.getSigninPage().enterOTP(OTP);
        testBase.getSigninPage().verifyErrorIncorrectOTP();
    }
    @When("User Enters incorrect Password (.+)$")
    public void user_enters_incorrect_password_(String Password) {
        // Write code here that turns the phrase above into concrete actions
        testBase.getSigninPage().enterPassword(Password);
    }
    @Then("Verify Error Message for Incorrect Password")
    public void verify_error_message_for_incorrect_password() {
        // Write code here that turns the phrase above into concrete actions
        testBase.getSigninPage().verifyIncorrectEmailNumberError();
    }

    @And("User Sign In With valid Credentials")
    public void user_sign_in_with_valid_credentials() {
        // Write code here that turns the phrase above into concrete actions
        testBase.getSigninPage().signInWithValidCredentials();
    }

}
