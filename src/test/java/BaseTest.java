import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.UUID;


public class BaseTest {

    public WebDriver driver;
    public String url ;
    public WebDriverWait wait ;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    @Parameters({"BaseURL"})
    public void lunchClass(String BaseURL) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        url = BaseURL;
        navigateToURL();
    }

   @AfterMethod
   public void closeBrowser() {
        driver.quit();
   }


    public void navigateToURL()  {
        driver.get(url);
    }

    public void provideEmail(String email)  {
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='email']")));
        emailField.clear();
        emailField.sendKeys(email);

    }
    public void providePassword(String password)  {
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='password']")));
        passwordField.clear();
        passwordField.sendKeys(password);

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


    public void clickSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']"))).click();
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

    public String returnDeleteMessage(){

        WebElement popup = driver.findElement(By.cssSelector("p.msg"));
        return popup.getText();
    }

    public void clickNextSongBtn() {

        WebElement nextSong1 = driver.findElement(By.cssSelector("i[data-testid=\"play-next-btn\"]"));
        nextSong1.click();   }
    public void clickPlayBtn() {

        WebElement playBtn = driver.findElement(By.cssSelector("[data-testid=\"play-btn\"]"));
        playBtn.click();   }

    public void clickOnPlaylist()  {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[href='#!/playlist/99457']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".del"))).click();

    }

}