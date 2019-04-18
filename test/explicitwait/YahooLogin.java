package explicitwait;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class YahooLogin {
	WebDriver driver;
	WebDriverWait wait;
  @Test
  public void f() throws InterruptedException {
	  
	  driver.get("http://www.yahoomail.com");

		WebElement LoginUser=driver.findElement(By.id("login-username"));
		System.out.println(driver.getTitle());
		LoginUser.sendKeys("ashwinigaikwad87");
		driver.findElement(By.id("login-signin")).click();
		WebElement passwd=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-passwd")));
		//Thread.sleep(5000);
		passwd.sendKeys("Target@2019");
		Thread.sleep(5000);
		//WebElement button=wait.until(ExpectedConditions.elementToBeClickable(By.id("login-signin")));
		driver.findElement(By.id("login-signin")).click();
		//button.click();
		
		//Thread.sleep(10000);
		WebElement prof=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@role='presentation']")));
		prof.click();
		
		//driver.findElement(By.xpath("//label[@role='presentation']")).click();
		//Thread.sleep(5000);
		
		WebElement signout=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Sign out')]")));
		//driver.findElement(By.xpath("//span[contains(text(),'Sign out')]")).click();
		
		signout.click();
		
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.gecko.driver", "test\\resources\\geckodriver-64bit.exe");
		 driver=new FirefoxDriver();
		 wait=new WebDriverWait(driver,30);
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
