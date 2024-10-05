import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework18 extends BaseTest {

@Test
    public void playSong() throws InterruptedException {
    provideEmail("tatevik.hovhannisyan1@testpro.io");
    providePassword("te$t$tudent");
    clickSubmit();
    clickNextSongBtn();
    clickPlayBtn();
    WebElement soundBar = driver.findElement(By.cssSelector("[data-test=\"soundbars\"]"));
    Assert.assertTrue(soundBar.isDisplayed());

}

}
