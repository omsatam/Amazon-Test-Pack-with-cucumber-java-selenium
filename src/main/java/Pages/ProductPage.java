package Pages;

import base.PageBase;
import base.TestBase;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
public class ProductPage extends PageBase {
    private static final Logger logger = LogManager.getLogger(ProductPage.class);
    private final By ProductNameSelector = By.id("titleSection");
    private final By defaultImage = By.id("imgTagWrapperId");
    private final By thumbnailImagesSelector = By.cssSelector("#altImages > ul > li.imageThumbnail");
    private final By productImagesSelector = By.cssSelector("div.ivRow>div");
    protected String wishlistText = new String("Use lists to save items for later. All lists are private unless you share them with others.");
    private final By wishlistForm =  By.id("create-list-form");
    private final By checkoutButton =  By.name("proceedToRetailCheckout");
    private final By buynowButton =  By.id("buy-now-button");
    private final By wishlistButton =  By.id("add-to-wishlist-button-submit");
    private final By addToWishlistButton =  By.id("wl-redesigned-create-list");
    private final By addToWishlistUnauthorisedSelector = By.cssSelector("span#wishListMainButton>span>a");
    private final By addToCartButton =  By.id("add-to-cart-button");
    protected String addToCartText = new String("Added to Cart");
    private final By addToCartTextSelector = By.id("NATC_SMART_WAGON_CONF_MSG_SUCCESS");
    private final By productHeading =  By.id("titleSection");
    private final By offersSelector = By.id("vsxoffers_feature_div");
    private final By featuresSelector =  By.id("feature-bullets");
    private final By specificationsSelector = By.id("technicalSpecifications_feature_div");
    private final By aboutSelector =  By.id("aplus_feature_div");
    private final By questionsSelector =  By.id("ask-btf_feature_div");
    private final By reviewsSelector =  By.id("reviewsMedley");
    private final By cartCountSelector =  By.id("nav-cart-count");
    private final By getAddToWishlistConfirmButton = By.id("wl-redesigned-create-list");
    private final By closeWishlist = By.cssSelector("header.a-popover-header>button.a-button-close");
    private final By greetingsSelector = By.id("nav-link-accountList-nav-line-1");
    public int cartCount;

    public ProductPage(TestBase testBase) {
        super(testBase);
    }
    public void verifyProductImages(){
        switchToNewTab();
        isElementVisible(defaultImage);
    }
    public void openProductImageandVerify(){
        switchToNewTab();
        isElementVisible(defaultImage);
        clickElement(defaultImage);
        List<WebElement> productImages = getElements(productImagesSelector);
        for (WebElement productImage:
                productImages) {
            waitUntilElementDisplayed(productImage);
            productImage.click();
        }
    }
    public void selectProductImageandVerify(){
        switchToNewTab();
        isElementVisible(defaultImage);
        List<WebElement> thumbnailImages = getElements(thumbnailImagesSelector);
        for (WebElement thumbnailImage:
             thumbnailImages) {
            waitUntilElementDisplayed(thumbnailImage);
            thumbnailImage.click();
        }
    }
    public void verifyCorrectProductOpened(String productName){
        switchToNewTab();
        String displayedProductName = getElementText(ProductNameSelector);
        displayedProductName.toLowerCase().contains(productName);
        logger.info(displayedProductName +" contains "+ productName);
    }
    public void verifyProductPage(){
        switchToNewTab();
        waitUntilElementVisible(defaultImage);
        isElementVisible(defaultImage);
        isElementVisible(productHeading);
        isElementVisible(aboutSelector);
        isElementVisible(questionsSelector);
        isElementVisible(reviewsSelector);
        isElementVisible(featuresSelector);
        isElementVisible(addToCartButton);
        isElementVisible(buynowButton);
    }
    public void checkCartQuantity(){
        cartCount =   Integer.parseInt(getElementText(cartCountSelector));
        logger.info("Cart Quantity is "+cartCount);
    }
    public void addToCart(){
        switchToNewTab();
        clickElement(addToCartButton);
        isTextVisible(addToCartTextSelector,addToCartText);
    }
    public void verifyCartQuantityIncreased(int cartcount){
        isTextVisible(cartCountSelector,Integer.toString(cartcount+1));
        logger.info("Current cart quantity is "+getElementText(cartCountSelector));
    }
    public void addToWishlist(){
        switchToNewTab();
        if (getElementText(greetingsSelector).contains("Hello, sign in")){
            clickElement(addToWishlistUnauthorisedSelector);
        }else{
            clickElement(wishlistButton);
        }
    }
    public void verifyWishlistPage(){
        waitUntilElementVisible(wishlistForm);
        isElementVisible(wishlistForm);
    }
    public void addproductToWishlist(){
        clickElement(getAddToWishlistConfirmButton);
        waitUntilElementVisible(closeWishlist);
        clickElement(closeWishlist);
    }
    public void beginCheckout(){
        waitUntilElementVisible(checkoutButton);
        clickElement(checkoutButton);
    }
    public void buyProductNow(){
        switchToNewTab();
        waitUntilElementVisible(buynowButton);
        clickElement(buynowButton);
    }
}
