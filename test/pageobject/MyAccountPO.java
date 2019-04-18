package pageobject;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class MyAccountPO extends LoadableComponent<MyAccountPO> {

	@FindBy (partialLinkText = "Sign out")
	private WebElement signOut;
	
	@FindBy (className = "link")
	private WebElement contactUs;
	
	private WebDriver driver;
	private String pageTitle = "My account";
	
	public MyAccountPO(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	public MyAccountPO goToContactUs() {
		contactUs.click();
		return this;
	}
	
	public NicheLoginPO signOut() {
		signOut.click();
		NicheLoginPO loginPO = new NicheLoginPO(driver);
		return loginPO;
	}
		
	@Override
	protected void load() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub
		assertEquals(driver.getTitle(),pageTitle);
	}

}

