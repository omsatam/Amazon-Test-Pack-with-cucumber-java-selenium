package Pages;

import base.PageBase;
import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Properties;

public class SigninPage extends PageBase {
    private final By emailInputSelector = By.id("ap_email");
    private final By continueButon = By.id("continue");
    private final By authorizationError = By.id("auth-error-message-box");
    private final By passwordInputSelector = By.id("ap_password");
    private final By submitButon = By.id("signInSubmit");
    private final By noEmailAlert = By.id("auth-email-missing-alert");
    private final By incorrectOTPAlert = By.cssSelector("#verification-code-form > div.a-row.a-spacing-micro > div > div > div > div");
    private final By noPasswordAlert = By.id("auth-password-missing-alert");
    private final By getOTPButon = By.id("auth-login-via-otp-btn");
    private final By OTPSelector = By.id("cvf-input-code");
    private final By submitOTPButton = By.id("cvf-submit-otp-button");
    public SigninPage(TestBase testBase) throws IOException {
        super(testBase);
    }
    protected String userNumber =  getProerties().getProperty("UserMobileNumber");
    protected String userPassword = getProerties().getProperty("UserPassword");
    public String UserName = getProerties().getProperty("username");
    public void verifySignInPage(){
        waitUntilElementVisible(emailInputSelector);
        isElementVisible(emailInputSelector);
    }
    public void enterEmail(String Email){
        setElement(emailInputSelector, Email);
        clickElement(continueButon);
    }
    public void verifyIncorrectEmailNumberError(){
        isElementVisible(authorizationError);
    }
    public void enterPassword(String Password){
        setElement(passwordInputSelector, Password);
        clickElement(submitButon);
    }
    public void clickContinueWithoutInput(){
        clickElement(continueButon);
    }
    public void verifyErrorWithoutInput(){
        clickElement(continueButon);
        isElementVisible(noEmailAlert);
    }
    public void verifyPasswordsPage(){
        isElementVisible(passwordInputSelector);
    }
    public void submitWithoutPassword(){
        clickElement(submitButon);
        isElementVisible(noPasswordAlert);
    }
    public void enterOTP(String OTP){
        clickElement(getOTPButon);
        setElement(OTPSelector,OTP);
        clickElement(submitOTPButton);
    }
    public void verifyErrorIncorrectOTP(){
        isElementVisible(incorrectOTPAlert);
    }
    public void signInWithValidCredentials(){
        setElement(emailInputSelector, userNumber);
        clickElement(continueButon);
        waitUntilElementVisible(passwordInputSelector);
        setElement(passwordInputSelector,userPassword);
        clickElement(submitButon);
    }
}
