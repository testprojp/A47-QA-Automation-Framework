import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test(dataProvider = "CorrectLoginProviders")
    public void LoginEmptyEmailPasswordTest(String email, String password) {

        //accessUrlPage();
        provideEmailCredentials(email);
        providePasswordCredentials(password);
        loginButton();

//        //Added ChromeOptions argument below to fix websocket error
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//
//        WebDriver driver = new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//        String url = "https://qa.koel.app/";
//        driver.get(url);
//        Assert.assertEquals(driver.getCurrentUrl(), url);
//        driver.quit();
    }

    @Test
    public void loginValidEmailPasswordTest()
    {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();

        loginPage.provideEmail("james.patterson@testpro.io");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickLoginButton();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }
}
