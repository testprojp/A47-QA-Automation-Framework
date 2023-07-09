
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;


import static pages.BasePage.driver;

public class LoginTests extends BaseTest
{
    @Test
    public void loginValidEmailPasswordTest()
    {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }
}
