package explicitwait;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class Herokuapp1 {
	
	WebDriver driver;
	WebDriverWait wait;
	
  @Test
  public void f() {
	  
	  driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
	  
	  driver.findElement(By.xpath("//div[@id='start']/button")).click();
	  WebElement hero1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']/h4")));
	 hero1.getText();
	 
	  
	  //String actualText=driver.findElement(By.xpath("//div[@id='finish']/h4")).getText();
	  assertEquals( hero1.getText(), "Hello World!");
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.gecko.driver", "test\\resources\\geckodriver-64bit.exe");
		driver=new FirefoxDriver();
		wait=new WebDriverWait(driver,10);
  }

  @AfterMethod
  public void afterMethod() {
	  
	  driver.quit();
  }

}
