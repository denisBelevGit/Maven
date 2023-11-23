import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;
public class Demo15 {
    private WebDriver driver;

    public static final String PASSWORD = "AA43feff";

    public static void main(String[] args) {

    }

    @Test
    public void testRegistration(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //Load Skillo website
        driver.get("http://training.skillo-bg.com:4300/posts/all");

        //Click Login link
        WebElement loginLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-link-login")));
        loginLink.click();

//          Validate Sign in is visible
        WebElement signInElement = driver.findElement(By.xpath("//p[text() = 'Sign in']"));

//        Click on Register link
        WebElement registerLink = driver.findElement(By.linkText("Register"));
// option2   //  WebElement registerLink = driver.findElement(By.cssSelector("users/register");
        registerLink.click();

//        Validate Web page URL
        wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4300/users/register"));

//        Validate Sing up is visible
        WebElement signUpElement = driver.findElement(By.cssSelector("h4"));
        wait.until(ExpectedConditions.visibilityOf(signUpElement));

//        Enter username
        WebElement usernameField = driver.findElement(By.name("username"));
        String username = generateRandomString(7, 10);
        usernameField.sendKeys(username);


        //        Enter email
        WebElement emailField = driver.findElement(By.cssSelector("[type = 'email']"));
        String email = generateRandomEmail(7,10);
        usernameField.sendKeys(email);

//        Add birthday
        WebElement birthDayField = driver.findElement(By.cssSelector("[type = 'date']"));
        birthDayField.sendKeys("11112022");

        //        Enter Password
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys(PASSWORD);


        // Enter Verify Password
        WebElement confirmPassword = driver.findElement(By.name("verify-password"));
        confirmPassword.sendKeys(PASSWORD);

        //Add publiv Info
        WebElement publicInfo = driver.findElement(By.name("pulic-info"));
        String pinfo = generateRandomString(10, 20);
        publicInfo.sendKeys(pinfo);

        //Click Sign In/Up
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.id("sign-in-button")));
        button.click();

        //Wait for page to load
        wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com/posts/all"));

        //Click on profile

        WebElement profileLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-link-profile")));

        //Validate profile page
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.urlContains("http://training.skillo-bg.com/users/"));

        //Validate username
        Boolean isTextDisplayed = wait.until(ExpectedConditions.textToBe(By.tagName("h2"), username));
        Assert.assertTrue(isTextDisplayed, "The text is not displayed");


    }

    private String generateRandomString(int minLenghtInclusive, int maxLenghtInclusive) {
        return RandomStringUtils.randomAlphanumeric(minLenghtInclusive, maxLenghtInclusive);

    }
    private String generateRandomEmail(int minLenghtInclusive, int maxLenghtInclusive) {


               return RandomStringUtils.randomAlphanumeric(minLenghtInclusive, maxLenghtInclusive);


    }
}


