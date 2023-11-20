import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class Demo12 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
//        testMyFirstWebDriver();
//        testFirstElements();
//        testClick();
//        testSendKey();
//        testSendKey();
//        testClear();
//        testCommonCommands();
        testFindVolvo();
    }

    private static void testMyFirstWebDriver() {

        ChromeDriver driver = new ChromeDriver();
        driver.get("http://training.skillo-bg.com:4300/posts/all");
        driver.manage().window().maximize();
        WebElement loginLink = driver.findElement(By.id("nav-link-login"));
        loginLink.click();
        WebElement homeElement = driver.findElement(By.linkText("Home"));
        homeElement.click();
        driver.close();
    }

    private static void testFirstElements(){
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://training.skillo-bg.com:4300/posts/all");
        List<WebElement> posts = driver.findElements(By.xpath("//*[@class='post-feed-img']"));
        System.out.println("The number of elements is:" + posts.size());

        assertEquals(posts.size(),3);
        driver.close();
    }
    private static void testClick(){
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://training.skillo-bg.com:4300/posts/all");
        WebElement loginLink = driver.findElement(By.id("nav-link-login"));
        loginLink.click();

        driver.close();
}
private static void testSendKey() {
    ChromeDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get("http://training.skillo-bg.com:4300/posts/all");
    WebElement loginLink = driver.findElement(By.id("nav-link-login"));
    loginLink.click();
    WebElement username = driver.findElement(By.id("defaultLoginFormUsername"));
    username.click();
    username.sendKeys("NAME");
    driver.close();

}

private static void testClear(){
    ChromeDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get("http://training.skillo-bg.com:4300/posts/all");
    WebElement loginLink = driver.findElement(By.id("nav-link-login"));
    loginLink.click();
    WebElement username = driver.findElement(By.id("defaultLoginFormUsername"));
    username.click();
    username.sendKeys("NAME");
    WebElement password = driver.findElement(By.id("defaultLoginFormPassword"));
    password.sendKeys("Password");
    username.clear();
    username.sendKeys("NameCorrected");
    driver.close();
    }

    public static void testCommonCommands(){
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://training.skillo-bg.com:4300/posts/all");
        String titleOfPage = driver.getTitle();
        System.out.println("The page title is: "+ titleOfPage);

        WebElement loginLink = driver.findElement(By.id("nav-link-login"));
        loginLink.click();
WebElement rememberMe = driver.findElement(By.xpath("//*[@formcontrolname='rememberMe']"));
       rememberMe.click();
System.out.println("Is the element selected?");

WebElement buttonSignIn = driver.findElement(By.id("sign-in-button"));
String buttontext= buttonSignIn.getText();
System.out.println("The element text is "+ buttontext);
System.out.println("Is the element displayed "+ buttonSignIn.isDisplayed());

WebElement username = driver.findElement(By.id("defaultLoginFormUsername"));
username.click();
username.sendKeys("NAME");
WebElement password = driver.findElement(By.id("defaultLoginFormPassword"));
password.sendKeys("Password");
System.out.println("Is the element Enabled "+ buttonSignIn.isEnabled());
 driver.close();
    }
    private static void testFindVolvo() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.mobile.bg/pcgi/mobile.cgi");
//        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
//        WebElement webEl;
//        webEl= wait.until((ExpectedConditions.visibilityOfElementLocated(By.linkText(String.valueOf(By.xpath("//p[contains(text(),'Към')]"))))));
        WebElement toTheSite = driver.findElement(By.xpath("//p[contains(text(),'Към')]"));
        toTheSite.click();
        Select dropdownMarka = new Select(driver.findElement(By.xpath("//*[@name='marka']")));
        dropdownMarka.selectByVisibleText("Ferrari");
        WebElement extendedSearch = driver.findElement(By.xpath("//*[@class='linkSearch']"));
        extendedSearch.click();
        Select dropdownColor = new Select(driver.findElement(By.xpath("//*[@name='f16']")));
        dropdownColor.selectByVisibleText("Червен");
        WebElement searchButton = driver.findElement(By.xpath("//*[@type='button']"));
        searchButton.click();
        //Neet to find out how to look for smallest price ( sort by price) and to get the smallest price
//        WebElement findMinPrice = driver.findElement(By.xpath("//*[@class='price']"));
//        int price = Integer.parseInt(findMinPrice);
//        if (price > 20000){
//    findMinPrice.click();
// }


      driver.close();
    }
    }



