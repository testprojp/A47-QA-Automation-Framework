import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.crypto.tls.ByteQueueOutputStream;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;


import java.time.Duration;


public class BaseTest {

    public static WebDriver driver = null;
    public static String url = "https://qa.koel.app/";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void accessUrlPage(String BaseURL) {
        //Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        //urlPage();
        url = BaseURL;
        driver.get(url);
    }

    @AfterMethod
    public void closeBrowser() {
        //Closes browser
        driver.quit();
    }

    @DataProvider(name = "IncorrectLoginProviders")
    public static Object[][] getDataFromDataProviders()
    {
        return new Object[][]
                {
                        {"notExisting@email.com", "NotExistingPassword"},
                        {"james@test.com", ""},
                        {"", ""}
                };
    }

    protected static void provideEmailCredentials(String email) {
        //Enters email credentials
        WebElement emailInput = driver.findElement((By.cssSelector("[type='email']")));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    protected static void providePasswordCredentials(String password) {
        //Enters password credentials
        WebElement passwordInput = driver.findElement((By.cssSelector("[type='password']")));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    protected static void loginButton() {
        //Clicks login button
        WebElement loginButton = driver.findElement(By.cssSelector(("button[type='submit']")));
        loginButton.submit();
    }

    protected static void urlPage() {
        //Opens web url page
        String url = "https://qa.koel.app/";
        driver.get(url);
    }

    protected static void avatarIconVisible() {
        //Check if the user avatar is displaying
        WebElement avatar = driver.findElement(By.cssSelector(".avatar"));
        Assert.assertTrue(avatar.isDisplayed());
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
        WebElement playlistToDelete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='playlists']/ul/li[3]/a/text()")));
        playlistToDelete.click();
    }

    public void clickDeletePlaylistButon()
    {
        WebElement deletePlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("#playlistWrapper > header > div.song-list-controls > span > button.del.btn-delete-playlist")));
        deletePlaylist.click();
    }

    public void confirmDeletedPlaylistMessage()
    {
        WebElement playlistDeletedMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.ok")));
        playlistDeletedMsg.click();
    }

    public String getDeletedPlaylistMessage()
    {
         WebElement notificationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.successs.show")));
         return notificationMessage.getText();
    }
}
