package se4web;

import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import se4web.pages.HomePage;
import se4web.pages.LoginPage;

public class TestLoginPage extends TestNgTestBase {

  private LoginPage loginpage;
  private HomePage homepage;

  @BeforeMethod
  public void initPageObjects() {
//    loginpage = PageFactory.initElements(driver, LoginPage.class);
    loginpage = new LoginPage(driver, Boolean.FALSE);
    loginpage.get();
  }

  @Test (groups = { "beforeSignIn" } )
  public void testLoginPageHasTitle() {
//    driver.get(baseUrl);
    Assert.assertFalse("".equals(loginpage.getTitle()));
  }

  @Test (groups = { "beforeSignIn" } )
  public void testSignInButtonDisplayed() {
//    driver.get(baseUrl);
    Assert.assertTrue(loginpage.signInButton.isDisplayed());
  }

  @Test (groups = { "beforeSignIn" } )
  public void testSignInButtonEnabled() {
//    driver.get(baseUrl);
    Assert.assertTrue(loginpage.signInButton.isEnabled());
  }

  @Test (dependsOnGroups = { "beforeSignIn" } , groups = { "SignIn" } )
  public void testLoginWrongCredentials() {
//    driver.get(baseUrl);
    loginpage.loginTo("wrongLogin", "wrongPassword");
  }

  @Test (dependsOnMethods = {"testLoginWrongCredentials"} , dependsOnGroups = { "beforeSignIn" } , groups = { "SignIn" } )
  public void testLoginRightCredentials() {
    driver.get(baseUrl);

    loginpage.loginTo("se4web@gmail.com", "Se4webSe4web");

/*    homepage = new HomePage(driver);
    System.out.println(homepage.getTitle());
    Assert.assertTrue("Inbox".equals(homepage.getTitle()));
*/
   }
}
