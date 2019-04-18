package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class Yahoo {
	
	WebDriver driver;
  @Test
  public void yahooTest() throws InterruptedException {
	  
	  driver.get("http://www.yahoomail.com");

		WebElement LoginUser=driver.findElement(By.id("login-username"));
		LoginUser.sendKeys("ashwinigaikwad87");
		driver.findElement(By.id("login-signin")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("login-passwd")).sendKeys("Target@2019");
		Thread.sleep(3000);
		driver.findElement(By.id("login-signin")).click();
		
		WebElement compose=driver.findElement(By.xpath("//a[@data-test-id='compose-button']"));
		compose.click();
		WebElement to=driver.findElement(By.xpath("//input[@class='select-input react-typeahead-input input-to Z_N ir_0 j_n y_Z2uhb3X q_52qC k_w W_6D6F H_6NIX M_0 b_0 P_SMJKi A_6EqO D_X p_a L_0 B_0']"));
		to.sendKeys("ketan@paratussystems.com");
		Thread.sleep(3000);
		
		WebElement subject=driver.findElement(By.xpath("//input[@data-test-id='compose-subject']"));
		subject.sendKeys("Hi Ketan, I am Ashwini");
		Thread.sleep(3000);
		
		WebElement data=driver.findElement(By.xpath("//div[@data-test-id=\"rte\"]"));
		data.sendKeys("I have done my assignment.");
		Thread.sleep(3000);
		
		
		WebElement sendbutton=driver.findElement(By.xpath("//span[contains(text(),'Send')]"));
		sendbutton.click();
		Thread.sleep(3000);
		
		
		
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  
	  System.setProperty("webdriver.gecko.driver", "test\\resources\\geckodriver-64bit.exe");
		 driver=new FirefoxDriver();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
  }

  @AfterMethod
  public void afterMethod() {
	  
	  driver.quit();
  }

}
