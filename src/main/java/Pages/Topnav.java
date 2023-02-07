package Pages;

import base.PageBase;
import base.TestBase;
import io.cucumber.java.eo.Se;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Topnav extends PageBase {
    private static final Logger logger = LogManager.getLogger(Topnav.class);
    private final By dropdownItems = By.xpath("//*[@id='searchDropdownBox']/option");
    private final By defaultDropdownSelector = By.id("nav-search-label-id");
    private final By signInSelector = By.id("nav-link-accountList-nav-line-1");
    private final By SignInLink =  By.id("nav-link-accountList");
    private final By createAccountButton =  By.id("createAccountSubmit");
    private final By autocompleteSelector = By.cssSelector("#nav-flyout-searchAjax > div.autocomplete-results-container");
    private final By SearchInputSelector = By.id("twotabsearchtextbox");
    private final By dropdown =  By.id("nav-search-dropdown-card");
    private final By resultsSelector = By.cssSelector("h1.a-size-base");
    private final By searchButton = By.id("nav-search-submit-button");
    private final By recommendationsList = By.xpath("//*[@id='nav-flyout-searchAjax']/div[2]/div");
    private final By recommendedItem =  By.xpath("//*[@id='nav-flyout-searchAjax']/div[2]/div[4]/div/div");
    protected String SearchItem = getProerties().getProperty("searchItem");
    private final By YourAccountLink =  By.cssSelector("#nav-al-your-account > a:nth-child(2)");
    private final By YourOrdersLink =  By.cssSelector("#nav-al-your-account > a:nth-child(3)");
    private final By ReturnsOrdersSelector = By.id("nav-orders");
    private final By YourWishlistLink =  By.cssSelector("#nav-al-your-account > a:nth-child(4)");
    private final By YourRecommendationsLink =  By.cssSelector("#nav-al-your-account > a:nth-child(5)");
    private final By YourPrimeMembershipLink =  By.cssSelector("#nav-al-your-account > a:nth-child(6)");
    private final By YourPrimeVideoLink =  By.cssSelector("#nav-al-your-account > a:nth-child(7)");
    private final By YourSubscribeLink =  By.cssSelector("#nav-al-your-account > a:nth-child(8)");
    private final By MembershpsSubscriptions =  By.cssSelector("#nav-al-your-account > a:nth-child(9)");
    private final By YourAmazonBuisnessLink =  By.cssSelector("#nav-al-your-account > a:nth-child(10)");
    private final By YourSellerAccountLink =  By.cssSelector("#nav-al-your-account > a:nth-child(11)");
    private final By ManageYourContentLink =  By.cssSelector("#nav-al-your-account > a:nth-child(12)");
    private final By SwitchAccountsLink =  By.id("nav-item-switch-account");
    public Topnav(TestBase testBase) throws IOException {
        super(testBase);
    }
//    String defaultDropdownText = "All";
    public void verifyDefaultDropdown(String text){
//        clickElement(defaultDropdownSelector);
        isTextVisible(defaultDropdownSelector,text);
    }
    public void changeDropdownCategoryandVerify(){
        List<WebElement> dropdownCategories = getElements(dropdownItems);
        for (WebElement dropdownItem:
             dropdownCategories) {
            waitUntilElementVisible(dropdown);
            clickElement(dropdown);
            String text = dropdownItem.getText();
            if (text != "All Categories"){
                waitUntilElementDisplayed(dropdownItem);
                dropdownItem.click();
                text.toLowerCase().contains(getElementText(defaultDropdownSelector));
                logger.info(text + " is equals to "+ getElementText(defaultDropdownSelector));
            }
        }
    }
    public void goToSignIn(){
        clickElement(signInSelector);
    }
    public void goToSignUp(){
        clickElement(SignInLink);
        waitUntilElementVisible(createAccountButton);
        clickElement(createAccountButton);
    }
    public void typeInSearchBox(){
        setElement(SearchInputSelector,SearchItem);
    }
    public void checKRecommendations(){
        waitUntilElementVisible(autocompleteSelector);
        isElementVisible(autocompleteSelector);
        List<WebElement> recommendations = getElements(recommendationsList);
        for (WebElement recommendation:
             recommendations) {
            String text = recommendation.getText();
            text.toLowerCase().contains(SearchItem.toLowerCase());
            logger.info(text + " contains "+ SearchItem);
        }
    }
    public void searchForProduct(){
        clearElement(SearchInputSelector);
        setElement(SearchInputSelector,SearchItem);
        clickElement(searchButton);
    }
    public void searchFromRecommendations(){
        clickElement(recommendedItem);
    }
    public void verifySearchResults(){
        isElementVisible(resultsSelector);
    }
    public void goToWishlist(){
        waitUntilElementVisible(signInSelector);
        mouseOverToElement(signInSelector);
        clickElement(YourWishlistLink);
    }
    public void openReturnsOrders(){
        clickElement(ReturnsOrdersSelector);
    }

    public void openYourAccount() {
        mouseOverToElement(signInSelector);
        waitUntilElementVisible(YourAccountLink);
        clickElement(YourAccountLink);
    }

    public void openYourOrders() {
        mouseOverToElement(signInSelector);
        waitUntilElementVisible(YourOrdersLink);
        clickElement(YourOrdersLink);
    }

    public void openYourRecommendations() {
        mouseOverToElement(signInSelector);
        waitUntilElementVisible(YourRecommendationsLink);
        clickElement(YourRecommendationsLink);
    }

    public void openYourPrimeMembership() {
        mouseOverToElement(signInSelector);
        waitUntilElementVisible(YourPrimeMembershipLink);
        clickElement(YourPrimeMembershipLink);
    }

    public void openYourPrimeVideo() {
        mouseOverToElement(signInSelector);
        waitUntilElementVisible(YourPrimeVideoLink);
        clickElement(YourPrimeVideoLink);
    }

    public void openYourSubscribeSaveItems() {
        mouseOverToElement(signInSelector);
        waitUntilElementVisible(YourSubscribeLink);
        clickElement(YourSubscribeLink);
    }

    public void openYourAmazonBusinessAccount() {
        mouseOverToElement(signInSelector);
        waitUntilElementVisible(YourAmazonBuisnessLink);
        clickElement(YourAmazonBuisnessLink);
    }

    public void openYourSellerAccount() {
        mouseOverToElement(signInSelector);
        waitUntilElementVisible(YourSellerAccountLink);
        clickElement(YourSellerAccountLink);
    }

    public void openManageYourContentDevices() {
        mouseOverToElement(signInSelector);
        waitUntilElementVisible(ManageYourContentLink);
        clickElement(ManageYourContentLink);
    }

    public void openMembershipsSubscriptions() {
        mouseOverToElement(signInSelector);
        waitUntilElementVisible(MembershpsSubscriptions);
        clickElement(MembershpsSubscriptions);
    }

    public void openSwitchAccounts() {
        mouseOverToElement(signInSelector);
        waitUntilElementVisible(SwitchAccountsLink);
        clickElement(SwitchAccountsLink);
    }

}
