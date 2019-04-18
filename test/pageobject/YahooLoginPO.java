package pageobject;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YahooLoginPO extends LoadableComponent<YahooLoginPO>{
	
	private WebDriver driver;
	private WebDriverWait wait;
	@FindBy (id="login-username")
	@CacheLookup
	WebElement username;
	
	@FindBy (id="login-signin")
	@CacheLookup
	WebElement next;
	
	@FindBy (id="login-passwd")
	WebElement password;
	
	@FindBy(id="login-signin")
	WebElement signin;
	
	private String pageTitle = "Yahoo - login";
	
	public YahooLoginPO() {
		
		System.setProperty("webdriver.gecko.driver", "test\\resources\\geckodriver-64bit.exe");
		driver = new FirefoxDriver();
		wait=new WebDriverWait(driver,30);
		driver.manage().window().maximize();
		
		PageFactory.initElements(driver, this);
		
	}
	
	public YahooComposePO doLogin(String id,String pass) throws InterruptedException {
		
		username.clear();
		username.sendKeys(id);
		next.click();
		
		wait.until(ExpectedConditions.visibilityOf(password));
		Thread.sleep(5000);
		password.sendKeys(pass);
		signin.click();
		
		YahooComposePO refPO=new YahooComposePO(driver);
		return refPO;
		
		
	}
	
	public String getPageTitleAfterLogin() {
		return driver.getTitle();
	}
	
	

	@Override
	protected void load() {
		// TODO Auto-generated method stub
		driver.get("http://www.yahoomail.com");
		
		
	}

	@Override
	protected void isLoaded() throws Error {
		
		assertEquals(driver.getTitle(), pageTitle);
		// TODO Auto-generated method stub
		
		
		
	}
	
	

}
