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
        registrationPage.submitRegistrationWithMouseClick();
        registrationPage.checkIfMessageFailOnRegistration("Niestety, możesz użyć tylko liter (a-z), cyfr (0-9) i kropki (.)");


    } //fail until Radek makes changes on easybooks, implementing validation on the Email textbox

    @Test
    public void TC7(){
        LoginPage loginPage = new LoginPage(driver, wait);
        RegistrationPage registrationPage = new RegistrationPage(driver, wait);

        loginPage.openEasybooks();
        loginPage.goToRegistrationForm();
        registrationPage.fillRegistrationForm("firstname", "lastname", "test@gmail.com", "Tester123!");
        registrationPage.submitRegistrationWithMouseClick();
        registrationPage.checkIfMessageFailOnRegistration("Użytkownik z podanym adresem email już istnieje.");
    }

    @Test
    public void TC10(){
        LoginPage loginPage = new LoginPage(driver, wait);
        RegistrationPage registrationPage = new RegistrationPage(driver, wait);

        loginPage.openEasybooks();
        loginPage.goToRegistrationForm();
        registrationPage.fillRegistrationForm("Jack", "Potter", "plznakemailł@gmail.com", "Tester123!");
        registrationPage.checkIfMessageFailOnRegistration("Niestety, możesz użyć tylko liter (a-z), cyfr (0-9) i kropki (.).");
    }

    @Test
    public void TC11(){
        LoginPage loginPage = new LoginPage(driver, wait);
        RegistrationPage registrationPage = new RegistrationPage(driver, wait);

        loginPage.openEasybooks();
        loginPage.goToRegistrationForm();
        registrationPage.fillRegistrationForm("Harry", "Potter", "baddformat.com", "Tester123!");
        registrationPage.checkIfMessageFailOnRegistration("Proszę podać poprawny adres e-mail.");
    }

    @Test
    public void TC45(){
        LoginPage loginPage = new LoginPage(driver, wait);
        RegistrationPage registrationPage = new RegistrationPage(driver, wait);

        loginPage.openEasybooks();
        loginPage.goToRegistrationForm();
        registrationPage.fillRegistrationFormWithRandomEmail("Ron", "Weasley", "Tester!!!");
        registrationPage.clickOutsideOfFieldToGetValidation();
        registrationPage.checkIfMessageFailOnRegistration("Hasło musi zawierać co najmniej 8 znaków w tym jedną dużą literę, cyfrę oraz znak specjalny.");
    }

    @Test
    public void TC46(){
        LoginPage loginPage = new LoginPage(driver, wait);
        RegistrationPage registrationPage = new RegistrationPage(driver, wait);

        loginPage.openEasybooks();
        loginPage.goToRegistrationForm();
        registrationPage.fillRegistrationFormWithRandomEmail("Ron", "Weasley", "Tester1234");
        registrationPage.clickOutsideOfFieldToGetValidation();
        registrationPage.checkIfMessageFailOnRegistration("Hasło musi zawierać co najmniej 8 znaków w tym jedną dużą literę, cyfrę oraz znak specjalny.");
    }

    @Test
    public void TC47(){
        LoginPage loginPage = new LoginPage(driver, wait);
        RegistrationPage registrationPage = new RegistrationPage(driver, wait);

        loginPage.openEasybooks();
        loginPage.goToRegistrationForm();
        registrationPage.fillRegistrationFormWithRandomEmail("Ron", "Weasley", "tester123!");
        registrationPage.clickOutsideOfFieldToGetValidation();
        registrationPage.checkIfMessageFailOnRegistration("Hasło musi zawierać co najmniej 8 znaków w tym jedną dużą literę, cyfrę oraz znak specjalny.");
    }

    @Test
    public void TC38(){
        LoginPage loginPage = new LoginPage(driver, wait);
        RegistrationPage registrationPage = new RegistrationPage(driver, wait);

        loginPage.openEasybooks();
        loginPage.goToRegistrationForm();
        registrationPage.fillRegistrationFormWithRandomEmail("Ron!", "Weasley", "Tester123!");
        registrationPage.checkIfMessageFailOnRegistration("Proszę podać prawidłowe imię.");
    }

    @Test
    public void TC39(){
        LoginPage loginPage = new LoginPage(driver, wait);
        RegistrationPage registrationPage = new RegistrationPage(driver, wait);

        loginPage.openEasybooks();
        loginPage.goToRegistrationForm();
        registrationPage.fillRegistrationFormWithRandomEmail("Ron whitechar", "Weasley", "Tester123!");
        registrationPage.checkIfMessageFailOnRegistration("Proszę podać prawidłowe imię.");
    }

    @Test
    public void TC13(){
        LoginPage loginPage = new LoginPage(driver, wait);
        RegistrationPage registrationPage = new RegistrationPage(driver, wait);

        loginPage.openEasybooks();
        loginPage.goToRegistrationForm();
        registrationPage.fillRegistrationFormWithRandomEmail("Ronnumbers12", "Weasley", "Tester123!");
        registrationPage.checkIfMessageFailOnRegistration("Proszę podać prawidłowe imię.");
    }

    @Test
    public void TC8(){
        LoginPage loginPage = new LoginPage(driver, wait);
        RegistrationPage registrationPage = new RegistrationPage(driver, wait);

        loginPage.openEasybooks();
        loginPage.goToRegistrationForm();
        registrationPage.fillRegistrationFormWithRandomEmail("Ronplsignąę", "Weasley", "Tester123!");
        registrationPage.submitRegistrationWithMouseClick();
        registrationPage.goToLogin();


    }

    @Test
    public void TC41(){
        LoginPage loginPage = new LoginPage(driver, wait);
        RegistrationPage registrationPage = new RegistrationPage(driver, wait);

        loginPage.openEasybooks();
        loginPage.goToRegistrationForm();
        registrationPage.fillRegistrationFormWithRandomEmail("Ron", "Weasley!", "Tester123");
        registrationPage.checkIfMessageFailOnRegistration("Proszę podać prawidłowe nazwisko.");
    }

    @Test
    public void TC42(){
        LoginPage loginPage = new LoginPage(driver, wait);
        RegistrationPage registrationPage = new RegistrationPage(driver, wait);

        loginPage.openEasybooks();
        loginPage.goToRegistrationForm();
        registrationPage.fillRegistrationFormWithRandomEmail("Ron", "Weasley whitechar", "Tester123!");
        registrationPage.checkIfMessageFailOnRegistration("Proszę podać prawidłowe nazwisko.");
    }

    @Test
    public void TC14(){
        LoginPage loginPage = new LoginPage(driver, wait);
        RegistrationPage registrationPage = new RegistrationPage(driver, wait);

        loginPage.openEasybooks();
        loginPage.goToRegistrationForm();
        registrationPage.fillRegistrationFormWithRandomEmail("Ron", "Weasley123", "Tester123!");
        registrationPage.checkIfMessageFailOnRegistration("Proszę podać prawidłowe nazwisko.");
    }

    @Test
    public void TC9(){
        LoginPage loginPage = new LoginPage(driver, wait);
        RegistrationPage registrationPage = new RegistrationPage(driver, wait);

        loginPage.openEasybooks();
        loginPage.goToRegistrationForm();
        registrationPage.fillRegistrationFormWithRandomEmail("Ron", "Weasleyąę", "Tester123!");
        registrationPage.submitRegistrationWithMouseClick();
        registrationPage.goToLogin();
    }

    @Test
    public void TC34(){
        LoginPage loginPage = new LoginPage(driver, wait);
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver, wait);

        loginPage.openEasybooks();
        loginPage.login("jadmin@gmail.com", "jadmin");
        adminPanelPage.goToUsersTabAlternative();
        adminPanelPage.goToAddNewEmployeeForm();
        adminPanelPage.fillRegistrationFormWithRandomEmailAdmin("First", "Last", "Tester123!");
        adminPanelPage.submitRegistrationWithMouseClickAdmin();
        adminPanelPage.messageAfterRegister("Użytkownik został dodany.");



    }

    @Test
    public void TC49(){
        LoginPage loginPage = new LoginPage(driver, wait);
        AdminPanelPage adminPanelPage = new AdminPanelPage(driver, wait);

        loginPage.openEasybooks();
        loginPage.login("jadmin@gmail.com", "jadmin");
        adminPanelPage.goToUsersTabAlternative();
        adminPanelPage.goToAddNewEmployeeForm();
        adminPanelPage.fillRegistrationFormWithRandomEmailWithSpecialCharAdmin("Firstname", "Lastname", "Tester123!");
        adminPanelPage.submitRegistrationWithMouseClickAdmin();
        adminPanelPage.messageAfterRegister("Użytkownik został dodany.");
    } //This should have an error message after submitting registration, to be checked and rewritten after fixes from dev

//    @After
//    public void isItOK() {
//        driver.close();
//    }
}

