package se4web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import java.util.List;

/**
 * Abstract class representation of a Page in the UI. Page object pattern
 */
public abstract class Page extends LoadableComponent<Page> {

  protected WebDriver driver;
  protected final LoadableComponent<?> parent;

//  protected final LoadableComponent<?> parent;

  /*
   * Constructor injecting the WebDriver interface
   * 
   * @param webDriver
   */
  public Page(WebDriver driver, LoadableComponent<?> parent) {
    this.driver = driver;
    this.parent = parent;

    PageFactory.initElements(driver, this);
  }

  public Page(WebDriver driver) {
    this.driver = driver;
    this.parent = null;

    PageFactory.initElements(driver, this);
  }

  public String getTitle() {
    return driver.getTitle();
  }

  public void getAllLinks() {
    List<WebElement> no = driver.findElements(By.tagName("a"));
    int nooflinks = no.size();
    System.out.println("Number of links: " + nooflinks);
    for (WebElement pagelink : no) {
      String linktext = pagelink.getText();
      String link = pagelink.getAttribute("href");
      System.out.println(linktext+" ->");
      System.out.println(link);
    }
  }

  public void HighlighMyElement(WebElement element) {
    for (int i = 0; i < 5; i++) {
      JavascriptExecutor javascript = (JavascriptExecutor) driver;
      javascript.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: orange; border: 4px solid green;");
//      javascript.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: orange; border: 4px solid orange;");
//      javascript.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: pink; border: 4px solid pink;");
//      javascript.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: yellow; border: 4px solid yellow;");
      javascript.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
    }
  }

}
