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

public class ThirdAlertTest {
	WebDriver driver;
  @Test
  public void thirdtest() throws InterruptedException {
	  
	  driver.get("https://the-internet.herokuapp.com/javascript_alerts");
	  driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
	  try {
	  Alert jsalert=driver.switchTo().alert();
	  String actualmessage=jsalert.getText();
	  String expectedmessage="I am a JS prompt";
	  assertEquals(actualmessage, expectedmessage);
	  Thread.sleep(3000);
	  jsalert.sendKeys("Ashwini");
	  Thread.sleep(5000);
	  jsalert.accept();
	  
	  String actualresult=driver.findElement(By.id("result")).getText();
	  String expectedresult="You entered: Ashwini";
	  assertEquals(actualresult, expectedresult);
	  
	  Thread.sleep(5000);
	  
	  
	  
	  
	  
	  
	  
	  
	  }
	  catch(NoAlertPresentException e){
		  fail("No Alert present");
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
