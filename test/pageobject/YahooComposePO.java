package pageobject;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class YahooComposePO extends LoadableComponent<YahooComposePO>{
	
	@FindBy (xpath="//a[@data-test-id='compose-button']")
	private WebElement compose;
	
	@FindBy (xpath="//input[@class='select-input react-typeahead-input input-to Z_N ir_0 j_n y_Z2uhb3X q_52qC k_w W_6D6F H_6NIX M_0 b_0 P_SMJKi A_6EqO D_X p_a L_0 B_0']")
	private WebElement to;
	
	@FindBy (xpath="//input[@data-test-id='compose-subject']")
	private WebElement subject;
	
	@FindBy (xpath="//div[@data-test-id=\"rte\"]")
	private WebElement data;
	
	@FindBy (xpath="//span[contains(text(),'Send')]")
	private WebElement send;
	
	WebDriver driver;
	
	private String PageTitle="ashwinigaikwad87@yahoo.com - Yahoo Mail";
	
	public YahooComposePO(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);	
		
	}
	
	public void composeEmail() throws InterruptedException {
		compose.click();
		Thread.sleep(3000);
		to.sendKeys("ask2787@gmail.com");
		subject.sendKeys("Page Object Test");
		Thread.sleep(3000);
		data.sendKeys("Page object test verified");
		send.click();
	}
	
	
	
	
	
	
	

	@Override
	protected void load() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void isLoaded() throws Error {
		assertEquals(driver.getTitle(),PageTitle);
		
		
		// TODO Auto-generated method stub
		
	}
	
	

}
