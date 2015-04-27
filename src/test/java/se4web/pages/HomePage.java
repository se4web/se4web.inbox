package se4web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

import java.util.List;

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
    parent.get();
  }
  //driver.findElement(By.xpath("//div[@class='jL']"));

}
