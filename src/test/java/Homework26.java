import Page_Factory.HomePage;
import Page_Factory.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework26 extends BaseTest{

    @Test
    public void renamePlaylistF(){

        String newPlaylistName = "Edited Playlist Name3";


        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.login();
        homePage.doubleClickPlaylistF()
                .enterNewPlaylistNameF(newPlaylistName);

        Assert.assertEquals(homePage.returnPlaylistName(), newPlaylistName);


    }
}