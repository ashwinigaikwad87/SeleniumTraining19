package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class AssignmentTestNG {
	
	WebDriver driver;
	@BeforeClass
	public void beforefirsttest() {
		System.setProperty("webdriver.gecko.driver", "test\\resources\\geckodriver-64bit.exe");
		 driver=new FirefoxDriver();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
  @Test
  public void firstTestNGTest() throws InterruptedException {
	  
	  driver.get("http://www.yahoomail.com");

		WebElement LoginUser=driver.findElement(By.id("login-username"));
		LoginUser.sendKeys("ashwinigaikwad87");
		driver.findElement(By.id("login-signin")).click();
		//Thread.sleep(5000);
		driver.findElement(By.id("login-passwd")).sendKeys("Target@2019");
		//Thread.sleep(5000);
		driver.findElement(By.id("login-signin")).click();
		
		/*String currenturl=driver.getCurrentUrl();
		if(currenturl=="https://in.yahoo.com/?guccounter=1")
			System.out.println("Login successful !");
		else
			System.out.println("Login unsuccessful");*/
  }
  
 /* @Test
		
		public void googleSearchTest() {
			driver.get("http://www.google.com");
			
			driver.findElement(By.name("q")).sendKeys("Jobs in selenium");
			
		}*/
  
  @BeforeMethod
  public void beforeMethod() {
	  
	  
  }

  @AfterMethod
  public void afterMethod() {
  
  }
  
  @AfterClass
  public void afterLastMethod() {
	  driver.quit();
  
  

}
}
