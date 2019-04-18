package actionsclass;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class AnnaUniversity {
	
	WebDriver driver;
	
	WebDriverWait wait;
  @Test
  public void f() throws InterruptedException {
	  
	  driver.get("http://annauniv.edu/");
	  WebElement department=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href ,'department')]")));
	  department.click();
	  
	  WebElement civildept=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a/strong[contains(text(),' Faculty of Civil Engineering ')]")));
	  
      Actions builder=new Actions(driver);
	  builder.moveToElement(civildept).perform();
	  
	  //Thread.sleep(5000);
	 
	WebElement clickElement=driver.findElement(By.id("menuItemHilite32"));
	  //Thread.sleep(5000);
	  builder.moveToElement(clickElement).click().perform();
	  Thread.sleep(5000);
	  
	String actualTitle=  driver.getTitle();
	String expectedTitle="Institute For Ocean Management - Anna University offers M.Tech in Coastal Management. ENVIS Center for Coastal Zone Management and Coastal Shelterbelts";
	
	assertEquals(actualTitle, expectedTitle);
	
WebElement id=	driver.findElement(By.id("link3"));
	
	builder.moveToElement(id);
	//Thread.sleep(3000);
	WebElement clickelement1=driver.findElement(By.id("menuItemHilite13"));
	builder.moveToElement(clickelement1).click().perform();
	//Thread.sleep(3000);
	
	String actualMessage=driver.findElement(By.xpath("//h1[contains(text(),'Not Found')]")).getText();
	String expectedMessage="Not Found";
	assertEquals(actualMessage, expectedMessage);
	
	
	
	
	
	
	
	  
	  
	  
	  
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  
	  System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
		 driver=new ChromeDriver();
		 wait=new WebDriverWait(driver,20);
  }

  @AfterMethod
  public void afterMethod() {
	  
	  driver.quit();
  }

}
