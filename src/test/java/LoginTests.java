
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;


import java.net.MalformedURLException;

import static pages.BasePage.driver;

public class LoginTests extends BaseTest
{
    public void loginValidEmailPasswordTest() throws MalformedURLException {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        accessUrlPage("https://qa.koel.app/");

        loginPage.login();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }
}
