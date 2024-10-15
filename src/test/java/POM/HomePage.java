package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class HomePage extends BasePage {
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    By playlistField = By.cssSelector("[href='#!/playlist/99457']");
    By playlistName = By.cssSelector("[name='name']");


    public void doubleClickPlaylist() {
    doubleClick(playlistField);
}

    public void enterNewPlaylistName(String newPlaylistName){
    findElement(playlistName).sendKeys(Keys.CONTROL,"a",Keys.BACK_SPACE);
    findElement(playlistName).sendKeys(newPlaylistName);
    findElement(playlistName).sendKeys(Keys.ENTER);
    }
    public String returnPlaylistName(){
        return findElement(playlistField).getText();
    }

}

