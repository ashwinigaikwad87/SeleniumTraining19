package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class ToolsQA {

	WebDriver driver;
	@Test
	public void f() {


		driver.get("http://toolsqa.com/automation-practice-form/");
		driver.manage().window().maximize();


	WebElement name=driver.findElement(By.name("firstname"));
		name.sendKeys("Ashwini");
		System.out.println(name.getAttribute("value"));	
	

		WebElement lname=driver.findElement(By.name("lastname"));
		lname.sendKeys("Gaikwad");
		System.out.println(lname.getAttribute("value"));
		
		
		






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
