import com.fasterxml.jackson.databind.ser.Serializers;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework19 extends BaseTest
{
    @Test (dataProvider = "CorrectLoginProvider", dataProviderClass = BaseTest.class)
    public void deleteAPlaylist()
    {
        String deletedPlayListMessage = "Deleted Playlist";
        //accessUrlPage();
        provideEmailCredentials(email);
        providePasswordCredentials(password);
        loginButton();
        openPlaylist();
        clickDeletePlaylistButon();
        confirmDeletedPlaylistMessage();
        Assert.assertTrue(getDeletedPlaylistMessage().contains(deletedPlayListMessage));
    }
}