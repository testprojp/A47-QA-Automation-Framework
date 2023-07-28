import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllSongsPage;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;


public class Homework23 extends BaseTest
{
//    public Homework23(WebDriver givenDriver)
//    {
//        super(givenDriver);
//    }

//    @Test (dataProvider = "CorrectLoginProvider", dataProviderClass = BaseTest.class)
//    public void deleteAPlaylist(String email, String password)
//    {
//        String deletedPlayListMessage = "Deleted playlist";
//        //accessUrlPage();
//        provideEmailCredentials("james.patterson@testpro.io");
//        providePasswordCredentials("te$t$tudent");
//        loginButton();
//        openPlaylist();
//        clickDeletePlaylistButton();
//        confirmDeletedPlaylistMessage();
//        Assert.assertTrue(getDeletedPlaylistMessage().contains(deletedPlayListMessage));
//    }

//    @Test (dataProvider = "CorrectLoginProvider", dataProviderClass = BaseTest.class)
//    public void createAPlaylist(String email, String password)
//    {
//        String createAPlaylist = "Created playlist ";
//
//        provideEmailCredentials("james.patterson@testpro.io");
//        providePasswordCredentials("te$t$tudent");
//        loginButton();
//
//        clickOnPlusSymbol();
//    }
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
//
//    @Test (dataProvider = "CorrectLoginProvider", dataProviderClass = BaseTest.class)
//    public void countSongsInPlaylist(String email, String password)
//    {
//        //accessUrlPage();
//        provideEmailCredentials("james.patterson@testpro.io");
//        providePasswordCredentials("te$t$tudent");
//        loginButton();
//
//        choosePlaylistByName("Playlist *");
//        displayAllSongs();
//        Assert.assertTrue(getPlaylistDetails().contains(String.valueOf(countSongsInPlaylist())));
//    }
//
//
//
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
        String enterNewPlaylistName = "My New Playlist";
        //accessUrlPage();
        //provideEmailCredentials("james.patterson@testpro.io");
        //providePasswordCredentials("te$t$tudent");
        //loginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        HomePage homePage   = new HomePage(driver);


        homePage.doubleClickPlaylist();
        homePage.enterNewPlaylistName();

        Assert.assertTrue(homePage.doesPlaylistNameExist());
    }
}