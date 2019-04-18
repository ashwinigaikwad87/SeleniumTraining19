package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class GoogleTest {


	WebDriver driver;
	@Test
	public void f() {

		driver.get("http://www.google.com");
		List <WebElement>allGoogleLinks=driver.findElements(By.tagName("a"));
		/*for(int i=0;i<allGoogleLinks.size();i++) {
			System.out.println(allGoogleLinks.get(i).getText() + " - "+ allGoogleLinks.get(i).getAttribute("href"));	  
			
			
			
		}*/
		
		
		for(WebElement x:allGoogleLinks) {
			
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
	}

}
