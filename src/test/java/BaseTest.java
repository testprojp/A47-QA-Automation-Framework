import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;


public class BaseTest
{

    public static WebDriver driver = null;

    public static WebDriverWait wait;

    public static Actions actions = null;

    public static String url = null;
    //public static String url = "https://qa.koel.app/";

    public static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>();


    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }



    public static WebDriver pickBrowser(String browser) throws MalformedURLException {
        System.out.println("Browser value:" + browser);
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://172.31.10.135:4444";

        switch (browser)
        {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            case "MSEdge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                return driver = new EdgeDriver(edgeOptions);
            case "grid-edge": //gradle clean test -Dbrowser=grid-edge
                caps.setCapability("browserName", "MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-firefox": //gradle clean test -Dbrowser=grid-firefox
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-chrome": //gradle clean test -Dbrowser=grid-chrome
                //caps.setCapability("browserName", "chrome");
                WebDriverManager.chromedriver().setup();
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "lambda cloud":
                return lambdaTest();
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(chromeOptions);
        }
    }
    @BeforeMethod
    @Parameters({"BaseURL"})
    public void accessUrlPage(String BaseURL) throws MalformedURLException {
        //Added ChromeOptions argument below to fix websocket error
        //driver = pickBrowser(System.getProperty("browser"));

        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--remote-allow-origins=*");

        String browser = System.getProperty("browser");
        System.out.println("Browser value: " + browser);

        threadDriver.set(pickBrowser(System.getProperty("browser")) );
        threadDriver.get().manage().timeouts();

        //driver = new ChromeDriver(options);
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().manage().window().maximize();
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        //urlPage();
        url = BaseURL;
        getDriver().get(url);
        actions = new Actions(getDriver());
    }

    @AfterMethod
    public void closeBrowser() {
        //Closes browser
        getDriver().quit();
        threadDriver.remove();
    }

    public WebDriver getDriver()
    {
        System.out.println("Driver is accessed");
        return threadDriver.get();
    }

    public static WebDriver lambdaTest() throws MalformedURLException
    {
        String hubURL = "https://hub.lambdatest.com/wd/hub";

        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("114.0");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "james.j.patterson.jr");
        ltOptions.put("accessKey", "s7YUHrTgHk8vq4ghofrdCfGpATVvcNaxcpuYuT3Ykj36KEHm2B");
        ltOptions.put("project", "Untitled");
        ltOptions.put("selenium_version", "4.0.0");
        ltOptions.put("w3c", true);
        browserOptions.setCapability("LT:Options", ltOptions);

        return new RemoteWebDriver(new URL(hubURL), browserOptions);
    }

    @DataProvider(name = "CorrectLoginProvider")
    public static Object[][] getDataFromDataProviders()
    {
        return new Object[][]
                {
                        {"james.patterson@testpro.io", "te$t$tudent"},
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

    public static void urlPage()
    {
        //Opens web url page
        String url = "https://qa.koel.app/";
        driver.get(url);
    }

    public static void avatarIconVisible() {
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
        //Thread.sleep(5000);

    }

    public void viewAllSongs() throws InterruptedException {
        //Selects View All button
        WebElement viewAllButton = driver.findElement(By.cssSelector("#searchExcerptsWrapper > div > div > section.songs > h1 > button"));
        viewAllButton.click();
        //Thread.sleep(5000);
    }

    public void firstSongSelection() throws InterruptedException {
        //Selects first song
        WebElement firstSong = driver.findElement(By.cssSelector("section#songResultsWrapper tr.song-item td.title"));
        firstSong.click();
        //Thread.sleep(5000);
    }

    public void addToButton() throws InterruptedException {
        //Clicks AddTo Button
        WebElement addToButton = driver.findElement(By.cssSelector("button.btn-add-to"));
        addToButton.click();
        //Thread.sleep(5000);
    }

    public void selectedSongAddedToPlaylist() throws InterruptedException {
        //Adds selected song to playlist
        //Thread.sleep(3000);
        WebElement songPlaylist = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/section[1]/section[11]/header/div[3]/div/section[1]/ul/li[5]"));
        songPlaylist.click();
        //Thread.sleep(20000);
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
        //Thread.sleep(2000);
    }

    public void playSong() throws InterruptedException {
        WebElement playSong = driver.findElement(By.xpath("//*[@class='fa fa-play']"));
        playSong.click();
        playSong.click();
        //Thread.sleep(3000);
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
//    public void chooseAllSongsList()
//    {
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".overlay.loading")));
//        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li a.songs"))).click();
//    }

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
        WebElement play = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("[data-testid='play-btn']")));
        actions.moveToElement(play).perform();
        return driver.findElement(By.xpath("[data-testid='play-btn']"));
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

    public boolean doesPlaylistNameExist()
    {
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + enterNewPlaylistName + "')]")));
        return playlistElement.isDisplayed();
    }

}
