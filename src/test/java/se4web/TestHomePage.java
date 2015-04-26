package se4web;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import se4web.pages.HomePage;
import se4web.pages.LoginPage;

public class TestHomePage extends TestNgTestBase {

  protected LoginPage loginpage;
  protected HomePage homepage;

  @BeforeMethod
  public void initPageObjects() {
//    loginpage = PageFactory.initElements(driver, LoginPage.class);
    loginpage = new LoginPage(driver, Boolean.TRUE);
    homepage = new HomePage(driver, loginpage);
    homepage.get();
  }

  @Test (priority=1)
  public void testLoginPageHasTitle() {
//    driver.get(baseUrl);
    Assert.assertFalse("".equals(homepage.getTitle()));
  }

  @Test (priority=1)
  public void testAllLinks() {
//    driver.get(baseUrl);
    Assert.assertFalse("".equals(homepage.getTitle()));
  }
}
