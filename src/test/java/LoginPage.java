import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private ChromeDriver driver;
    private WebDriverWait wait;

    public LoginPage(ChromeDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void login(String email, String password) {

        By emailSelector = By.cssSelector("input[formcontrolname=email]");
        wait.until(ExpectedConditions.elementToBeClickable(emailSelector));
        WebElement emailTextBox = driver.findElement(emailSelector);
        emailTextBox.click();
        emailTextBox.sendKeys(email);

        By passwordSelector = By.cssSelector("input[formcontrolname=password]");
        wait.until(ExpectedConditions.elementToBeClickable(passwordSelector));
        WebElement passwordTextBox = driver.findElement(passwordSelector);
        passwordTextBox.click();
        passwordTextBox.sendKeys(password);

        By loginSelector = By.cssSelector(".login-button");
        wait.until(ExpectedConditions.elementToBeClickable(loginSelector));
        WebElement loginButton = driver.findElement(loginSelector);
        loginButton.click();
    }

    public void openEasybooks() {
        driver.get("http://easybooks/");
        driver.manage().window().maximize();
    }

    public void fillLoginForm(String email, String password) {
        driver.get("http://easybooks/");
        driver.manage().window().maximize();

        By emailSelector = By.cssSelector("input[formcontrolname=email]");
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

    public void submitLoginWithEnter() {
        By loginSelector = By.cssSelector(".login-button");
        wait.until(ExpectedConditions.elementToBeClickable(loginSelector));
        WebElement loginButton = driver.findElement(loginSelector);
        loginButton.sendKeys(Keys.ENTER);
    }

    public void submitLoginWithMouseClick() {
        By loginSelector = By.cssSelector(".login-button");
        wait.until(ExpectedConditions.elementToBeClickable(loginSelector));
        WebElement loginButton = driver.findElement(loginSelector);
        loginButton.click();
    }

    public void logoutFromService() {
        By logoutSelector = By.cssSelector(".logout-icon");
        wait.until(ExpectedConditions.elementToBeClickable(logoutSelector));
        WebElement logoutButton = driver.findElement(logoutSelector);
        logoutButton.click();
    }

    public void checkIfMessageFail(String failMessage) {
        By messageFailSelector = By.cssSelector(".mat-mdc-form-field-error");
        wait.until(ExpectedConditions.visibilityOfElementLocated(messageFailSelector));
        String ActualMessage = driver.findElement(messageFailSelector).getText();
        String ExpectedMessage = (failMessage);
        Assert.assertEquals(ActualMessage, ExpectedMessage);
    }

    public void goToRegistrationForm() {
        By registrationSelector = By.cssSelector(".mat-mdc-button");
        wait.until(ExpectedConditions.elementToBeClickable(registrationSelector));
        WebElement registrationButton = driver.findElement(registrationSelector);
        registrationButton.click();
    }
}
