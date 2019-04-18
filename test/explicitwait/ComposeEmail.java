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

public class ComposeEmail {
	WebDriver driver;
	WebDriverWait wait;
  @Test
  public void f() throws InterruptedException {
	  
	  driver.get("http://www.yahoomail.com");
	  
	
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  

			WebElement LoginUser=driver.findElement(By.id("login-username"));
			LoginUser.sendKeys("ashwinigaikwad87");
			driver.findElement(By.id("login-signin")).click();
			//Thread.sleep(3000);
			WebElement paswd=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-passwd")));
			//driver.findElement(By.id("login-passwd")).sendKeys("Target@2019");
			paswd.sendKeys("Target@2019");
			Thread.sleep(3000);
			WebElement button=wait.until(ExpectedConditions.elementToBeClickable(By.id("login-signin")));
			button.click();
			driver.findElement(By.id("login-signin")).click();
			
			//WebElement compose=driver.findElement(By.xpath("//a[@data-test-id='compose-button']"));
			WebElement compose=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-test-id='compose-button']")));
			compose.click();
			WebElement to=driver.findElement(By.xpath("//input[@class='select-input react-typeahead-input input-to Z_N ir_0 j_n y_Z2uhb3X q_52qC k_w W_6D6F H_6NIX M_0 b_0 P_SMJKi A_6EqO D_X p_a L_0 B_0']"));
			to.sendKeys("ask2787@gmail.com");
			//Thread.sleep(3000);
			
			WebElement subject=driver.findElement(By.xpath("//input[@data-test-id='compose-subject']"));
			subject.sendKeys("Hi Ashwini - Email from Selenium");
			//Thread.sleep(3000);
			
			WebElement data=driver.findElement(By.xpath("//div[@data-test-id=\"rte\"]"));
			data.sendKeys("To check explicit wait");
			//Thread.sleep(3000);
			
			
			WebElement sendbutton=driver.findElement(By.xpath("//span[contains(text(),'Send')]"));
			sendbutton.click();
			//Thread.sleep(3000);
			
			
	  
	  
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
