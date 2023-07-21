package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.internal.BaseTestMethod;

import java.util.List;

public class HomePage extends BasePage
{
    public HomePage(WebDriver givenDriver)
    {
        super(givenDriver);
    }

    By userAvatarIcon = By.cssSelector("img.avatar");

    public WebElement getUserAvatar()

    {
        return findElement(userAvatarIcon);
    }

    //Helper functions to rename playlist

    String enterNewPlaylistName = "My New Playlist";
    public void doubleClickPlaylist()
    {
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        actions.doubleClick(playlistElement).perform();
    }

    public void enterNewPlaylistName()
    {
        WebElement playListInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        playListInputField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        playListInputField.sendKeys(enterNewPlaylistName);
        playListInputField.sendKeys(Keys.ENTER);

    }
    //Helper functions for Homework17 tasks
    public void songSearch(String songTitle) throws InterruptedException {
        //Searches for a song
        WebElement songSearchInput = driver.findElement(By.cssSelector("#searchForm > input[type=search]"));
        songSearchInput.click();
        songSearchInput.clear();
        songSearchInput.sendKeys("Pluto");
        Thread.sleep(5000);
    }

    public void viewAllSongs() throws InterruptedException {
        //Selects View All button
        WebElement viewAllButton = driver.findElement(By.cssSelector("#searchExcerptsWrapper > div > div > section.songs > h1 > button"));
        viewAllButton.click();
        Thread.sleep(5000);
    }

    public void firstSongSelection() throws InterruptedException {
        //Selects first song
        WebElement firstSong = driver.findElement(By.cssSelector("section#songResultsWrapper tr.song-item td.title"));
        firstSong.click();
        Thread.sleep(5000);
    }

    public void addToButton() throws InterruptedException {
        //Clicks AddTo Button
        WebElement addToButton = driver.findElement(By.cssSelector("button.btn-add-to"));
        addToButton.click();
        Thread.sleep(5000);
    }

    public void selectedSongAddedToPlaylist() throws InterruptedException {
        //Adds selected song to playlist
        //Thread.sleep(3000);
        WebElement songPlaylist = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/section[1]/section[11]/header/div[3]/div/section[1]/ul/li[5]"));
        songPlaylist.click();
        Thread.sleep(20000);
    }

    public void choosePlayList() throws InterruptedException {
        WebElement playListElement = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/section[1]/section[11]/header/div[3]/div/section[1]/ul/li[5]"));
        playListElement.click();
    }

    public String addedSongMessage() throws InterruptedException {
        WebElement songAddedMessage = driver.findElement(By.cssSelector("div.alertify-logs.top.right"));
        return songAddedMessage.getText();
    }

    public void homeButton() throws InterruptedException {
        WebElement homeButton = driver.findElement(By.xpath("//*[@class='home active']"));
        homeButton.click();
        Thread.sleep(2000);
    }

    public void playSong() throws InterruptedException {
        WebElement playSong = driver.findElement(By.xpath("//*[@class='fa fa-play']"));
        playSong.click();
        playSong.click();
        Thread.sleep(3000);
    }

    public void clickPlayButton()
    {
        WebElement songPlaying = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        WebElement playSong = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));
        songPlaying.click();
        playSong.click();
    }

    public boolean songPlaying()
    {
        WebElement soundBars = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
        return soundBars.isDisplayed();
    }

    //Helper functions to delete a playlist
    public void openPlaylist()
    {
        //WebElement playlistToDelete = driver.findElement(By.xpath("//*[@id='playlists']/ul/li[3]/a/text()"));
        WebElement playlistToDelete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        playlistToDelete.click();
    }

    public void clickDeletePlaylistButton()
    {
        WebElement deletePlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-delete-playlist")));
        deletePlaylist.click();
    }

    public void confirmDeletedPlaylistMessage()
    {
        WebElement playlistDeletedMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.ok")));
        playlistDeletedMsg.click();
    }

    public String getDeletedPlaylistMessage()
    {
        WebElement notificationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notificationMessage.getText();
    }

    //Double Click Method
    public void doubleClickChoosePlaylist()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        actions.doubleClick(driver.findElement(By.cssSelector(".playlist:nth-child(3)"))).perform();
    }

    //Play song helper functions
    public void chooseAllSongsList()
    {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".overlay.loading")));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li a.songs"))).click();
    }

    public void contextClickFirstSong()
    {
        WebElement firstSongElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".all-songs tr.song-item:nth-child(4)")));
        actions.contextClick(firstSongElement).perform();
    }

    public void choosePlayOption()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.playback"))).click();
    }

    public WebElement hoverPlay()
    {
        WebElement play = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='play-btn']")));
        actions.moveToElement(play).perform();
        return driver.findElement(By.cssSelector("[data-testid='play-btn']"));
    }

    //Counting number of songs in a playlist
    public void choosePlaylistByName(String playlistName)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + playlistName + "')]"))).click();
    }

    public int countSongsInPlaylist()
    {
        return driver.findElements(By.cssSelector("section#playlistWrapper td.title")).size();
    }

    public String getPlaylistDetails()
    {
        return driver.findElement(By.cssSelector("span.meta.text-secondary span.meta")).getText();
    }
    public void displayAllSongs()
    {
        List<WebElement> songList = driver.findElements(By.cssSelector("section#playlistWrapper td.title"));
        System.out.println("Number of Songs Found: " + countSongsInPlaylist());
        for (WebElement e: songList){
            System.out.println(e.getText());
        }
    }

    public boolean doesPlaylistNameExist(String enterNewPlaylistName)
    {
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + enterNewPlaylistName + "')]")));
        return playlistElement.isDisplayed();
    }
}
