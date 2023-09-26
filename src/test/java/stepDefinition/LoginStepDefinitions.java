package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.LoginPage;

import java.time.Duration;

import static java.sql.DriverManager.getDriver;
import static pages.BasePage.driver;
import static pages.BasePage.wait;

public class LoginStepDefinitions {
    @Given("I open Login page")
    public void urlPage()
    {
        String url = "https://qa.koel.app/";
        driver.get(url);
    }

    @When("I enter email {string}")
    public void provideEmailCredentials(String email)
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.provideEmail(email);
    }

    @And("I enter password {string}")
    public void providePasswordCredentials(String password)
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.providePassword(password);
    }

    @And("I click submit button")
    public void loginButton()
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginButton();
    }


    @Then("I am logged in")
    public void loginValidation()
    {
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar"))).isDisplayed();
    }

    @Then("I close my browser")
    public void closeBrowser()
    {
        driver.quit();
    }
}
