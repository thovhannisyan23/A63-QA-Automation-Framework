import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.UUID;


public class BaseTest {

    public WebDriver driver;
    public String url = "https://qa.koel.app/";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    public void lunchClass() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        navigateToURL();
    }
   @AfterMethod
   public void closeBrowser() {
        driver.quit();
   }


    public void navigateToURL() throws InterruptedException {
        driver.get(url);
        Thread.sleep(2000);

    }

    public void provideEmail(String email) throws InterruptedException {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
        Thread.sleep(2000);
    }
    public void providePassword(String password) throws InterruptedException {
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
        Thread.sleep(2000);

    }


    public void searchForSong(String songName) throws InterruptedException {
        WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));
        searchField.clear();
        searchField.sendKeys(songName);
        WebElement viewAllField = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        viewAllField.click();
        Thread.sleep(2000);

    }

    public void clickOnFirstSongToAdd() throws InterruptedException {
        WebElement firstSong = driver.findElement(By.cssSelector("#songResultsWrapper > div > div > div.item-container > table > tr > td.title"));
        firstSong.click();
        WebElement addTo = driver.findElement(By.cssSelector(".btn-add-to"));
        addTo.click();
        Thread.sleep(2000);
    }


    public void clickSubmit() throws InterruptedException {
        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();
        Thread.sleep(2000);

    }
    public void createPlaylist() {
        WebElement newPlaylistName = driver.findElement(By.cssSelector("#songResultsWrapper .add-to input[data-test='new-playlist-name']"));
        newPlaylistName.sendKeys("Test1");

        WebElement submitPlaylistName = driver.findElement(By.cssSelector("#songResultsWrapper .add-to button[type='submit']"));
        submitPlaylistName.click();

    }

    public String returnPopupMessage(){

        WebElement popup = driver.findElement(By.cssSelector("div.success.show"));
        return popup.getText();
    }


}