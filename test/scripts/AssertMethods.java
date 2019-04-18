package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class AssertMethods {
	
	WebDriver driver;
	
  @Test
  public void AssertTest() {
	  
	  driver.get("http://selenium-examples.nichethyself.com/");
	  driver.getCurrentUrl();
	  
	  Assert.assertEquals(driver.getCurrentUrl(), "http://selenium-examples.nichethyself.com/");
	  
	  driver.getTitle();
	  
	  
	  Assert.assertEquals(driver.getTitle(), "STC Tourism1");
	  
	  
		WebElement loginUserName=driver.findElement(By.id("loginname"));  
		loginUserName.sendKeys("stc123");
		
		driver.findElement(By.id("loginpassword")).sendKeys("12345");
		driver.findElement(By.id("loginbutton")).click();
		
		String currenturl= driver.getCurrentUrl();
		
		/*if(currenturl.contains("password"))
			System.out.println("Login successful. Test case passed.");
		else
			System.out.println("Login unsuccessful.Test case failed.");*/
		
		
	  Assert.assertTrue(currenturl.contains("password"));
	  
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
