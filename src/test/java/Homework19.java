import com.fasterxml.jackson.databind.ser.Serializers;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework19 extends BaseTest
{
    @Test (dataProvider = "CorrectLoginProvider", dataProviderClass = BaseTest.class)
    public void deleteAPlaylist(String email, String password)
    {
        String deletedPlayListMessage = "Deleted playlist";
        //accessUrlPage();
        provideEmailCredentials("james.patterson@testpro.io");
        providePasswordCredentials("te$t$tudent");
        loginButton();
        openPlaylist();
        clickDeletePlaylistButton();
        confirmDeletedPlaylistMessage();
        Assert.assertTrue(getDeletedPlaylistMessage().contains(deletedPlayListMessage));
    }
}