package actionsclass;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class TripHobo {
	WebDriver driver;
	WebDriverWait wait;
	
  @Test
  public void f() throws InterruptedException {
	  
	 driver.get("https://www.triphobo.com/");
	 WebElement place= driver.findElement(By.id("spl-autocomplete-search"));
	 place.sendKeys("Houston");
	
	 
	 WebElement houston=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@data-id='5006d04176a295b85500009e']")));
	 
	  Actions builder=new Actions(driver);
	  builder.moveToElement(houston).click().build().perform();
	  
	  driver.findElement(By.id("plan-my-trip")).click();
	  
	WebElement save=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-create-mode='manual']")));
	
	  save.click();
	  
	  WebElement skip=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("js_close_hotel_combine")));
	  skip.click();
	  
	  
	  WebElement skipto=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hotel_step_popup_skip_hotel")));
	  skipto.click();
	  
	
	 
	 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='global-drawer-overlay js_hotel_cm_drawer']")));
	 
	 WebElement addActivity= driver.findElement(By.id("js_add_activity"));
	  
	  
	
	addActivity.click();
	
	 
	WebElement museum=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='Museum district']")));
	 builder.moveToElement(museum).click().build().perform();
	 
	 
	 WebElement day2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),\"Day 2\")]")));
	 day2.click();
	
	 
	 WebElement cross1=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-unique-id='add_day_list_drawer']/div/a")));
	 cross1.click();
	 
	 
	 
	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='add-to-itin-wrapper']")));
	 
	WebElement cross2=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-unique-id='activity_drawer']/div/a")));
	cross2.click();
	  
	 
	 
	 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//section[@class='add-activity-container-template']")));
	
	 WebElement source=driver.findElement(By.xpath("//h4[@title='Museum district']"));
	 WebElement target=driver.findElement(By.xpath("//li[@data-day-id='3']"));
	 builder.dragAndDrop(source, target).perform();
	 
	
	  
	  Thread.sleep(3000);
	  
	  
	  
	  
	  
	  
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  
	  System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
		driver=new ChromeDriver();
		wait=new WebDriverWait(driver,40);
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
	 
  }

}
