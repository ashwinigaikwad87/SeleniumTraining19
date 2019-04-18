package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class GoogleLogin {

	WebDriver driver;

	@Test
	public void LoginTest() throws InterruptedException {

		driver.get("http://www.gmail.com");
		driver.manage().window().maximize();


		WebElement LoginUser=driver.findElement(By.name("identifier"));
		LoginUser.sendKeys("unifroz5");
		WebElement ne=driver.findElement(By.xpath("//span[@class='RveJvd snByac']"));
		ne.click();
		Thread.sleep(5000);
		WebElement paswd=driver.findElement(By.xpath("//input[@type='password']"));
		paswd.sendKeys("satishnk");
		WebElement nep=driver.findElement(By.xpath("//span[@class='RveJvd snByac']"));
		nep.click();
		
		
		
		

	}
	@BeforeMethod
	public void beforeMethod() {

		System.setProperty("webdriver.gecko.driver", "test\\resources\\geckodriver-64bit.exe");
		driver=new FirefoxDriver(); 
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void afterMethod() {
		
		driver.quit();
	}

}
