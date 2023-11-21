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
public class demo14_notHomeWork {
    public static void main(String[] args) {
        archiveLaunch();
    }
        public static void archiveLaunch() {
            WebDriverManager.chromedriver().setup();
            ChromeDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            //Open WebArchive Site
            driver.get("https://web.archive.org/");

            //Validate the home page is loaded
            String pageTital = driver.getTitle();
            Assert.assertEquals(pageTital,"Wayback Machine");

            //Find the searchbar
            WebElement searchbar = driver.findElement(By.cssSelector(".rbt-input-main"));
            searchbar.click();

            //Enter the domain name
            searchbar.sendKeys("www.demoqa.com");

            //Select the first option from the dropdown
            WebElement option0 = driver.findElement(By.id("search-input-item-0"));
            option0.click();

//            //Notsure what to do next once you hover above the number 8 (august 2023) a snapshot with time appears, not sure how to set it up :/
//            WebElement lastDate= driver.findElement(By.xpath("web/20230808/demoqa.com:hover"));
//           // lastDate.click();
//
//            //Just need to click on the snapshot and it's opening the website archive
//            WebElement lastDateNTime = driver.findElement(By.cssSelector("a.s2xx"));
//            lastDateNTime.click();
//


driver.close();
        }
    }

