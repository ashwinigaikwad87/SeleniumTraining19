package screenshot;

import org.testng.annotations.Test;

import com.google.common.io.Files;

import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class screenShot {
	
	WebDriver driver;
	TakesScreenshot ts;
	
  @Test
  public void f() throws IOException {
	  
	 try { driver.get("http://www.yahoomail.com");
	  driver.findElement(By.id("login-username-io")).sendKeys("paratus");
	  ts=(TakesScreenshot)driver;
	  File srcFile=ts.getScreenshotAs(OutputType.FILE);
	  Files.copy(srcFile, new File("c:\\tmp1\\main_page_success.png"));
	 }
	 catch(Exception e) {
		 File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 Files.copy(srcFile, new File("c:\\tmp1\\main_page_failure.png"));
	 }
	  
	  
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.gecko.driver", "test\\resources\\geckodriver-64bit.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	  
	  
  }

  @AfterMethod
  public void afterMethod() {
	  
	  driver.quit();
  }

}
