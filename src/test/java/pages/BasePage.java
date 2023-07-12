package pages;

import com.sun.source.tree.PackageTree;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BasePage
{
    By overLayLocator = By.cssSelector(".overlay.loading");
    public static WebDriver driver = null;
    public static WebDriverWait wait = null;
    public static Actions actions = null;
    public static String url = null;

    public BasePage (WebDriver givenDriver)
    {
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }
    public WebElement findElement(By locator)
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void contextClick(By locator)
    {
        WebElement contextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        actions.contextClick(contextElement).perform();
    }
    public void hoverAction(By locator)
    {
        WebElement play = driver.findElement(locator);
        actions.moveToElement(play).perform();
    }

    public void waitForOverlayDisappear()
    {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(overLayLocator));
    }
}

