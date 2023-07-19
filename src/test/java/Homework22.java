import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;




public class Homework22 extends BaseTest
{

//    public Homework22(WebDriver givenDriver)
//    {
//        super(givenDriver);
//    }
//    public class PlaylistTests
//    {
        @Test(dataProvider = "CorrectLoginProvider", dataProviderClass = BaseTest.class)
        public void renamePlaylist(String email, String password)
        {

            String enterNewPlaylistName = "My test playlist";

            LoginPage loginPage = new LoginPage(driver);
            HomePage homePage = new HomePage(driver);

            loginPage.login();

            homePage.doubleClickPlaylist();
            homePage.enterNewPlaylistName();

            Assert.assertTrue(homePage.doesPlaylistNameExist(enterNewPlaylistName));
        }
//    }
}