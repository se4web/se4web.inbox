package se4web;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Capabilities;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

//import ru.stqa.selenium.factory.WebDriverFactory;
//import ru.stqa.selenium.factory.WebDriverFactoryMode;

import se4web.util.PropertyLoader;
import se4web.util.WebDriverFactory;

/**
 * Base class for TestNG-based test classes
 */
public class TestNgTestBase {

  protected static String gridHubUrl;
  protected static String baseUrl;
  protected static Capabilities capabilities;

  protected WebDriver driver;

  @BeforeSuite
  public void initTestSuite() throws IOException {
    baseUrl = PropertyLoader.loadProperty("site.url");
    gridHubUrl = PropertyLoader.loadProperty("grid.url");
    if ("".equals(gridHubUrl)) {
      gridHubUrl = null;
    }
    capabilities = PropertyLoader.loadCapabilities();
//    WebDriverFactory.setMode(WebDriverFactoryMode.THREADLOCAL_SINGLETON);
  }

  @BeforeMethod
  public void initWebDriver() {
//    driver = ru.stqa.selenium.factory.WebDriverFactory.getDriver(gridHubUrl, capabilities);
//    driver = WebDriverFactory.getDriver(gridHubUrl, capabilities);
    driver = WebDriverFactory.getDriver(gridHubUrl, capabilities);
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() {
    WebDriverFactory.dismissDriver();
  }
}
