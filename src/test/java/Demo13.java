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
public class Demo13 {
    // private WebDriver driver;
    public static void main(String[] args) {
        testLogin();
//        openSite();
//        logIn();
//        validateLogInURL();

    }

    public static void testLogin() {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://training.skillo-bg.com:4300/");
        String pageTital = driver.getTitle();
        Assert.assertEquals(pageTital,"ISkillo");
        System.out.println(pageTital);

        //Click a Login button
        WebElement loginLink = driver.findElement(By.id("nav-link-login"));
        loginLink.click();

        //Validate URL
       String loginPageURL = driver.getCurrentUrl();
       String expectedPageURL= "http://training.skillo-bg.com:4300/users/login";
       Assert.assertEquals(loginPageURL, expectedPageURL);
//        System.out.println(loginPageURL);

        //Validate Sign in form is visible
        WebElement signInForm = driver.findElement(By.cssSelector(".h4"));
        Assert.assertTrue(signInForm.isDisplayed(), "The Sign in form is not visible");

        // Enter Valid Email address
        WebElement userNameField = driver.findElement(By.id("defaultLoginFormUsername"));
        userNameField.sendKeys("blablablo@abv.bg");

        //Enter Valid Password
        WebElement userPasswordField = driver.findElement(By.id("defaultLoginFormPassword"));
        userPasswordField.sendKeys("111111A");

//        //Select Remember me button
//        WebElement rememberMeCheckBox = driver.findElement(By.xpath("//*[@formcontrolname='rememberMe']"));
//        rememberMeCheckBox.click();
//
//        //Validate Remember me is checked
//        Assert.assertTrue(rememberMeCheckBox.isSelected(), "The remember me box is not selected");
//        //System.out.println(rememberMeCheckBox.isSelected());

        //Click on sign in button
        WebElement signInButton = driver.findElement(By.id("sign-in-button"));
        Assert.assertTrue(signInButton.isEnabled());
        signInButton.click();

        //Check profile link is present
        WebElement profileLink = driver.findElement(By.id("nav-link-profile"));
        Assert.assertTrue(profileLink.isDisplayed(), "Profile Link is not displayed ");

        //Click on link Profile
        profileLink.click();

        //Validate username on profile page
        WebElement usernameProfilePage = driver.findElement(By.tagName("h2"));
        String actualUsername = usernameProfilePage.getText();
        String expectedUsername = "BlaBlaBlo";
        Assert.assertEquals(actualUsername, expectedUsername);

        //Validate Current
        String useURL = driver.getCurrentUrl();
        String expectUserUrl = "http://training.skillo-bg.com:4300/users/5049";
        Assert.assertEquals(useURL, expectUserUrl);

        driver.close();
    }
}