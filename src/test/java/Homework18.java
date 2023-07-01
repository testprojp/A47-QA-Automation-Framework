import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {
    @Test

    public void addSongToPlaylist() throws InterruptedException {
        String newSongAddedToPlaylistNotification = "Added 1 song into";
        //Opens url WebPage
        accessUrlPage();
        //Enters email credentials into webpage Email space
        provideEmailCredentials("james.patterson@testpro.io");
        providePasswordCredentials("te$t$tudent");

        loginButton();

//        songSearch("Pluto");
//
//        viewAllSongs();
//
//        firstSongSelection();
//
//        addToButton();
//
//        selectedSongAddedToPlaylist();
//
//        Assert.assertTrue(addedSongMessage().contains(newSongAddedToPlaylistNotification));
//
//        homeButton();

//        playSong();

        clickPlayButton();

        Assert.assertTrue(songPlaying());

    }
}