package pageobject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;

public class YahooLoginTest {
	YahooLoginPO loginPO;
	YahooComposePO composePO;
	
 // @Test
  public void f() throws InterruptedException {
	  
	  loginPO.doLogin("ashwinigaikwad87", "Target@2019");
	  assertEquals(loginPO.getPageTitleAfterLogin(), "ashwinigaikwad87@yahoo.com - Yahoo Mail");
  }
@Test

public void YahooComposeTest() throws InterruptedException {
	
composePO=	loginPO.doLogin("ashwinigaikwad87", "Target@2019");
composePO.composeEmail();
	
}
	  
	  
  
  @BeforeMethod
  public void beforeMethod() {
	  loginPO=new YahooLoginPO();
	  loginPO.get();
	  
	  
  }

  @AfterMethod
  public void afterMethod() {
  }

}
