package Page_Factory;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage  extends BasePage {
    public HomePage(WebDriver givenDriver){
        super(givenDriver);
    }

    @FindBy(css = "[href='#!/playlist/99457']")
    WebElement playlistFieldLocator;
    @FindBy(css = "[name='name']")
    WebElement playlistName;

    public HomePage doubleClickPlaylistF() {
        doubleClick(playlistFieldLocator);
        return this;
    }
    public HomePage enterNewPlaylistNameF(String newPlaylistName){
        playlistName.sendKeys(Keys.CONTROL,"a",Keys.BACK_SPACE);
        playlistName.sendKeys(newPlaylistName);
        playlistName.sendKeys(Keys.ENTER);
        return this;

    }
    public String returnPlaylistName(){
        return playlistFieldLocator.getText();
    }
}
