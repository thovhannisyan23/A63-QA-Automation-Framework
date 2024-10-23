import Page_Factory.HomePage;
import Page_Factory.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework23 extends BaseTest{

    @Test
    public void renamePlaylistF(){

        String newPlaylistName = "Edited Playlist Name3";


        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();
        homePage.doubleClickPlaylistF()
                .enterNewPlaylistNameF(newPlaylistName);

        Assert.assertEquals(homePage.returnPlaylistName(), newPlaylistName);


    }
}