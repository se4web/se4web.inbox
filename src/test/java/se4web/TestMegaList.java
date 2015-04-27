package se4web;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import se4web.pages.HomePage;
import se4web.pages.LoginPage;
import se4web.pages.MegaList;

public class TestMegaList extends TestNgTestBase {

  protected LoginPage loginpage;
  protected HomePage homepage;
  protected MegaList megalist;

  @BeforeMethod
  public void initPageObjects() {
//    loginpage = PageFactory.initElements(driver, LoginPage.class);
    loginpage = new LoginPage(driver, Boolean.TRUE);
    homepage = new HomePage(driver, loginpage);
    megalist = new MegaList(driver, homepage);
    megalist.get();
  }

  @Test ()
  public void testSectionToday() {
      megalist.getSectionHeaders();
  }

  @Test ()
  public void testAllLinks() {
     megalist.getMegalist();
  }

}
