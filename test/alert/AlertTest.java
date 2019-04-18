package alert;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class AlertTest {
	WebDriver driver;
	
  @Test
  public void first() throws InterruptedException {
	  
	  driver.get("https://the-internet.herokuapp.com/javascript_alerts");
	  driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
	  try {
	  Alert jsalert=driver.switchTo().alert();
	  String actualmessage=jsalert.getText();
	  String expectedmessage="I am a JS Alert";
	  assertEquals(actualmessage, expectedmessage);
	  Thread.sleep(3000);
	  jsalert.accept();
	  Thread.sleep(8000);
	  //String actualresult=driver.findElement(By.id("result")).getText();
	  
	  WebElement act=driver.findElement(By.id("result"));
	  String actualresult=act.getText();
	  
	  String expectedresult="You successfuly clicked an alert";
	  assertEquals(actualresult, expectedresult);
	  
	  Thread.sleep(5000);
	  
	  String color= act.getCssValue("color");
	  //System.out.println(color);
	  String expectedcolor="rgb(0, 128, 0)";
	  
	  assertEquals(color, expectedcolor);
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
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
