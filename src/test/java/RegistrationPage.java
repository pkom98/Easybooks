import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Instant;

public class RegistrationPage {


    private ChromeDriver driver;
    private WebDriverWait wait;

    public RegistrationPage(ChromeDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }


    public void fillRegistrationFormWithRandomEmail(String firstName, String lastName, String password){
        By firstNameSelector = By.cssSelector("input[formcontrolname=firstName]");
        wait.until(ExpectedConditions.elementToBeClickable(firstNameSelector));
        WebElement firstNameTextBox = driver.findElement(firstNameSelector);
        firstNameTextBox.click();
        firstNameTextBox.sendKeys(firstName);

        By lastNameSelector = By.cssSelector("input[formcontrolname=lastName]");
        wait.until(ExpectedConditions.elementToBeClickable(lastNameSelector));
        WebElement lastNameTextBox = driver.findElement(lastNameSelector);
        lastNameTextBox.click();
        lastNameTextBox.sendKeys(lastName);

        Instant instant = Instant.now();
        long epochValue = instant.getEpochSecond();
        String newRandomEmail = String.valueOf(epochValue);
        By emailSelector = By.cssSelector("input[formcontrolname=emailAddress]");
        wait.until(ExpectedConditions.elementToBeClickable(emailSelector));
        WebElement emailTextBox = driver.findElement(emailSelector);
        emailTextBox.click();
        emailTextBox.sendKeys("test" + newRandomEmail + "@gmail.com");

        By passwordSelector = By.cssSelector("input[formcontrolname=password]");
        wait.until(ExpectedConditions.elementToBeClickable(passwordSelector));
        WebElement passwordTextBox = driver.findElement(passwordSelector);
        passwordTextBox.click();
        passwordTextBox.sendKeys(password);
    }

    public void fillRegistrationForm(String firstName, String lastName, String email, String password){
        By firstNameSelector = By.cssSelector("input[formcontrolname=firstName]");
        wait.until(ExpectedConditions.elementToBeClickable(firstNameSelector));
        WebElement firstNameTextBox = driver.findElement(firstNameSelector);
        firstNameTextBox.click();
        firstNameTextBox.sendKeys(firstName);

        By lastNameSelector = By.cssSelector("input[formcontrolname=lastName]");
        wait.until(ExpectedConditions.elementToBeClickable(lastNameSelector));
        WebElement lastNameTextBox = driver.findElement(lastNameSelector);
        lastNameTextBox.click();
        lastNameTextBox.sendKeys(lastName);


        By emailSelector = By.cssSelector("input[formcontrolname=emailAddress]");
        wait.until(ExpectedConditions.elementToBeClickable(emailSelector));
        WebElement emailTextBox = driver.findElement(emailSelector);
        emailTextBox.click();
        emailTextBox.sendKeys(email);

        By passwordSelector = By.cssSelector("input[formcontrolname=password]");
        wait.until(ExpectedConditions.elementToBeClickable(passwordSelector));
        WebElement passwordTextBox = driver.findElement(passwordSelector);
        passwordTextBox.click();
        passwordTextBox.sendKeys(password);
    }

    public void submitRegistrationWithMouseClick(){
        By registerButtonSelector = By.cssSelector(".register-button");
        wait.until(ExpectedConditions.elementToBeClickable(registerButtonSelector));
        WebElement registerButton = driver.findElement(registerButtonSelector);
        registerButton.click();
    }

    public void submitRegistrationWithEnter(){
        By registerButtonSelector = By.cssSelector(".register-button");
        wait.until(ExpectedConditions.elementToBeClickable(registerButtonSelector));
        WebElement registerButton = driver.findElement(registerButtonSelector);
        registerButton.sendKeys(Keys.ENTER);
    }

    public void checkIfMessageFailEmail(String failMessage){
        By messageFailSelector = By.cssSelector(".mat-mdc-form-field-error");
        wait.until(ExpectedConditions.visibilityOfElementLocated(messageFailSelector));
        String ActualMessage = driver.findElement(messageFailSelector).getText();
        String ExpectedMessage = (failMessage);
        Assert.assertEquals(ActualMessage, ExpectedMessage);
    }
}
