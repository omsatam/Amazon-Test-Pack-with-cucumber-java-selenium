package base;
import base.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.*;
import java.nio.charset.Charset;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class PageBase{
    public TestBase testBase;
    public PageBase(TestBase testBase){
        this.testBase = testBase;
    }
    private static final Logger logger = LogManager.getLogger(PageBase.class);

        public void closeBrowser(){
        testBase.getDriver().close();
    }
    public Properties getProerties() throws IOException {
        Properties props=new Properties();
        FileReader reader=new FileReader("./src/test/resources/config.properties");
        props.load(reader);
        return props;
    }
        // mouse clicks and actions
    public void navigateTo(String URL) throws IOException {
        testBase.initializeDriver();
        testBase.getDriver().get(URL);
        testBase.getDriver().manage().window().maximize();
        logger.info("Webpage opened Successfully");
    }
    public void mouseOverToElement(By Elementlocator){
        WebElement ele = testBase.getDriver().findElement(Elementlocator);
        Actions action = new Actions(testBase.getDriver());
        action. moveToElement(ele).build().perform();
        logger.info("Mouse hover to Element "+ Elementlocator);
    }
    public void waitUntilElementVisible(By Elementlocator){
        WebDriverWait wait = new WebDriverWait(testBase.getDriver(), Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Elementlocator));
        logger.info("Waited till element "+ Elementlocator +" to be visible");
    }
    public void waitUntilElementTextVisible(By Elementlocator,String text){
        WebDriverWait wait = new WebDriverWait(testBase.getDriver(), Duration.ofSeconds(60));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(Elementlocator,text));
        logger.info("Waited till element "+ Elementlocator +" text "+ text + " to be visible");
    }
    public void waitUntilElementDisplayed(WebElement element){
        WebDriverWait wait = new WebDriverWait(testBase.getDriver(), Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(element));
        logger.info("Waited till element "+ element +" to be visible");
    }
    public void sleep(Integer milliSeconds) {
        double secondsLong = (double) milliSeconds;
        try {
            Thread.sleep(milliSeconds);
            logger.info("Waited For "+ secondsLong/1000 + " Seconds");
        } catch (Exception e) {
            logger.error(e.getMessage());
            // InterruptedException
        }
    }
    public void clickElementByText(String text){
        testBase.getDriver().findElement(By.partialLinkText(text)).click();
        logger.info("Clicked Element by Text "+text);
    }
    public void clickElementByExactText(String text){
        testBase.getDriver().findElement(By.linkText(text)).click();
        logger.info("Clicked Element by Exact Text "+text);
    }

    public void switchToNewTab(){
        ArrayList<String> newTb = new ArrayList<String>(testBase.getDriver().getWindowHandles());
        //switch to new tab
        testBase.getDriver().switchTo().window(newTb.get(1));
        logger.info("Switched to new tab "+newTb.get(1));
    }
    public String getElementText(By ElementLocator){
        return testBase.getDriver().findElement(ElementLocator).getText();
    }
    public List getElements(By Elementlocator){
        return testBase.getDriver().findElements(Elementlocator);
    }
    public void clickElement(By Elementlocator){
        testBase.getDriver().findElement(Elementlocator).click();
        logger.info("Clicked Element "+Elementlocator);
    }
    public void scrollToElement(By ElementLocator){
        ((JavascriptExecutor) testBase.getDriver()).executeScript("arguments[0].scrollIntoView(true);", testBase.getDriver().findElement(ElementLocator));
        logger.info("Scrolled to Element "+ ElementLocator);
    }
    public void scrollToElement(WebElement Element){
        ((JavascriptExecutor) testBase.getDriver()).executeScript("arguments[0].scrollIntoView(true);", Element);
        logger.info("Scrolled to Element "+ Element);
    }
    public void clickElementbyJavascript(By ElementLocator){
        ((JavascriptExecutor) testBase.getDriver()).executeScript("arguments[0].click();", testBase.getDriver().findElement(ElementLocator));
        logger.info("Clicke element "+ ElementLocator);
    }
    public void setElement(By Elementlocator, String value){
        clearElement(Elementlocator);
        testBase.getDriver().findElement(Elementlocator).sendKeys(value);
        logger.info("Element "+ Elementlocator +" value set to "+ value + " Successfully");
    }
    public void isElementVisible(By Elementlocator){
        testBase.getDriver().findElement(Elementlocator).isDisplayed();
        logger.info("Element "+Elementlocator +" is Displayed Correctly");
    }
    public void isTextVisible(By Elementlocator, String text){
        Assert.assertEquals(testBase.getDriver().findElement(Elementlocator).getText(),text);
        logger.info("Element "+ Elementlocator +"text is "+ text);
    }
public void clearElement(By ElementLocator){
        testBase.getDriver().findElement(ElementLocator).clear();
        logger.info("Element "+ElementLocator +" is  Cleared");
}

    }


