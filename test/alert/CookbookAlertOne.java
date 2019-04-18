package alert;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class CookbookAlertOne {
	
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  
	  driver.get("http://www.cookbook.seleniumacademy.com/Alerts.html");
	  
	  driver.findElement(By.id("simple")).click();
	  try {
	  Alert firstalert=driver.switchTo().alert();
	  Thread.sleep(5000);
	  String actualmessage=firstalert.getText();
	  String expectedmessage="Hello! I am an alert box!";
	  assertEquals(actualmessage, expectedmessage);
	  
	  firstalert.accept();
	  
	  Thread.sleep(5000);
	  
	  
	  
	  
  }catch(NoAlertPresentException e){
	  fail("Alert not present");
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
