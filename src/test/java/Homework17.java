import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        provideEmail("tatevik.hovhannisyan1@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
        searchForSong("Midnight");
        clickOnFirstSongToAdd();
        createPlaylist();
        Assert.assertEquals("Created playlist \"Test1.\"", returnPopupMessage() );

    }
}
