package Pages;

import base.PageBase;
import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends PageBase {
    private final By sellPageSelector =  By.xpath("//*[@id='a-page']/div[2]/div/div/div/div/div/div[1]/div/div/div/div/div");
    private final By bestSellersPageSelector =  By.id("zg_col1");
    private final By todaysDealsPageSelector =  By.id("slot-2");
    private final By returnsOrdersPageSelector = By.cssSelector("#a-page > section > div");
    private final By mobilesPageSelector =  By.xpath("//*[@id='s-refinements']/div[1]/ul/li[2]/span/span");
    private final By customerServicePageSelector =  By.cssSelector("#a-page > div:nth-child(30) > div.a-section.a-spacing-extra-large.a-spacing-top-extra-large.ss-landing-container > h1");
    private final By electronicsPageSelector =  By.cssSelector("div.bxc-grid__text > h1");
    private final By homeKitchenPageSelector =  By.cssSelector("#a-page > div.a-container > div:nth-child(1) > div > div > div > div > h1");
    private final By fashionPageSelector =  By.id("sobe_d_b_1");
    private final By MiniTVText = By.cssSelector("div>div:nth-child(2)>div>h2");
    private final By MenuSelector = By.id("nav-hamburger-menu");
    private final By Menu = By.id("hmenu-content");
    private final By AmazonFreshBanner = By.cssSelector("div#desktop-grid-5>div.fluid-quad-image-label:nth-child(1)");
    private final By AmazonFreshPageSelector = By.cssSelector("div#desktop-grid-5>div.fluid-quad-image-label >div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > a");
    private final By AmazonFreshPage = By.xpath("//*[@id='nav-subnav']/a[1]/span/img");
    private final By wishListProductName = By.cssSelector("h2.a-size-base");
    private final By wishListLocator = By.id("overflow-menu-popover-trigger");
    private final By deleteWishListSelector = By.xpath("//*[@id='list-settings-container']/span/span/span");
    private final By confirmDeleteWishListSelector = By.id("list-delete-confirm");
    private final By editWishListSelector = By.id("editYourList");
    private final By addressInfo =  By.cssSelector("#a-page > div.a-container.page-container > div");
    private final By yourAccountPageSelector = By.xpath("//*[@id='a-page']/div[2]/div/div[1]/h1");
    private final By yourWishListPage = By.id("wishlist-page");
    private final By yourRecommendationsPage = By.id("gridItemRoot");
    private final By yourPrimeVideoPage = By.id("pv-nav-logo");
    private final By yourAmazonBuisnessAccountPage = By.cssSelector("div.bxw-content-grid > div.bxc-grid__container");
    private final By returnsOrdersPage = By.cssSelector("#a-page > section > div");
    private final By yourPrimeMemberShipPage = By.xpath("//*[@id='a-page']/div[2]/div[2]/div[2]");
    private final By yourSubscribeAndSavePage = By.id("a-autoid-0-announce");
    private final By membershipsSubscriptionsPage = By.id("swa-subsmgr-container");
    private final By manageYourContentPage = By.xpath("//*[@id='root']/div/div/div[1]/div[1]/h1");
    private final By switchAccountsPageSelector = By.id("ap-account-switcher-container");
    public LandingPage(TestBase testBase) {
        super(testBase);
    }

    public void goToPage(String pageName){
//        clickElementByExactText("Best Sellers");
        if(pageName.equalsIgnoreCase( "Sell")){
            clickElementByExactText("Sell");
        } else if(pageName.equalsIgnoreCase("Best Sellers")) {
            clickElementByExactText("Best Sellers");
        }else if(pageName.equalsIgnoreCase( "Mobiles")) {
            clickElementByExactText("Mobiles");
        }else if(pageName.equalsIgnoreCase("Today's Deals")) {
            clickElementByExactText("Today's Deals");
        }else if(pageName.equalsIgnoreCase("Customer Service")) {
            clickElementByText("Customer Service");
        }else if(pageName.equalsIgnoreCase("Electronics")) {
            clickElementByExactText("Electronics");
        }else if(pageName.equalsIgnoreCase("Home & Kitchen")) {
            clickElementByExactText("Home & Kitchen");
        }else if(pageName.equalsIgnoreCase("Fashion")) {
            clickElementByExactText("Fashion");
        }
    }
    public void verifyPageOpened(String pageName){
        if(pageName.equalsIgnoreCase("Sell")){
            waitUntilElementVisible(sellPageSelector);
            isElementVisible(sellPageSelector);
        } else if(pageName.equalsIgnoreCase("Best Sellers")) {
            waitUntilElementVisible(bestSellersPageSelector);
            isElementVisible(bestSellersPageSelector);
        }else if(pageName.equalsIgnoreCase("Mobiles")) {
            waitUntilElementVisible(mobilesPageSelector);
            isElementVisible(mobilesPageSelector);
        }else if(pageName.equalsIgnoreCase("Today's Deals")) {
            waitUntilElementVisible(todaysDealsPageSelector);
            isElementVisible(todaysDealsPageSelector);
        }else if(pageName == "Customer Service") {
            waitUntilElementVisible(customerServicePageSelector);
            isElementVisible(customerServicePageSelector);
        }else if(pageName.equalsIgnoreCase("Electronics")) {
            waitUntilElementVisible(electronicsPageSelector);
            isElementVisible(electronicsPageSelector);
        }else if(pageName.equalsIgnoreCase("Home & Kitchen")) {
            waitUntilElementVisible(homeKitchenPageSelector);
            isElementVisible(homeKitchenPageSelector);
        }else if(pageName.equalsIgnoreCase( "Fashion")) {
            waitUntilElementVisible(fashionPageSelector);
            isElementVisible(fashionPageSelector);
        }
    }
    public void openMenu(){
        clickElement(MenuSelector);
    }
    public void checkMenuOpened(){
        waitUntilElementVisible(Menu);
        isElementVisible(Menu);
    }
    public void openMiniTv(){
        clickElementByText("Amazon miniTV");
    }
    public void checkMiniTvOpened() {
        waitUntilElementVisible(MiniTVText);
        isTextVisible(MiniTVText, "Trending Top 10 on miniTV");
    }
    public void openAmazonFreshPage(){
        scrollToElement(AmazonFreshBanner);
        waitUntilElementVisible(AmazonFreshPageSelector);
        clickElementbyJavascript(AmazonFreshPageSelector);
    }
    public void checkAmazonFreshPageOpened(){
        waitUntilElementVisible(AmazonFreshPage);
        isElementVisible(AmazonFreshPage);
    }
    public void verifyProductinWishlist(String productName){
       getElementText(wishListProductName).contains(productName);
    }
    public void deleteCreatedWishlist(){
        clickElement(wishListLocator);
        waitUntilElementVisible(editWishListSelector);
        clickElement(editWishListSelector);
        waitUntilElementVisible(deleteWishListSelector);
        clickElement(deleteWishListSelector);
        waitUntilElementVisible(confirmDeleteWishListSelector);
        clickElementbyJavascript(confirmDeleteWishListSelector);
        waitUntilElementVisible(wishListLocator);
        isElementVisible(yourWishListPage);
    }
    public void verifyCheckoutPage(){
       waitUntilElementVisible(addressInfo);
       isElementVisible(addressInfo);
    }
    public void verifyReturnsOrdersPageDisplayed(){
        waitUntilElementVisible(returnsOrdersPageSelector);
        isElementVisible(returnsOrdersPageSelector);
    }

    public void verifyYourAccountPage() {
        waitUntilElementVisible(yourAccountPageSelector);
        isElementVisible(yourAccountPageSelector);
    }

    public void verifyWishListPage() {
        waitUntilElementVisible(yourWishListPage);
        isElementVisible(yourWishListPage);
    }

    public void verifyYourRecommendationsPage() {
        waitUntilElementVisible(yourRecommendationsPage);
        isElementVisible(yourRecommendationsPage);
    }

    public void verifyYourPrimeVideoPage() {
        waitUntilElementVisible(yourPrimeVideoPage);
        isElementVisible(yourPrimeVideoPage);
    }

    public void verifyYourAmazonBusinessAccountPage() {
        waitUntilElementVisible(yourAmazonBuisnessAccountPage);
        isElementVisible(yourAmazonBuisnessAccountPage);
    }

    public void verifyPrimeMembershipPage() {
        waitUntilElementVisible(yourPrimeMemberShipPage);
        isElementVisible(yourPrimeMemberShipPage);
    }

    public void verifyYourSubscribeSavePage() {
        waitUntilElementVisible(yourSubscribeAndSavePage);
        isElementVisible(yourSubscribeAndSavePage);
    }

    public void verifyMembershipsSubscriptionsPage() {
        waitUntilElementVisible(membershipsSubscriptionsPage);
        isElementVisible(membershipsSubscriptionsPage);
    }

    public void verifyManageYourContentDevicesPage() {
        waitUntilElementVisible(manageYourContentPage);
        isElementVisible(manageYourContentPage);
    }

    public void VerifySwitchAccountsPage() {
        waitUntilElementVisible(switchAccountsPageSelector);
        isElementVisible(switchAccountsPageSelector);
    }
}
