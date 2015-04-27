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
public class MegaList extends Page {

  @FindBy(how = How.CLASS_NAME, using = "tu")
  public WebElement megalistBox;

  @FindBy(how = How.CLASS_NAME, using = "jL")
  public List<WebElement> itemList;

  @FindBy(how = How.CLASS_NAME, using = "af-b4-bK")
  public List<WebElement> sectionHeaders;

//  driver.findElement(By.xpath("//span[contains(@jstcache,'238')]"));
//  driver.findElement(By.xpath("//span[@jstcache='238']"));

  public MegaList(WebDriver webDriver, LoadableComponent<?> parent) {
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

  public void getSectionHeaders() {
    System.out.println("headers q-ty : " + sectionHeaders.size());
    int i = 0;
    for (WebElement sectionHeader : sectionHeaders) {
      System.out.println(++i + ")" + sectionHeader.getText());
    }
  }

  public void getMegalist() {
    System.out.println("megalist size : " + itemList.size());
    int i = 0;
    for (WebElement item : itemList) {
      System.out.println(++i + ")" + item.getText());
      System.out.println();
    }
  }
}
