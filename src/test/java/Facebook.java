import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Facebook {
    WebDriver driver;
    @Test  //Getting Links from Facebook page
    public void getAllLinks() throws InterruptedException {

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("The number of links on Facebook page are "+ links.size());
        for (WebElement link:links) {
            System.out.println(link.getText());
        }
        links.get(1).click();
        Thread.sleep(2000);
        System.out.println("The title of forgot page is "+driver.getTitle());
        driver.findElement(By.linkText("Forgotten account?")).click();
        Thread.sleep(2000);
        String parentWindow = driver.getWindowHandle();
        Set<String> handles =  driver.getWindowHandles();
        for(String windowHandle  : handles)
        {
            if(!windowHandle.equals(parentWindow))
            {
                driver.switchTo().window(windowHandle);
                String email = "om@gmail.com";
                driver.findElement(By.id("identify_email")).sendKeys(email);
                driver.findElement(By.id("did_submit")).click();
                Thread.sleep(3000);
                String shownMail = driver.findElement(By.cssSelector("tbody>tr>td:nth-child(2)>div>div:nth-child(2)")).getText();
                Assert.assertEquals(email,shownMail);
            }
        }

    }

    @Test //login to facebook
    public void login() throws InterruptedException {
//        driver.findElement(By.id("Password")).sendKeys("abcd");
        driver.findElement(By.id("UserIdentifier")).sendKeys("abcd");
        driver.findElement(By.name("Password")).sendKeys("abcd");
//        driver.findElement(By.cssSelector("div>button")).click();
        Thread.sleep(10000);
    }
    @Test //login to lids
    public void lids() throws InterruptedException, IOException {
//        driver.findElement(By.id("Password")).sendKeys("abcd");
//        driver.findElement(By.id("UserIdentifier")).sendKeys("abcd");
//        driver.findElement(By.name("Password")).sendKeys("abcd");
//        driver.findElement(By.cssSelector("div>button")).click();

        Runtime.getRuntime().exec("C:\\Intel\\lpso5.exe");
        Thread.sleep(10000);
    }
    @Test //login to lids
    public void uploadFile() throws InterruptedException {
//        driver.findElement(By.id("Password")).sendKeys("abcd");
        driver.findElement(By.id("UserIdentifier")).sendKeys("abcd");
        driver.findElement(By.name("Password")).sendKeys("abcd");
//        driver.findElement(By.cssSelector("div > label:nth-child(1)")).click();
        driver.findElement(By.cssSelector("div > label:nth-child(1)")).sendKeys("C:\\Users\\osatam\\learning\\bill\\invoice.pdf");


//        Runtime.getRuntime().exec("C:\\Intel\\lpso5.exe");
        Thread.sleep(10000);
    }

    @BeforeMethod
    public void openBrowser() throws InterruptedException {
    //Setting up webdriver
        System.setProperty("webdriver.ie.driver","C:\\bin\\IEDriverServer.exe");
        InternetExplorerOptions ieOptions = new InternetExplorerOptions();
//        ieOptions.attachToEdgeChrome();
//        ieOptions.ignoreZoomSettings();
        ieOptions.withEdgeExecutablePath("C:\\bin\\msedgedriver1.exe");
//        System.setProperty("webdriver.edge.driver","C:/bin/msedgedriver1.exe");
        driver = new InternetExplorerDriver();
//        driver = new EdgeDriver();
        driver.get("https://wfltsc.xchanging.com/");
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(  10, TimeUnit.SECONDS);
//        driver.findElement(By.id("UserIdentifier")).sendKeys("abcd", Keys.RETURN);
    }
//    @AfterSuite
//    public void closeBrowser(){
//        driver.quit();
//    }
}




