package frames;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class ToolsQAFrames {

	WebDriver driver;

	@Test
	public void f() throws InterruptedException {

		driver.get("https://www.toolsqa.com/iframe-practice-page/");
		// driver.findElement(By.id("IF1")));
		driver.switchTo().frame("IF1");

		//Thread.sleep(20000);

		driver.findElement(By.name("firstname")).sendKeys("Ashwini");
		driver.findElement(By.name("lastname")).sendKeys("Gaikwad");

		driver.findElement(By.id("sex-1"));
		Thread.sleep(3000);
		
		driver.findElement(By.name("firstname")).clear();
		driver.findElement(By.name("lastname")).clear();
		
		driver.switchTo().parentFrame();

		driver.switchTo().frame("IF2");

		driver.switchTo().defaultContent();


		List<WebElement> allFrames = driver.findElements(By.tagName("iframe"));


		for(WebElement oneFrame: allFrames) {

			if (driver.getTitle().contains("TOOLSQA")) {
				driver.switchTo().frame(oneFrame);
				
			driver.findElement(By.name("firstname")).sendKeys("Ashwini");
			Thread.sleep(3000);
			break;
			
			
			}
			
			else 
				driver.switchTo().defaultContent();


		
		}


	}
	@BeforeMethod
	public void beforeMethod() {

		System.setProperty("webdriver.gecko.driver", "test\\resources\\geckodriver-64bit.exe");
		driver=new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void afterMethod() {

		driver.quit();
	}

}
