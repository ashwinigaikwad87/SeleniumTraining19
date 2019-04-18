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

public class CookbookAlertThree {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  
driver.get("http://www.cookbook.seleniumacademy.com/Alerts.html");
	  
	  driver.findElement(By.id("prompt")).click();
	  try {
	  Alert thirdalert=driver.switchTo().alert();
	  Thread.sleep(5000);
	  String actualmessage=thirdalert.getText();
	  String expectedmessage="Please enter your name";
	  assertEquals(actualmessage, expectedmessage);
	  thirdalert.sendKeys("Ashwini");
	  thirdalert.accept();
	  
	  Thread.sleep(5000);
	  
	  String actualresult=driver.findElement(By.id("prompt_demo")).getText();
	  String expectedresult="Hello Ashwini! How are you today?";
	  assertEquals(actualresult, expectedresult);
	  
	  
	  
	  
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
