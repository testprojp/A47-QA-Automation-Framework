
import org.openqa.selenium.WebDriver;
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

        loginPage.login();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }
}
