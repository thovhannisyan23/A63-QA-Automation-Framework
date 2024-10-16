package Page_Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver givenDriver){
        super(givenDriver);
    }

    @FindBy(css = "input[type='email']")
    WebElement emailFieldLocator;
    @FindBy(css = "input[type='password']")
    WebElement passwordFieldLocator;
    @FindBy(css = "button[type='submit']")
    WebElement submitBtnLocator;

    public void provideEmailF(String email){
       emailFieldLocator.sendKeys(email);
    }
    public void providePasswordF(String password){
        passwordFieldLocator.sendKeys(password);
    }
    public void clickSubmitBtnF(){
        submitBtnLocator.click();
    }

    public void login(){
        provideEmailF("tatevik.hovhannisyan1@testpro.io");
        providePasswordF("te$t$tudent");
        clickSubmitBtnF();
    }

}
