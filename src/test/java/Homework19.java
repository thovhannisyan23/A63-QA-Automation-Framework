import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class Homework19 extends BaseTest{

    @Test
        public void deletePlaylist() throws InterruptedException {
            provideEmail("tatevik.hovhannisyan1@testpro.io");
            providePassword("te$t$tudent");
            clickSubmit();
            clickOnPlaylist();
            Assert.assertEquals("Delete the playlist \"MyPlaylist\"?", returnDeleteMessage());



    }

}
