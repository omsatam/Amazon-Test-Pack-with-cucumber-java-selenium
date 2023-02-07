package Pages;

import base.PageBase;
import base.TestBase;
import org.openqa.selenium.By;

public class SignupPage extends PageBase {
    private final By continueButton =  By.id("continue");
    private final By blankCustomerNameAlert =  By.cssSelector("#auth-customerName-missing-alert > div > div");
    private final By blankMobileNumberAlert =  By.cssSelector("#auth-phoneNumber-missing-alert > div > div");
    private final By blankPasswordAlert =  By.cssSelector("#auth-password-missing-alert > div > div");
    private final By invalidCustomeremailAlert =  By.cssSelector("#auth-email-invalid-email-alert > div > div");
    private final By invalidMobileNumberAlert =  By.cssSelector("#auth-phoneNumber-invalid-phone-alert > div > div");
    private final By invalidPasswordAlert =  By.cssSelector("#auth-password-invalid-password-alert > div > div");
    private final By nameInputSelector =  By.id("ap_customer_name");
    private final By emailInputSelector =  By.id("ap_email");
    private final By numberInputSelector =  By.id("ap_phone_number");
    private final By passwordInputSelector =  By.id("ap_password");
    private final By puzzlePageSelector =  By.id("a-page");
    private final By solvePuzzle =  By.xpath("//*[@id='a-page']/div/div/div/div");
    protected String nameInput = new String("Hello123");
    protected String wrongNumberInputSignup = new String("rt");
    protected String correctNumberInput =  new String("879763546");
    protected String wrongEmailInputSignup = new String("87878");
    protected String correctEmailInputSignup =  new String("testing45623@gmail.com");
    protected String wrongPasswordInput = new String("436");
    protected String correctPasswordInput = new String("678986");
    public SignupPage(TestBase testBase) {
        super(testBase);
    }
    public void enterName(String Name){
        setElement(nameInputSelector, Name);
        setElement(numberInputSelector, correctNumberInput);
        setElement(passwordInputSelector, correctPasswordInput);
        clickElement(continueButton);
    }
    public void checkAllManadotoryFields(){
        clickElement(continueButton);
        isElementVisible(blankCustomerNameAlert);
        isElementVisible(blankMobileNumberAlert);
        isElementVisible(blankPasswordAlert);
    }
    public void checkForCorrectEmail(String Email){
        setElement(nameInputSelector,nameInput);
        setElement(numberInputSelector,correctNumberInput);
        setElement(emailInputSelector,Email);
        setElement(passwordInputSelector,correctPasswordInput);
        clickElement(continueButton);
    }
    public void checkForIncorrectEmail(String Email){
        setElement(nameInputSelector,nameInput);
        setElement(numberInputSelector,correctNumberInput);
        setElement(emailInputSelector,Email);
        setElement(passwordInputSelector,correctPasswordInput);
        clickElement(continueButton);
        isElementVisible(invalidCustomeremailAlert);
    }
    public void checkForCorrectNumber(String Number){
        setElement(nameInputSelector,nameInput);
        setElement(numberInputSelector,Number);
        setElement(passwordInputSelector,correctPasswordInput);
        clickElement(continueButton);
    }
    public void checkForIncorrectNumber(String Number){
        setElement(nameInputSelector,nameInput);
        setElement(numberInputSelector,Number);
        setElement(passwordInputSelector,correctPasswordInput);
        clickElement(continueButton);
        isElementVisible(invalidMobileNumberAlert);
    }
    public void checkForCorrectPassword(String Password){
        setElement(nameInputSelector,nameInput);
        setElement(numberInputSelector,correctNumberInput);
        setElement(passwordInputSelector,Password);
        clickElement(continueButton);
    }
    public void checkForIncorrectPassword(String Password){
        setElement(nameInputSelector,nameInput);
        setElement(numberInputSelector,correctNumberInput);
        setElement(passwordInputSelector,Password);
        clickElement(continueButton);
        isElementVisible(invalidPasswordAlert);
    }
    public void verifyNextPageSignup(){
        waitUntilElementVisible(puzzlePageSelector);
        waitUntilElementVisible(solvePuzzle);
        isElementVisible(puzzlePageSelector);
        isElementVisible(solvePuzzle);
    }
}
