package frames;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class FramesTest {
	
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  
	  driver.get("http://the-internet.herokuapp.com/nested_frames");
	  
	  driver.switchTo().frame(0);
	  Thread.sleep(5000);
	  driver.switchTo().frame("frame-left");
	  Thread.sleep(5000);
	  driver.switchTo().parentFrame();
	  driver.switchTo().frame("frame-middle");
	  driver.switchTo().parentFrame();
	  driver.switchTo().frame("frame-right");
	  driver.switchTo().defaultContent();
	/*driver.switchTo().parentFrame();
	driver.switchTo().frame(1);*/
	driver.switchTo().frame(1);
	
	List<WebElement>allopenframes=driver.findElements(By.tagName("frame"));
	for(WebElement oneopenframe:allopenframes) {
		
		
		driver.switchTo().frame(oneopenframe);
		break;
			
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
