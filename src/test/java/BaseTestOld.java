import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;
import java.util.UUID;


public class BaseTestOld {

    public static  WebDriver driver;
    public static String url ;
    public static WebDriverWait wait ;
    public static Actions actions ;
    String newPlaylistName = "New Name";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod

    @Parameters({"BaseURL"})
    public void lunchClass(String BaseURL) throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        //driver = new ChromeDriver(options);
        driver = pickBrowser(System.getProperty("browser"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        actions = new Actions(driver);
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


    public static WebDriver pickBrowser(String browser) throws MalformedURLException{
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.0.158:4444";

        switch (browser){
            case "firefox" :
                WebDriverManager.firefoxdriver().setup();
                //     FirefoxOptions firefoxOptions = new FirefoxOptions();
                //     firefoxOptions.addArguments("--remote-allow-origins=*");
                return driver = new FirefoxDriver();
            case "MicrosoftEdge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                return driver = new EdgeDriver();
            case "grid-edge":
                caps.setCapability("browserName","MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-firefox":
                caps.setCapability("browserName","firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-chrome":
                caps.setCapability("browserName","chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            default:
                WebDriverManager.chromedriver().setup();

                return driver = new ChromeDriver();
        }

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

    public void doubleClickPlaylist() {


        WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[href='#!/playlist/99457']")));
        actions.doubleClick(playlist).perform();


    }
    public void enterNewName(){

        WebElement playlistInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        playlistInput.sendKeys(Keys.CONTROL, "A", Keys.BACK_SPACE);
        playlistInput.sendKeys(newPlaylistName);
        playlistInput.sendKeys(Keys.ENTER);

    }

    public String returnPlaylistName(){
        WebElement playlistName = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[href='#!/playlist/99457']")));
        return playlistName.getText();
    }
}