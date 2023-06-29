import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

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

        songSearch("Pluto");

        viewAllSongs();

        firstSongSelection();

        addToButton();

        selectedSongAddedToPlaylist();

        //choosePlayList();

        Assert.assertTrue(addedSongMessage().contains(newSongAddedToPlaylistNotification));
    }
}