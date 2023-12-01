package org.example;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertTrue;

public class LoginSteps {
    private WebDriver driver;


    @Given("the user is on the GitHub login page")
    public void userIsOnGitHubLoginPage() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Spectre\\Desktop\\geckodriver.exe");
        // Code to navigate to the login page
        driver = new FirefoxDriver();
        driver.get("https://github.com/login");

    }

    @When("the user enters valid GitHub username and password")
    public void userEntersValidGitHubCredentials() {
        WebElement username=driver.findElement(By.xpath("//*[@id=\"login_field\"]"));
        username.sendKeys("username");
        WebElement password=driver.findElement(By.xpath("//*[@id=\"password\"]"));
        password.sendKeys("password");
        System.out.println("User enters username and password");
    }

    @When("clicks on the login button")
    public void clicksOnLoginButton() {
        // Code to click on the login button
        WebElement loginButton = driver.findElement(By.name("commit"));
        loginButton.click();
    }

    @Then("the user is navigated to the GitHub homepage")
    public void userIsNavigatedToGitHubHomepage() {
        assertTrue(driver.getCurrentUrl().startsWith("https://github.com/"));
        driver.quit();
    }

}