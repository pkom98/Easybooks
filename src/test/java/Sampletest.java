import net.bytebuddy.asm.Advice;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Sampletest {

    ChromeDriver driver;
    WebDriverWait wait;

    @Before
    public void beforeEach() {
        System.setProperty("web.driver.chrome", "C:\\Users\\pkom9\\Desktop\\chromedriver_win32");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofMillis(1000));
    }

    @Test
    public void TC17() {
        driver.get("http://easybooks/");
        driver.manage().window().maximize();

        By emailSelector = By.cssSelector("input[formcontrolname=email]");
        wait.until(ExpectedConditions.elementToBeClickable(emailSelector));
        WebElement emailTextBox = driver.findElement(emailSelector);
        emailTextBox.click();
        emailTextBox.sendKeys("test@gmail.com");

        By passwordSelector = By.cssSelector("input[formcontrolname=password]");
        wait.until(ExpectedConditions.elementToBeClickable(passwordSelector));
        WebElement passwordTextBox = driver.findElement(passwordSelector);
        passwordTextBox.click();
        passwordTextBox.sendKeys("test");

        By loginSelector = By.cssSelector(".login-button");
        wait.until(ExpectedConditions.elementToBeClickable(loginSelector));
        WebElement loginButton = driver.findElement(loginSelector);
        loginButton.click();
    }

    @Test
    public void TC22() {
        driver.get("http://easybooks/");
        driver.manage().window().maximize();

        By emailSelector = By.cssSelector("input[formcontrolname=email]");
        wait.until(ExpectedConditions.elementToBeClickable(emailSelector));
        WebElement emailTextBox = driver.findElement(emailSelector);
        emailTextBox.click();
        emailTextBox.sendKeys("test@gmail.com");

        By passwordSelector = By.cssSelector("input[formcontrolname=password]");
        wait.until(ExpectedConditions.elementToBeClickable(passwordSelector));
        WebElement passwordTextBox = driver.findElement(passwordSelector);
        passwordTextBox.click();
        passwordTextBox.sendKeys("test");

        By loginSelector = By.cssSelector(".login-button");
        wait.until(ExpectedConditions.elementToBeClickable(loginSelector));
        WebElement loginButton = driver.findElement(loginSelector);
        loginButton.sendKeys(Keys.ENTER);
    }

    @Test
    public void TC21() {
        driver.get("http://easybooks/");
        driver.manage().window().maximize();

        By emailSelector = By.cssSelector("input[formcontrolname=email]");
        wait.until(ExpectedConditions.elementToBeClickable(emailSelector));
        WebElement emailTextBox = driver.findElement(emailSelector);
        emailTextBox.click();
        emailTextBox.sendKeys("test@gmail.com");

        By passwordSelector = By.cssSelector("input[formcontrolname=password]");
        wait.until(ExpectedConditions.elementToBeClickable(passwordSelector));
        WebElement passwordTextBox = driver.findElement(passwordSelector);
        passwordTextBox.click();
        passwordTextBox.sendKeys("test");

        By loginSelector = By.cssSelector(".login-button");
        wait.until(ExpectedConditions.elementToBeClickable(loginSelector));
        WebElement loginButton = driver.findElement(loginSelector);
        loginButton.click();

        By logoutSelector = By.cssSelector(".logout-icon");
        wait.until(ExpectedConditions.elementToBeClickable(logoutSelector));
        WebElement logoutButton = driver.findElement(logoutSelector);
        logoutButton.click();
    }

    @Test
    public void TC18(){
        driver.get("http://easybooks/");
        driver.manage().window().maximize();

        By emailSelector = By.cssSelector("input[formcontrolname=email]");
        wait.until(ExpectedConditions.elementToBeClickable(emailSelector));
        WebElement emailTextBox = driver.findElement(emailSelector);
        emailTextBox.click();
        emailTextBox.sendKeys("nonexisteeent@gmail.com");

        By passwordSelector = By.cssSelector("input[formcontrolname=password]");
        wait.until(ExpectedConditions.elementToBeClickable(passwordSelector));
        WebElement passwordTextBox = driver.findElement(passwordSelector);
        passwordTextBox.click();
        passwordTextBox.sendKeys("test");

        By loginSelector = By.cssSelector(".login-button");
        wait.until(ExpectedConditions.elementToBeClickable(loginSelector));
        WebElement loginButton = driver.findElement(loginSelector);
        loginButton.click();

        By messageFailSelector = By.cssSelector(".mat-mdc-form-field-error");
        wait.until(ExpectedConditions.visibilityOfElementLocated(messageFailSelector));
        String ActualMessage = driver.findElement(messageFailSelector).getText();
        String ExpectedMessage = ("Niepoprawny adres e-mail i/lub hasło.");
        Assert.assertEquals(ActualMessage, ExpectedMessage);
    }

    @Test
    public void TC19(){
        driver.get("http://easybooks/");
        driver.manage().window().maximize();

        By emailSelector = By.cssSelector("input[formcontrolname=email]");
        wait.until(ExpectedConditions.elementToBeClickable(emailSelector));
        WebElement emailTextBox = driver.findElement(emailSelector);
        emailTextBox.click();
        emailTextBox.sendKeys("test@gmail.com");

        By passwordSelector = By.cssSelector("input[formcontrolname=password]");
        wait.until(ExpectedConditions.elementToBeClickable(passwordSelector));
        WebElement passwordTextBox = driver.findElement(passwordSelector);
        passwordTextBox.click();
        passwordTextBox.sendKeys("wrongpassword");

        By loginSelector = By.cssSelector(".login-button");
        wait.until(ExpectedConditions.elementToBeClickable(loginSelector));
        WebElement loginButton = driver.findElement(loginSelector);
        loginButton.click();

        By messageFailSelector = By.cssSelector(".mat-mdc-form-field-error");
        wait.until(ExpectedConditions.visibilityOfElementLocated(messageFailSelector));
        String ActualMessage = driver.findElement(messageFailSelector).getText();
        String ExpectedMessage = ("Niepoprawny adres e-mail i/lub hasło.");
        Assert.assertEquals(ActualMessage, ExpectedMessage);
    }

    @Test
    public void TC20(){
        driver.get("http://easybooks/");
        driver.manage().window().maximize();

        By emailSelector = By.cssSelector("input[formcontrolname=email]");
        wait.until(ExpectedConditions.elementToBeClickable(emailSelector));
        WebElement emailTextBox = driver.findElement(emailSelector);
        emailTextBox.click();
        emailTextBox.sendKeys("wrongformatgmail.com");

        By passwordSelector = By.cssSelector("input[formcontrolname=password]");
        wait.until(ExpectedConditions.elementToBeClickable(passwordSelector));
        WebElement passwordTextBox = driver.findElement(passwordSelector);
        passwordTextBox.click();
        passwordTextBox.sendKeys("test");

        By loginSelector = By.cssSelector(".login-button");
        wait.until(ExpectedConditions.elementToBeClickable(loginSelector));
        WebElement loginButton = driver.findElement(loginSelector);
        loginButton.click();

        By messageFailSelector = By.cssSelector(".mat-mdc-form-field-error");
        wait.until(ExpectedConditions.visibilityOfElementLocated(messageFailSelector));
        String ActualMessage = driver.findElement(messageFailSelector).getText();
        String ExpectedMessage = ("Niepoprawny adres e-mail i/lub hasło.");
        Assert.assertEquals(ActualMessage, ExpectedMessage);
    }

    @Test
    public void TC6(){
        String newEmail = "newemail1@gmail.com";
        driver.get("http://easybooks/");
        driver.manage().window().maximize();

        By registrationSelector = By.cssSelector(".mat-mdc-button");
        wait.until(ExpectedConditions.elementToBeClickable(registrationSelector));
        WebElement registrationButton = driver.findElement(registrationSelector);
        registrationButton.click();

        By firstNameSelector = By.cssSelector("input[formcontrolname=firstName]");
        wait.until(ExpectedConditions.elementToBeClickable(firstNameSelector));
        WebElement firstNameTextBox = driver.findElement(firstNameSelector);
        firstNameTextBox.click();
        firstNameTextBox.sendKeys("First");

        By lastNameSelector = By.cssSelector("input[formcontrolname=lastName]");
        wait.until(ExpectedConditions.elementToBeClickable(lastNameSelector));
        WebElement lastNameTextBox = driver.findElement(lastNameSelector);
        lastNameTextBox.click();
        lastNameTextBox.sendKeys("Last");

        By emailSelector = By.cssSelector("input[formcontrolname=emailAddress]");
        wait.until(ExpectedConditions.elementToBeClickable(emailSelector));
        WebElement emailTextBox = driver.findElement(emailSelector);
        emailTextBox.click();
        emailTextBox.sendKeys(newEmail);

        By passwordSelector = By.cssSelector("input[formcontrolname=password]");
        wait.until(ExpectedConditions.elementToBeClickable(passwordSelector));
        WebElement passwordTextBox = driver.findElement(passwordSelector);
        passwordTextBox.click();
        passwordTextBox.sendKeys("Newpassword123!");

        By registerButtonSelector = By.cssSelector(".register-button");
        wait.until(ExpectedConditions.elementToBeClickable(registerButtonSelector));
        WebElement registerButton = driver.findElement(registerButtonSelector);
        registerButton.click();

        By messageFailSelector = By.cssSelector("mad-mdc-form-field-error");
        wait.until(ExpectedConditions.visibilityOfElementLocated(messageFailSelector));
        String ActualMessage = driver.findElement(messageFailSelector).getText();
        String ExpectedMessage = ("Użytkownik z podanym adresem email już istnieje.");
        Assert.assertEquals(ActualMessage, ExpectedMessage);

        wait.until(ExpectedConditions.elementToBeClickable(emailSelector));
        emailTextBox.click();
        emailTextBox.clear();
        emailTextBox.sendKeys("1" + newEmail);

        By continueLoginSelector = By.cssSelector(".register-link-button");
        wait.until(ExpectedConditions.elementToBeClickable(continueLoginSelector));
        WebElement continueLoginButton = driver.findElement(continueLoginSelector);
        continueLoginButton.click();
    }

    @After
    public void isItOK() {
        driver.close();
    }
}

