import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import java.time.Duration;


public class BaseTest
{

    public static WebDriver driver = null;
    public static String url = "https://qa.koel.app/";

    @BeforeSuite
    static void setupClass()
    {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void accessUrlPage()
    {
        //Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        urlPage();
    }

    @AfterMethod
    public void closeBrowser()
    {
        //Closes browser
        driver.quit();
    }

    protected static void loginButton()
    {
        //Clicks login button
        WebElement loginButton = driver.findElement(By.cssSelector(("button[type='submit']")));
        loginButton.submit();
    }

    protected static void provideEmailCredentials(String email)
    {
        //Enters email credentials
        WebElement emailInput = driver.findElement((By.cssSelector("[type='email']")));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);
    }
    protected static void providePasswordCredentials(String password)
    {
        //Enters password credentials
        WebElement passwordInput = driver.findElement((By.cssSelector("[type='password']")));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    protected static void urlPage()
    {
        //Opens web url page
        String url = "https://qa.koel.app/";
        driver.get(url);
    }

    protected static void avatarIconVisible()
    {
        //Check if the user avatar is displaying
        WebElement avatar = driver.findElement(By.cssSelector(".avatar"));
        Assert.assertTrue(avatar.isDisplayed());
    }

    //Helper functions for Homework17 tasks
    public void songSearch(String songTitle) throws InterruptedException
    {
        //Searches for a song
        WebElement songSearchInput = driver.findElement(By.cssSelector("#searchForm > input[type=search]"));
        songSearchInput.click();
        songSearchInput.clear();
        songSearchInput.sendKeys("Take my Hand");
        Thread.sleep(5000);
    }

    public void viewAllSongs() throws InterruptedException
    {
        //Selects View All button
        WebElement viewAllButton = driver.findElement(By.cssSelector("#searchExcerptsWrapper > div > div > section.songs > h1 > button"));
        viewAllButton.click();
        Thread.sleep(5000);
    }

    public void firstSongSelection() throws InterruptedException
    {
        //Selects first song
        WebElement firstSong = driver.findElement(By.cssSelector("section#songResultsWrapper tr.song-item td.title"));
        firstSong.click();
        Thread.sleep(5000);
    }

    public void addToButton() throws InterruptedException
    {
        //Clicks AddTo Button
        WebElement addToButton = driver.findElement(By.cssSelector("button.btn-add-to"));
        addToButton.click();
        Thread.sleep(5000);
    }

    public void selectedSongAddedToPlaylist() throws InterruptedException
    {
        //Adds selected song to playlist
        WebElement songPlaylist = driver.findElement(By.xpath("//*[@id='recentlyPlayedWrapper']/header/div[3]/div/section[1]/ul/li[6]"));
        songPlaylist.click();
        Thread.sleep(20000);
    }

    public String addedSongMessage() throws InterruptedException
    {
        //return songAddedMessage.getText();
        WebElement songAddedMessage = driver.findElement(By.cssSelector("div.alertify-logs.top.right"));
        return songAddedMessage.getText();
    }

}



