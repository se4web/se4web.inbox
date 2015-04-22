package se4web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

/**
 * Sample page
 */
public class HomePage extends Page {

  @FindBy(how = How.TAG_NAME, using = "h1")
  @CacheLookup
  public WebElement header;

  public HomePage(WebDriver webDriver, LoadableComponent<?> parent) {
    super(webDriver, parent);
  }

  @Override
  protected void isLoaded() throws Error {
    String title = driver.getTitle();
    Assert.assertTrue(title.contains("Inbox"), "Not on the Inbox home page");
  }

  @Override
  protected void load() {
//    driver.get("https://inbox.google.com");
    parent.get();
//    parent.loginTo("se4web@gmail.com", "Se4webSe4web");
  }
}
