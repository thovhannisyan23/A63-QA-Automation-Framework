import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class Homework21 extends BaseTest{
    @Test
    public void renamePlaylist() {

        provideEmail("tatevik.hovhannisyan1@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
        doubleClickPlaylist();
        enterNewName();
        Assert.assertEquals(returnPlaylistName(), newPlaylistName);
    }

}
