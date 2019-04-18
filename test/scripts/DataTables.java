package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class DataTables {
	
	WebDriver driver;
	private WebElement element;
	
	 public DataTables(WebElement element) {
		 this.element=element;
	 }
	
  @Test
  public void DataTableTest() {
	  
	  
	  
	  
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
