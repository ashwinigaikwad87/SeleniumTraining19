package pageobject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;

public class NicheLoginTest {

	NicheLoginPO myLoginPo;
	MyAccountPO  myAcctPo;

	@Test
	public void f() {

		myLoginPo.doLogin("stc123", "12345");

		assertEquals(myLoginPo.getPageTitleAfterLogin(), "My account");




	}

  @Test
	public void clickContactUs() {

		myAcctPo	 = myLoginPo.doLogin("stc123", "12345");

		myAcctPo.goToContactUs().signOut().doLogin("stc123", "12345");
		


	}



	@BeforeMethod
	public void beforeMethod() {

		myLoginPo= new NicheLoginPO();
		myLoginPo.get();



	}

	@AfterMethod
	public void afterMethod() {
		myLoginPo.closeBrowser();
	}

}
