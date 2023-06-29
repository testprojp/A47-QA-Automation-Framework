public class Homework17
{
@Test
    public void addSongToPlaylist()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicityWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app"
        driver.get(url);

    }
}