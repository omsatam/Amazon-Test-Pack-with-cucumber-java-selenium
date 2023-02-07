package base;
import Pages.*;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Properties;


public class TestBase {
    private static final Logger logger = LogManager.getLogger(TestBase.class);
    public Properties prop;
    public WebDriver driver;
    CartPage cartpage;
    CheckoutPage checkOutPage;
    HomePage homePage;
    ProductPage productPage;
    LandingPage landingPage;
    ResultPage resultPage;
    SearchPage searchPage;
    SigninPage signinPage;
    SignupPage signupPage;
    Topnav topnav;
    public void initializeDriver() throws IOException {
        Properties props=new Properties();
        FileReader reader=new FileReader("./src/test/resources/config.properties");
        props.load(reader);
        if (driver == null) {
            if (props.getProperty("Browser").equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "./target/webdriver/chromedriver.exe");
                driver = new ChromeDriver();
                setDriver(driver);
            }else if (prop.getProperty("Browser").equalsIgnoreCase("edge")) {
                System.setProperty("webdriver.edge.driver", "./target/webdriver/msedgedriver1.exe");
                driver = new EdgeDriver();
                setDriver(driver);
            }
        }
    }
    public void getProperties(){

    }
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
    public WebDriver getDriver() {
        return driver;
    }
    public CartPage getCartpage() {
        return cartpage;
    }
    public HomePage getHomePage() {
        return homePage;
    }
    public ProductPage getProductPage() {
        return productPage;
    }
    public LandingPage getLandingPage() {
        return landingPage;
    }
    public ResultPage getResultPage() {
        return resultPage;
    }
    public SearchPage getSearchPage() {
        return searchPage;
    }
    public SigninPage getSigninPage() {
        return signinPage;
    }
    public SignupPage getSignupPage() {
        return signupPage;
    }
    public Topnav getTopnav() {
        return topnav;
    }
//    public void initializeDriver(WebDriver driver){
//        this.driver = driver;
//    }
    public void initializePageObjects(TestBase testBase) throws IOException {
        cartpage = new CartPage(testBase);
        checkOutPage = new CheckoutPage(testBase);
        homePage = new HomePage(testBase);
        landingPage = new LandingPage(testBase);
        productPage = new ProductPage(testBase);
        resultPage = new ResultPage(testBase);
        searchPage = new SearchPage(testBase);
        signinPage = new SigninPage(testBase);
        signupPage = new SignupPage(testBase);
        topnav = new Topnav(testBase);
    }
}
