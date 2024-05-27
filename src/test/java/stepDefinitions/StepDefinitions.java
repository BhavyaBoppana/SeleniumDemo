package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import static org.junit.Assert.*;

public class StepDefinitions {
    WebDriver driver;

    @Given("the user is on the Swag Labs login page")
    public void the_user_is_on_the_swag_labs_login_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

    @When("the user enters the username {string} and the password {string}")
    public void the_user_enters_the_username_and_the_password(String username, String password) {
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys(username);
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(password);
    }

    @When("clicks on the login button")
    public void clicks_on_the_login_button() {
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }

    @Then("the user should be redirected to the home page")
    public void the_user_should_be_redirected_to_the_home_page() {
        WebElement productsHeader = driver.findElement(By.className("title"));
        assertTrue(productsHeader.isDisplayed());
        driver.quit();
    }

    @Then("an error message should be displayed")
    public void an_error_message_should_be_displayed() {
        WebElement errorMessage = driver.findElement(By.cssSelector(".error-message-container"));
        assertTrue(errorMessage.isDisplayed());
        driver.quit();
    }
}
