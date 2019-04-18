package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class IsEnabled {
	
	WebDriver driver;
	
	
  @Test
  public void f() throws InterruptedException {
	  
	  driver.get("http://cookbook.seleniumacademy.com/Config.html");
	  
	  WebElement enb=driver.findElement(By.xpath("//input[@name='ledheadlamp']"));
	  enb.isDisplayed();
	 if(!enb.isEnabled()) {
		 System.out.println("Chechbox is not enabled");
	 }
	 
	 WebElement sel=driver.findElement(By.xpath("//input[@name='abs']"));
	if(!sel.isSelected()) {
		sel.click();
		Thread.sleep(3000);
	}
	  
	if(sel.isSelected()) {
		sel.click();
		Thread.sleep(3000);
	}
	
	
	  
	 

	  
	 
	  
	  
	  
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
