package windowhandle;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class CookbookWindowHandle {
	
	WebDriver driver;
	
  @Test
  public void f() throws InterruptedException {
	  
	  
	  driver.get("http://cookbook.seleniumacademy.com/Config.html");
	  driver.findElement(By.id("helpbutton")).click();
	  String parentWindowHandle = driver.getWindowHandle();
	  Set<String> allOpenWindowHandles=driver.getWindowHandles();

		for(String oneOpenWindowHandle :allOpenWindowHandles ) {
			if(!oneOpenWindowHandle.equals(parentWindowHandle)) {
				driver.switchTo().window(oneOpenWindowHandle);
				Thread.sleep(5000);
				driver.close();
				break;
				
			}
		}
		
		
	driver.switchTo().window(parentWindowHandle);
	Thread.sleep(5000);
	
	driver.findElement(By.id("chatbutton")).click();
	Set<String> allOpenWindowHandles1=driver.getWindowHandles();

	for(String oneOpenWindowHandle1 :allOpenWindowHandles1 ) {
		if(!oneOpenWindowHandle1.equals(parentWindowHandle)) {
			driver.switchTo().window(oneOpenWindowHandle1);
			Thread.sleep(5000);
			driver.findElement(By.xpath("//input[@type='Submit']")).click();
			System.out.println();
			break;
			
		}
	}
	
	driver.switchTo().window(parentWindowHandle);
	Thread.sleep(5000);
	driver.findElement(By.id("visitbutton")).click();
	Set<String> allOpenWindowHandles2=driver.getWindowHandles();

	for(String oneOpenWindowHandle2 :allOpenWindowHandles2 ) {
		if(!oneOpenWindowHandle2.equals(parentWindowHandle)) {
			driver.switchTo().window(oneOpenWindowHandle2);
			Thread.sleep(5000);
			driver.close();
			break;
			
		}
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
