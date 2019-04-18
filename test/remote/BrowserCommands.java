package remote;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;

public class BrowserCommands {
	
	RemoteWebDriver driver;
	
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
	  //System.setProperty("webdriver.gecko.driver", "test\\resources\\geckodriver-64bit.exe");
		//driver=new FirefoxDriver();
	  DesiredCapabilities caps=new DesiredCapabilities();
	  
	  caps.setBrowserName("firefox");
	  
	  try {
		driver=new RemoteWebDriver(new URL("http://192.168.0.103:4444/wd/hub"),caps);
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  driver.manage().window().maximize();
	  
	  
	  
  }

  @AfterMethod
  public void afterMethod() {
	  
	  driver.quit();
  }

}
