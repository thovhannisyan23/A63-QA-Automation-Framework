package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginStepDefinition {
        WebDriver driver;
        WebDriverWait wait;

        @Before("I open browser")
        public void openBrowser(){
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            driver = new ChromeDriver(options);
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }

    @Given("I open Koel login page")
    public void iOpenKoelLoginPage() {
            String url = "https://qa.koel.app/";
            driver.get(url);
    }

    @When("I enter email {string}")
    public void iEnterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']"))).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']"))).sendKeys(email);
    }

    @And("I enter password {string}")
    public void iEnterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']"))).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']"))).sendKeys(password);
    }


    @And("I click submit")
    public void iClickSubmit() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']"))).click();
    }

    @Then("I am logged in")
    public void iAmLoggedIn() {
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar"))).isDisplayed());
    }

    @After
    public void close() {
            driver.quit();
    }
}
