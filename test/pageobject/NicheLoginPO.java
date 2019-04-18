package pageobject;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;


	
	public class NicheLoginPO extends LoadableComponent<NicheLoginPO>{

		@FindBy(id="loginname")
		@CacheLookup
		private WebElement username;
		//username = driver.findElement(By.id("loginname"));
		@FindBy (id = "loginpassword")
		@CacheLookup
		private WebElement password;
		
		@FindBy (id = "loginbutton")
		@CacheLookup
		private WebElement submit;
		
		private WebDriver driver;
		private String pageTitle = "STC Tourism";
		
		public NicheLoginPO() {
			System.setProperty("webdriver.gecko.driver", "test\\resources\\geckodriver-64bit.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			PageFactory.initElements(driver, this);
			
		}
		public NicheLoginPO(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);		
		}
		
		public MyAccountPO doLogin(String id, String pass) {
			username.clear();
			username.sendKeys(id);
			password.sendKeys(pass);
			submit.click();
			
			MyAccountPO refPO=new MyAccountPO(driver);
			return refPO;
		}
		
		public String getPageTitleAfterLogin() {
			return driver.getTitle();
		}
		
		

		@Override
		protected void load() {
			// TODO Auto-generated method stub
			driver.get("http://selenium-examples.nichethyself.com/");		
		}

		@Override
		protected void isLoaded() throws Error {
			// TODO Auto-generated method stub
		//	assertEquals(driver.getTitle(),pageTitle);
			assertTrue(driver.getTitle().equals(pageTitle));
		}

		

		public void closeBrowser() {
			
			driver.quit();
			// TODO Auto-generated method stub
			
		}
		
	}



