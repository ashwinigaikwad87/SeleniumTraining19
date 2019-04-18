package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class Flipkart {
	WebDriver driver;
  @Test
  public void f() {
	  
	  driver.get("http://www.flipkart.com");
		List <WebElement>allflipkartLinks=driver.findElements(By.tagName("a"));
   for(WebElement x:allflipkartLinks) {
			
			System.out.println(x.getText() + " - "+ x.getAttribute("href"));
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
