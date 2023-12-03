import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class Sampletest {

    ChromeDriver driver;
    WebDriverWait wait;
    @Before
    public void beforeEach(){
        System.setProperty("web.driver.chrome", "C:\\Users\\pkom9\\Desktop\\chromedriver_win32");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofMillis(1000));
    }

    @Test
    public void openEasybooks() throws InterruptedException {
        driver.get("http://easybooks/");
        driver.manage().window().maximize();
        Thread.sleep(10000);
    }




//    @Test
//    public void openWebsite(){
//        driver.get("https://www.empik.com");
//        driver.manage().window().maximize();
//        driver.manage().deleteAllCookies();
//        WebElement findCookiesButton = driver.findElement(By.cssSelector("button[data-ta=\"cookie-btn-accept-all\"]"));
//        wait.until(ExpectedConditions.elementToBeClickable(findCookiesButton));
//        findCookiesButton.click();
//    }

//    @Test
//    public void newTest(){
//        driver.get("https://www.saucedemo.com");
//        driver.manage().window().maximize();
//        WebElement Username = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
//        Username.click();
//        Username.sendKeys("standard_user");
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"password\"]")));
//    }

//    @After
//    public void isItOK(){
//        driver.close();
//    }

}
