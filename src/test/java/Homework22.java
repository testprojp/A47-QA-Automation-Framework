import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;




public class Homework22 extends BaseTest
{
        @Test(dataProvider = "CorrectLoginProvider", dataProviderClass = BaseTest.class)
        public void renamePlaylist(String email, String password)
        {

            String enterNewPlaylistName = "My New Playlist";

            LoginPage loginPage = new LoginPage(driver);
            HomePage homePage = new HomePage(driver);

            loginPage.login();

            homePage.doubleClickPlaylist();
            homePage.enterNewPlaylistName();

            Assert.assertTrue(homePage.doesPlaylistNameExist(enterNewPlaylistName));
        }
}