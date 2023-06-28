import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {
    @Test

    public void addSongToPlaylist() throws InterruptedException {
        String newSongAddedToPlaylistNotification = "Added 1 song into";
        //Opens url WebPage
        accessUrlPage();
        //Enters email & password credentials into webpage
        provideEmailCredentials("james.patterson@testpro.io");
        providePasswordCredentials("te$t$tudent");

        loginButton();

        songSearch("Take my Hand");

        viewAllSongs();

        firstSongSelection();

        addToButton();

        selectedSongAddedToPlaylist();
        Assert.assertTrue(addedSongMessage().contains(newSongAddedToPlaylistNotification));
    }
}