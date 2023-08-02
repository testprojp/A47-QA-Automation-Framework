import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllSongsPage;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;


public class Homework24 extends BaseTest
{
    @Test
    public void playSong()
    {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongs = new AllSongsPage(driver);

        loginPage.provideEmail("james.patterson@testpro.io");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickLoginButton();

        homePage.chooseAllSongsList();
        allSongs.contextClickFirstSong();
        allSongs.choosePlayOption();

        Assert.assertTrue(allSongs.isSongPlaying());
    }

    @Test
    public void hoverOverPlayButton()
    {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongs = new AllSongsPage(driver);

        loginPage.login();

        homePage.chooseAllSongsList();
        homePage.hoverPlay();

        Assert.assertTrue(homePage.hoverPlay().isDisplayed());
    }

    @Test (dataProvider = "CorrectLoginProvider", dataProviderClass = BaseTest.class)
    public void renamePlaylist(String email, String password)
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();

        //Assert.assertTrue(doesPlaylistNameExist());
    }
}