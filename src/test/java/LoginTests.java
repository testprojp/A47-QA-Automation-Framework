
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;



public class LoginTests extends BasePage
{
    public LoginTests(WebDriver givenDriver)
    {
        super(givenDriver);
    }
    @Test
    public void loginValidEmailPasswordTest()
    {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("james.patterson@testpro.io").providePassword("te$t$tudent").clickLoginButton();


        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }
}
