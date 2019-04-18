package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class ToolsQAForm {
	
	WebDriver driver;
  @Test
  public void f() {
	  
	  driver.get("http://toolsqa.com/automation-practice-form/");
		driver.manage().window().maximize();
		
		WebElement name=driver.findElement(By.name("firstname"));
		name.sendKeys("Ashwini");
		
		WebElement lname=driver.findElement(By.name("lastname"));
		lname.sendKeys("Gaikwad");
		
		WebElement radio=driver.findElement(By.id("sex-1"));
		radio.click();
		
		WebElement radio1=driver.findElement(By.id("exp-5"));
		radio1.click();
		
		WebElement date=driver.findElement(By.id("datepicker"));
		date.sendKeys("2/24/2019");
		
		
		WebElement check=driver.findElement(By.id("profession-0"));
		check.click();
		
		WebElement check1=driver.findElement(By.id("tool-2"));
		check1.click();
		
		Select drop=new Select(driver.findElement(By.xpath("//select[@id='continents']")));
		drop.selectByVisibleText("Asia");
		
		Select multis=new Select(driver.findElement(By.xpath("//select[@id='selenium_commands']")));
		multis.selectByVisibleText("Browser Commands");
		multis.selectByVisibleText("Wait Commands");
		multis.selectByVisibleText("WebElement Commands");
		
		
		WebElement button=driver.findElement(By.id("submit"));
		button.click();
		
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
