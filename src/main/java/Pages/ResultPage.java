package Pages;

import base.PageBase;
import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ResultPage extends PageBase {
    private static final Logger logger = LogManager.getLogger(ResultPage.class);
    public String productName;
    private final By sortBySelector = By.cssSelector("span> span.a-dropdown-prompt");
    private final By lowToHighSortBySelector = By.id("s-result-sort-select_1");
    private final By highToLowSortBySelector = By.id("s-result-sort-select_2");
    private final By newestArrivalsSortBySelector = By.id("s-result-sort-select_4");
    private final By avgCustReviewSortBySelector = By.id("s-result-sort-select_3");
    private final By displayedProductsNamesSelector = By.cssSelector("div.sg-row>div>div.sg-col-inner>div>div>h2.a-size-mini>a>span");
    private final By displayedProductsRatingsSelector = By.cssSelector("div.a-spacing-top-micro>div.a-size-small>span:nth-child(1)");
    private final By displayedProductsDiscountSelector = By.cssSelector("div.sg-row>div>div.sg-col-inner>div>div>div>div>div.s-price-instructions-style>div>span:nth-child(3)");
    private final By displayedProductsPriceSelector = By.cssSelector("div.sg-row>div>div.sg-col-inner>div>div>div>div>div.s-price-instructions-style>div>a>span.a-price:nth-child(1)");
    protected String brandName1Selector = new String("div#brandsRefinements>ul>li:nth-child(");
    protected String brandName2Selector = new String(")>span>a>div>label>i");
    protected String stars1Selector = new String("div#reviewsRefinements>ul>li:nth-child(");
    protected String stars2Selector = new String(")>span>a>section");
    protected String discount1Selector = new String("//div[@id='filters']/ul[@aria-labelledby='p_n_pct-off-with-tax-title']/li[position()=");
    protected String discount2Selector = new String("]/span/a/span");
    protected String price1Selector = new String("div#priceRefinements>ul>li:nth-child(");
    protected String price2Selector = new String(")>span>a>span");
    private final By resultsTextSelector = By.cssSelector("span.rush-component>div:nth-child(1)>div>span");
    protected String resultsText = new String("RESULTS");
    private final By ProductSelector = By.cssSelector("div.s-search-results>div:nth-child(5)>div>div>div>div>div>div:nth-child(2)>div>div>div>h2>a");
    public ResultPage(TestBase testBase) {
        super(testBase);
        Topnav topnav = testBase.getTopnav();
    }
    public void selectProductFromResults(){
        productName = getElementText(ProductSelector);
        clickElement(ProductSelector);

    }

    public void verifyDefaultSortBy() {
        waitUntilElementVisible(sortBySelector);
        isTextVisible(sortBySelector, "Featured");
    }
    public void changeFilterVerifyResults(String filterValue) {
        if(filterValue.contains("Avg. Customer Review")){
            waitUntilElementVisible(sortBySelector);
            clickElement(sortBySelector);
            clickElement(avgCustReviewSortBySelector);
            waitUntilElementVisible(resultsTextSelector);
            isTextVisible(sortBySelector,"Avg. Customer Review");
        } else if (filterValue.contains("Price Low To High")) {
            waitUntilElementVisible(sortBySelector);
            clickElement(sortBySelector);
            clickElement(lowToHighSortBySelector);
            waitUntilElementVisible(resultsTextSelector);
            isTextVisible(sortBySelector,"Price: Low to High");
            List<WebElement> displayedProductPrices = getElements(displayedProductsPriceSelector);
            ArrayList<Integer> priceList = new ArrayList<Integer>();
            for (WebElement displayedProductPrice: displayedProductPrices) {
                try {
                    String displayedPrice = displayedProductPrice.getText().substring(displayedProductPrice.getText().indexOf("₹")).replace(",", "");
                    int displayedProductPriceInt = Integer.parseInt(displayedPrice.replace("₹", "").replaceAll("^\"|\"$", "").trim());
                    priceList.add(displayedProductPriceInt);
                } catch (Exception e){
                    logger.error("Some Exception occured in displayed product price "+ e.getMessage());
                }
            }
            List copy = new ArrayList(priceList);
            Collections.sort(copy);
            if (copy.equals(priceList)) {
                logger.info("products are displayd in Low to High price i.e, displayed prices " + priceList + " are not equal to " + copy);
            } else {
                logger.error("products are not displayd in Low to High price i.e, displayed prices " + priceList + " are not equal to " + copy);
                Assert.assertTrue(false, "products are not displayd in Low to High price i.e, displayed prices " + priceList + " are not equal to " + copy);
            }
        } else if (filterValue.contains("Price High To Low")) {
            waitUntilElementVisible(sortBySelector);
            clickElement(sortBySelector);
            clickElement(highToLowSortBySelector);
            waitUntilElementVisible(resultsTextSelector);
            isTextVisible(sortBySelector, "Price: High to Low");
            List<WebElement> displayedProductPrices = getElements(displayedProductsPriceSelector);
            ArrayList<Integer> priceList = new ArrayList<Integer>();
            for (WebElement displayedProductPrice : displayedProductPrices) {
                String displayedPrice = displayedProductPrice.getText().substring(displayedProductPrice.getText().indexOf("₹")).replace(",", "");
                int displayedProductPriceInt = Integer.parseInt(displayedPrice.replace("₹", "").replace(".","").trim());
                priceList.add(displayedProductPriceInt);
            }
            List copy = new ArrayList(priceList);
            Collections.sort(copy,Collections.reverseOrder());
            if (copy.equals(priceList)) {
                logger.info("products are not displayd in High to Low price i.e, displayed prices " + priceList + " are not equal to " + copy);
            } else {
                logger.error("products are not displayd in High to Low price i.e, displayed prices " + priceList + " are not equal to " + copy);
                Assert.assertTrue(false, "products are not displayd in High to Low price i.e, displayed prices " + priceList + " are not equal to " + copy);
            }
        }else {
            waitUntilElementVisible(sortBySelector);
            clickElement(sortBySelector);
            clickElement(newestArrivalsSortBySelector);
            waitUntilElementVisible(resultsTextSelector);
            isTextVisible(sortBySelector,"Newest Arrivals");
        }
    }

    public void selectBrandNameVerifyResults(String BrandName) {
        String brandName = getElementText(By.cssSelector(brandName1Selector+ BrandName + ")"));
        clickElement(By.cssSelector(brandName1Selector + BrandName + brandName2Selector));
        waitUntilElementVisible(resultsTextSelector);
        isTextVisible(resultsTextSelector,resultsText);
        List<WebElement> displayedProducts =  getElements(displayedProductsNamesSelector);
        for (WebElement dispayedProduct:displayedProducts) {
            if (dispayedProduct.getText().toLowerCase().contains(brandName.toLowerCase())){
                logger.info(dispayedProduct.getText() + " contains " + brandName);
            }
            else {
                scrollToElement(dispayedProduct);
                logger.error(dispayedProduct.getText() + " does not contain " + brandName);
                Assert.assertTrue(false,dispayedProduct.getText() + " does not contain " + brandName);
            }
        }
    }
    public void selectGivenStarsVerifyResults(int stars) {
        clickElement(By.cssSelector(stars1Selector + Integer.toString(5 - stars) + stars2Selector));
        waitUntilElementVisible(resultsTextSelector);
        isTextVisible(resultsTextSelector,resultsText);
        List<WebElement> displayedProducts =  getElements(displayedProductsRatingsSelector);
        for (WebElement dispayedProduct:displayedProducts) {
            String rating = dispayedProduct.getAttribute("aria-label");
            if (rating != null){
                if (stars <= Integer.parseInt(String.valueOf(rating.charAt(0)))){
                    logger.info("Displayed Stars are correct " + rating.charAt(0)+ " for provided condition "+ stars + " stars and up" );
                }else {
                    scrollToElement(dispayedProduct);
                    logger.error("Displayed stars are Incorrect" + rating.charAt(0) + " for provided condition "+ stars + " stars and up");
                    Assert.assertTrue(false,"Displayed stars are Incorrect" + rating.charAt(0) + " for provided condition "+ stars + " stars and up");
                }
            }
            else {
                logger.info(dispayedProduct.getText() + " does not contain " + stars);
            }
        }
    }

    public void changeDiscountCategoryVerifyResults(String discountCategory) {
        int DiscountCategory = Integer.parseInt(getElementText(By.xpath(discount1Selector + discountCategory + discount2Selector)).substring(0,2));
        clickElement(By.xpath(discount1Selector + discountCategory + discount2Selector));
        waitUntilElementVisible(resultsTextSelector);
        isTextVisible(resultsTextSelector,resultsText);
        List<WebElement> displayedProducts =  getElements(displayedProductsDiscountSelector);
        for (WebElement dispayedProduct:displayedProducts) {
            int displayedDiscount = Integer.parseInt(dispayedProduct.getText().substring(1,3));
                if (displayedDiscount >= DiscountCategory){
                    logger.info("Displayed Discount are correct " + displayedDiscount + " for provided discount "+ DiscountCategory + " % and up" );
                }else {
                    scrollToElement(dispayedProduct);
                    logger.error("Displayed Discount is incorrect " + displayedDiscount +" for provided discount "+ DiscountCategory + " % and up");
                    Assert.assertTrue(false,"Displayed Discount is incorrect " + displayedDiscount +" for provided discount "+ DiscountCategory + " % and up");
                }
            }
        }

    public void changePriceRangeVerifyResults(int priceRange) {
        String price = getElementText(By.cssSelector(price1Selector+Integer.toString(priceRange)+price2Selector));
        if (priceRange == 1){
            String priceMin = price.substring(price.indexOf("₹")).replace(",","");
            int priceMinInt = Integer.parseInt(priceMin.replace("₹","").trim());
            clickElement(By.cssSelector(price1Selector+Integer.toString(priceRange)+price2Selector));
            waitUntilElementVisible(resultsTextSelector);
            isTextVisible(resultsTextSelector,resultsText);
            List<WebElement> displayedProducts =  getElements(displayedProductsPriceSelector);
            for (WebElement dispayedProduct:displayedProducts) {
                String displayedPrice = dispayedProduct.getText().substring(dispayedProduct.getText().indexOf("₹")).replace(",","");
                int displayedPriceInt = Integer.parseInt(displayedPrice.replace("₹","").trim());
                if (displayedPriceInt <= priceMinInt){
                    logger.info("Displayed price " + displayedPriceInt + " is less than selected maximum price Under "+ priceMinInt);
                }else {
                    scrollToElement(dispayedProduct);
                    logger.error("Displayed price " + displayedPriceInt + " is grater than selected maximum price Under "+ priceMinInt);
                    Assert.assertTrue(false,"Displayed price " + displayedPriceInt + " is grater than selected maximum price Under "+ priceMinInt);
                }
            }
        }else if (priceRange == 5) {
            String priceMax = price.substring(price.indexOf("₹")).replace(",","");
            int priceMaxInt = Integer.parseInt(priceMax.replace("₹","").trim());
            clickElement(By.cssSelector(price1Selector+Integer.toString(priceRange)+price2Selector));
            waitUntilElementVisible(resultsTextSelector);
            isTextVisible(resultsTextSelector,resultsText);
            List<WebElement> displayedProducts =  getElements(displayedProductsPriceSelector);
            for (WebElement dispayedProduct:displayedProducts) {
                String displayedPrice = dispayedProduct.getText().substring(dispayedProduct.getText().indexOf("₹")).replace(",","");
                int displayedPriceInt = Integer.parseInt(displayedPrice.replace("₹","").trim());
                if (displayedPriceInt >= priceMaxInt){
                    logger.info("Displayed price " + displayedPriceInt + " is greater than selected minimum price Over "+ priceMaxInt);
                }else {
                    scrollToElement(dispayedProduct);
                    logger.error("Displayed price " + displayedPriceInt + " is less than selected minimum price Over "+ priceMaxInt);
                    Assert.assertTrue(false,"Displayed price " + displayedPriceInt + " is less than selected minimum price Over "+ priceMaxInt);
                }
            }

        }else {
            String priceMin = price.substring(price.indexOf("₹"),price.indexOf("-")).replace(",","");
            int priceMinInt = Integer.parseInt(priceMin.replace("₹","").trim());
            String priceMax = price.substring(price.indexOf("-")).replace(",","");
            int priceMaxInt = Integer.parseInt(priceMax.replace("₹","").replace("-","").trim());
            clickElement(By.cssSelector(price1Selector+Integer.toString(priceRange)+price2Selector));
            waitUntilElementVisible(resultsTextSelector);
            isTextVisible(resultsTextSelector,resultsText);
            List<WebElement> displayedProducts =  getElements(displayedProductsPriceSelector);
            for (WebElement dispayedProduct:displayedProducts) {
                String displayedPrice = dispayedProduct.getText().substring(dispayedProduct.getText().indexOf("₹")).replace(",","");
                int displayedPriceInt = Integer.parseInt(displayedPrice.replace("₹","").trim());
                if (displayedPriceInt <= priceMaxInt && displayedPriceInt >= priceMinInt) {
                    logger.info("Displayed price " + displayedPriceInt + " is in selected price range of "+ priceMinInt + " to "+ priceMaxInt );
                }else {
                    scrollToElement(dispayedProduct);
                    logger.error("Displayed price " + displayedPriceInt + " is not in selected price range of "+ priceMinInt + " to "+ priceMaxInt );
                    Assert.assertTrue(false,"Displayed price " + displayedPriceInt + " is not in selected price range of "+ priceMinInt + " to "+ priceMaxInt );
                }
            }

        }
    }

}
