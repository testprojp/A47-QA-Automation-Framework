package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage
{
    public LoginPage(WebDriver givenDriver)
    {
        super(givenDriver);
    }

    //WebElements
    @FindBy(css = "[type='email']")
    WebElement emailField;
    @FindBy(css = "[type='password']")
    WebElement passwordField;
    @FindBy(css = "button[type='submit']")
    WebElement loginButton;

    public LoginPage provideEmail(String email)
    {
        emailField.sendKeys(email);
        return this;
    }

    public LoginPage providePassword(String password)
    {
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage clickLoginButton()
    {
        loginButton.click();
        return this;
    }

    public void login()
    {
        provideEmail("james.patterson@testpro.io");
        providePassword("te$t$tudent");
        clickLoginButton();
    }
}
