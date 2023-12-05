import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Tests {

    ChromeDriver driver;
    WebDriverWait wait;

    @Before
    public void beforeEach() {
        System.setProperty("web.driver.chrome", "C:\\Users\\pkom9\\Desktop\\chromedriver_win32");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofMillis(1000));
    }

    @Test
    public void TC17(){
        LoginPage loginPage = new LoginPage(driver, wait);

        loginPage.openEasybooks();
        loginPage.fillLoginForm("test@gmail.com","test");
        loginPage.submitLoginWithMouseClick();
    }

    @Test
    public void TC22() {

        LoginPage loginPage = new LoginPage(driver, wait);

        loginPage.openEasybooks();
        loginPage.fillLoginForm("test@gmail.com","test");
        loginPage.submitLoginWithEnter();
    }

    @Test
    public void TC21() {
        LoginPage loginPage = new LoginPage(driver, wait);

        loginPage.openEasybooks();
        loginPage.login("test@gmail.com", "test");
        loginPage.logoutFromService();
    }

    @Test
    public void TC18(){
        LoginPage loginPage = new LoginPage(driver, wait);

        loginPage.openEasybooks();
        loginPage.fillLoginForm("nonexistetetnt@gmail.com", "Tester123!");
        loginPage.submitLoginWithMouseClick();
        loginPage.checkIfMessageFail("Niepoprawny adres e-mail i/lub hasło.");
    }

    @Test
    public void TC19(){
        LoginPage loginPage = new LoginPage(driver, wait);

        loginPage.openEasybooks();
        loginPage.fillLoginForm("test@gmail.com", "wrongpassword");
        loginPage.submitLoginWithMouseClick();
        loginPage.checkIfMessageFail("Niepoprawny adres e-mail i/lub hasło.");
    }

    @Test
    public void TC20(){
        LoginPage loginPage = new LoginPage(driver, wait);

        loginPage.openEasybooks();
        loginPage.fillLoginForm("wrongemailformat.com", "somepassword");
        loginPage.submitLoginWithMouseClick();
        loginPage.checkIfMessageFail("Niepoprawny adres e-mail i/lub hasło.");
    }

    @Test
    public void TC6(){
        LoginPage loginPage = new LoginPage(driver, wait);
        RegistrationPage registrationPage = new RegistrationPage(driver, wait);
        
        loginPage.openEasybooks();
        loginPage.goToRegistrationForm();
        registrationPage.fillRegistrationFormWithRandomEmail("Jack", "Hemingway", "Tester123!");
        registrationPage.submitRegistrationWithMouseClick();
    }

    @Test
    public void TC44(){
        LoginPage loginPage = new LoginPage(driver, wait);
        RegistrationPage registrationPage = new RegistrationPage(driver, wait);

        loginPage.openEasybooks();
        loginPage.goToRegistrationForm();
        registrationPage.fillRegistrationForm("Jack", "Jones", "specialcharemail!@gmail.com", "Tester123!");
        registrationPage.checkIfMessageFailEmail("Niestety, możesz użyć tylko liter (a-z), cyfr (0-9) i kropki (.)");


    }

//    @After
//    public void isItOK() {
//        driver.close();
//    }
}

