import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import java.time.Duration;


public class BaseTest
{

    public static WebDriver driver = null;

    public static WebDriverWait wait = null;

    public static Actions actions = null;

    public static String url = null;
    //public static String url = "https://qa.koel.app/";



    @BeforeSuite
    static void setupClass()
    {
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
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //urlPage();
        url = BaseURL;
        driver.get(url);

        actions = new Actions(driver);
    }

    @AfterMethod
    public void closeBrowser() {
        //Closes browser
        driver.quit();
    }

    @DataProvider(name = "CorrectLoginProvider")
    public static Object[][] getDataFromDataProviders()
    {
        return new Object[][]
                {
                        {"james.patterson@testpro.io", "te$t$tudent"},
                };
    }

//    protected static void provideEmailCredentials(String email) {
//        //Enters email credentials
//        WebElement emailInput = driver.findElement((By.cssSelector("[type='email']")));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys(email);
//    }

//    protected static void providePasswordCredentials(String password) {
//        //Enters password credentials
//        WebElement passwordInput = driver.findElement((By.cssSelector("[type='password']")));
//        passwordInput.click();
//        passwordInput.clear();
//        passwordInput.sendKeys(password);
//    }

//    protected static void loginButton() {
//        //Clicks login button
//        WebElement loginButton = driver.findElement(By.cssSelector(("button[type='submit']")));
//        loginButton.submit();
//    }
//
//    protected static void urlPage() {
//        //Opens web url page
//        String url = "https://qa.koel.app/";
//        driver.get(url);
//    }

//    protected static void avatarIconVisible() {
//        //Check if the user avatar is displaying
//        WebElement avatar = driver.findElement(By.cssSelector(".avatar"));
//        Assert.assertTrue(avatar.isDisplayed());
//    }
}
