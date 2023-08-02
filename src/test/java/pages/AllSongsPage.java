package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AllSongsPage extends BasePage
{
    public AllSongsPage(WebDriver givenDriver)
    {
        super(givenDriver);
    }

    By firstSong = By.cssSelector(".all-songs tr.song-item:nth-child(1)");
    By playSong = By.cssSelector("li.playback");
    By soundBar = By.xpath("//*[@id='mainFooter']/div[2]/div[2]/div/button[1]/div");

    //play song functions
    public void contextClickFirstSong()
    {
        contextClick(firstSong);
    }
    public void choosePlayOption()
    {
        findElement(playSong).click();
    }
    public Boolean isSongPlaying()
    {
        return findElement(soundBar).isDisplayed();
    }
}
