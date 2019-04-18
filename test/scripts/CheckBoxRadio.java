package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class CheckBoxRadio {
	
	WebDriver driver;
	
  @Test
  public void CheckboxRadioTest() throws InterruptedException {
	  
	  driver.get("http://selenium-examples.nichethyself.com/");

		WebElement firstoption=driver.findElement(By.xpath("//a[@href='customised.html']"));
		firstoption.click();
		
		WebElement radio=driver.findElement(By.xpath("(//input[@name='optradio'])[1]"));
		radio.click();
		Thread.sleep(3000);
		
		WebElement check=driver.findElement(By.xpath("(//input[@type='checkbox' ])[4]"));
		if(check.isEnabled()) {
		
		if(!check.isSelected())
		check.click();
		Thread.sleep(3000);
		
		if(check.isSelected())
			check.click();
		Thread.sleep(3000);
		}
		else {
			System.out.println("Checkbox is not enabled");
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
