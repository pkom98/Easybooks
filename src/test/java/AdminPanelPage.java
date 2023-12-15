import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.lang.model.util.Elements;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class AdminPanelPage {

    private ChromeDriver driver;
    private WebDriverWait wait;

    public AdminPanelPage(ChromeDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void goToUsersTab() {
        By usersTabSelector = By.cssSelector(".menu-item:nth-child(2)");
        wait.until(ExpectedConditions.elementToBeClickable(usersTabSelector));
        WebElement users = driver.findElement(usersTabSelector);
        users.click();
    } //GET BACK TO IT, CSSSELECTOR COLLECTIONS

    public void goToUsersTabAlternative() {
        By usersTabSelector = By.cssSelector(".menu-item");
        wait.until(ExpectedConditions.visibilityOfElementLocated(usersTabSelector));
        List<WebElement> listOfElements = driver.findElements(usersTabSelector);
        List<String> elementsInText = new ArrayList<>();
        for (int i = 0; i < listOfElements.size(); i++) {
            elementsInText.add(listOfElements.get(i).getText());
            if (listOfElements.get(i).getText().contains("Użytkownicy")) {
                listOfElements.get(i).click();
                break;
            }
        }


    } // working on it

    public void goToAddNewEmployeeForm() {
        By newEmployeeButtonSelector = By.cssSelector(".mdc-button");
        wait.until(ExpectedConditions.elementToBeClickable(newEmployeeButtonSelector));
        WebElement newEmployee = driver.findElement(newEmployeeButtonSelector);
        newEmployee.click();
    }

    public void fillRegistrationFormWithRandomEmailAdmin(String firstName, String lastName, String password) {
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

    public void fillRegistrationFormWithRandomEmailWithSpecialCharAdmin(String firstName, String lastName, String password) {
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
        emailTextBox.sendKeys("test" + newRandomEmail + "!@gmail.com");

        By passwordSelector = By.cssSelector("input[formcontrolname=password]");
        wait.until(ExpectedConditions.elementToBeClickable(passwordSelector));
        WebElement passwordTextBox = driver.findElement(passwordSelector);
        passwordTextBox.click();
        passwordTextBox.sendKeys(password);
    }

    public void fillRegistrationFormAdmin(String firstName, String lastName, String email, String password) {
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

    public void submitRegistrationWithMouseClickAdmin() {
        By registerButtonSelector = By.cssSelector(".register-button");
        wait.until(ExpectedConditions.elementToBeClickable(registerButtonSelector));
        WebElement registerButton = driver.findElement(registerButtonSelector);
        registerButton.click();
    }

    public void checkMessageAfterRegistration(String okMessage) {
        By messageSelector = By.cssSelector(".mat-mdc-card-content");
        wait.until(ExpectedConditions.visibilityOfElementLocated(messageSelector));
        String ActualMessage = driver.findElement(messageSelector).getText();
        String ExpectedMessage = (okMessage);
        Assert.assertEquals(ActualMessage, ExpectedMessage);
    } //GET BACK TO IT, CSSSELECTOR. THIS DOESNT WORK


    public void messageAfterRegister(String expectedMessage) {
        By elementSelector = By.cssSelector(".mat-mdc-card-content");
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementSelector));
        List<WebElement> listOfElements = driver.findElements(elementSelector);
        List<String> elementsInText = new ArrayList<>();
        boolean expectedMessageFound = false;
        for (int i =0; i < listOfElements.size(); i++){
            elementsInText.add(listOfElements.get(i).getText());
            if (listOfElements.get(i).getText().contains(expectedMessage)){
                expectedMessageFound = true;
                break;
            }
        }
        Assert.assertTrue(expectedMessageFound);
    }
}