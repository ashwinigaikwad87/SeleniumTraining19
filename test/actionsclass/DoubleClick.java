package actionsclass;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

public class DoubleClick {
	
	WebDriver driver;
	
  @Test
  public void f() throws InterruptedException {
	  
	  driver.get("http://only-testing-blog.blogspot.in/2014/09/selectable.html");
	  
	WebElement myalert = driver.findElement(By.xpath("//button[@ondblclick='myFunction()']"));
	try {
	Actions builder=new Actions(driver);
	
	builder.doubleClick(myalert).perform();
    Thread.sleep(3000);
	
	Alert myalerts=driver.switchTo().alert();
	String actualmessage=myalerts.getText();
	  String expectedmessage="You double clicked me.. Thank You..";
	  assertEquals(actualmessage, expectedmessage);
	  
	  myalerts.accept();
	}
	catch(NoAlertPresentException e) {
		fail("No such alert present");
		
	}
	
	
	  
	  
  }
  
  
  @BeforeMethod
  public void beforeMethod() {
	  
	  System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
		 driver=new ChromeDriver();
  }

  @AfterMethod
  public void afterMethod() {
	  
	  driver.quit();
  }

}
