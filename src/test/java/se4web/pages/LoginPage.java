package se4web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

/**
 * Sample page
 */
public class LoginPage extends Page {

    @FindBy(how = How.ID, using = "Email")
    @CacheLookup
    public WebElement emailTextBox;

    @FindBy(how = How.ID, using = "Passwd")
    @CacheLookup
    public WebElement passwordTextBox;

    @FindBy(how = How.ID, using = "signIn")
    @CacheLookup
    public WebElement signInButton;

/*
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }
*/

    Boolean SHOULD_LOGIN_TO; // if YES then try to login to HomePage with valid credential

    public LoginPage (WebDriver driver, Boolean SHOULD_LOGIN_TO) {
        super(driver);
        this.SHOULD_LOGIN_TO = SHOULD_LOGIN_TO;
    }

    @Override
    protected void isLoaded() throws Error {
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("google"), "Not on the Google login page" + url);
    }

    @Override
    protected void load() {
        driver.get("https://inbox.google.com");

        // if YES then try to login to HomePage with valid credential
        if (this.SHOULD_LOGIN_TO) {
            this.loginTo("se4web@gmail.com", "Se4webSe4web");
        }
    }

    public void setEmailTextBox(String strUserName) {
        emailTextBox.sendKeys(strUserName);
    }

    public void setPasswordTextBox(String password) {
        passwordTextBox.sendKeys(password);
    }

    public void clickSignIn() {
        signInButton.click();
    }

    public void loginTo(String strUserName, String password) {
        this.setEmailTextBox(strUserName);
        this.setPasswordTextBox(password);
        this.clickSignIn();
    }
}
