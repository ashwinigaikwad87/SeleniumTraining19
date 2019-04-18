package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class BrowserCommands {
	
	WebDriver driver;
	
  @Test
  public void BrowserTest() {
	  
		driver.get("http://selenium-examples.nichethyself.com/");
		
		driver.manage().window().maximize();
		driver.manage().window().getSize();
		
		WebElement loginUserName=driver.findElement(By.id("loginname")); // findElement is in driver class 
		loginUserName.sendKeys("stc123");//send keys is in WebElements
		
		driver.findElement(By.id("loginpassword")).sendKeys("12345");
		driver.findElement(By.id("loginbutton")).click();
		
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		driver.navigate().to("http://www.google.com");
		driver.getPageSource();
		
		
	  
	  
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.gecko.driver", "test\\resources\\geckodriver-64bit.exe");
		driver=new FirefoxDriver();
	  
	  
	  
  }

  @AfterMethod
  public void afterMethod() {
	  
	  driver.quit();
  }

}
