import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework22 extends BaseTest
{
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
//    @Test (dataProvider = "CorrectLoginProvider", dataProviderClass = BaseTest.class)
//    public void playSong(String email, String password)
//    {
//        //accessUrlPage();
//        provideEmailCredentials("james.patterson@testpro.io");
//        providePasswordCredentials("te$t$tudent");
//        loginButton();
//
//        chooseAllSongsList();
//        contextClickFirstSong();
//        choosePlayOption();
//
//        Assert.assertTrue(songPlaying());
//    }
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
//    @Test (dataProvider = "CorrectLoginProvider", dataProviderClass = BaseTest.class)
//    public void hoverOverPlayButton(String email, String password)
//    {
//        //accessUrlPage();
//        provideEmailCredentials("james.patterson@testpro.io");
//        providePasswordCredentials("te$t$tudent");
//        loginButton();
//
//        chooseAllSongsList();
//        hoverPlay();
//        Assert.assertTrue(hoverPlay().isDisplayed());
//    }

    @Test (dataProvider = "CorrectLoginProvider", dataProviderClass = BaseTest.class)
    public void renamePlaylist(String email, String password)
    {
        //accessUrlPage();
        provideEmailCredentials("james.patterson@testpro.io");
        providePasswordCredentials("te$t$tudent");
        loginButton();

        doubleClickPlaylist();
        enterNewPlaylistName();

        Assert.assertTrue(doesPlaylistNameExist());
    }

}