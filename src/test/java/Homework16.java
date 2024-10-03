import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16 extends BaseTest {
    @Test

    public void RegistrationNavigation() throws InterruptedException {
        navigateToURL();

        String url = "https://qa.koel.app/";
        driver.get(url);
        WebElement regLink = driver.findElement(By.cssSelector("a[href='registration']"));
        regLink.click();

        String regURL = "https://qa.koel.app/registration";
        Assert.assertEquals(driver.getCurrentUrl(), regURL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.quit();


    }
}
