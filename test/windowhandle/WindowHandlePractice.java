package windowhandle;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class WindowHandlePractice {

	WebDriver driver;

	@Test
	public void f() throws InterruptedException {

		driver.get("http://selenium-examples.nichethyself.com/");
		String parentWindowHandle = driver.getWindowHandle();
		driver.findElement(By.xpath("//button[text()='Contact us!']")).click();
		try {
			driver.switchTo().window("Contact");
			Thread.sleep(5000);

		}
		catch(NoSuchWindowException e){
			fail("No contact window present");

		}
		driver.findElement(By.xpath("//a[@onclick='prompty()']")).click();

		try {
			Alert alr=  driver.switchTo().alert();

			alr.sendKeys("London");
			Thread.sleep(5000);
			alr.accept();
			driver.close();
			Thread.sleep(5000);
		}catch(NoAlertPresentException e) {

			fail("Alert not found");
		}


		driver.switchTo().window(parentWindowHandle);
		driver.findElement(By.xpath("//button[text()='Write to us!']")).click();
		Thread.sleep(5000);
		Set<String> allOpenWindowHandles=driver.getWindowHandles();

		for(String oneOpenWindowHandle :allOpenWindowHandles ) {
			if(!oneOpenWindowHandle.equals(parentWindowHandle)) {
				driver.switchTo().window(oneOpenWindowHandle);
				break;
			}
		}

		driver.findElement(By.name("name")).sendKeys("Ashwini");
		driver.findElement(By.name("mobile")).sendKeys("9175291602");
		driver.findElement(By.name("email")).sendKeys("abc@gmail.com");
		driver.findElement(By.id("comment")).sendKeys("Hello , How are you?");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		try {	
			Alert abc=	driver.switchTo().alert();
			String actualtext=abc.getText();
			String expectedtext="Suggestion has been recorded.";

			assertEquals(actualtext, expectedtext);

			abc.accept();
			Thread.sleep(5000);
		}
		catch(NoAlertPresentException e) {
			fail("No alert found");
		}


		driver.close();




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
