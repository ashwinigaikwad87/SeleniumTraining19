package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class ComboBox {
	WebDriver driver;
	
	
  @Test
  public void f() throws InterruptedException {
	  
	  driver.get("http://selenium-examples.nichethyself.com/");
	  WebElement firstoption=driver.findElement(By.xpath("//a[@href='customised.html']"));
		firstoption.click();

		Select combo=new Select (driver.findElement(By.xpath("//select[@id='days']")));
		combo.selectByVisibleText("3-star Hotel");
		Thread.sleep(3000);
		/*
		combo.selectByIndex(0);
		Thread.sleep(3000);
		
		Assert.assertEquals(combo.getFirstSelectedOption().getText(), "5-star Hotel");
		*/
		
		List<WebElement> alloptions=combo.getOptions();
		int noOfOptions= combo.getOptions().size();
		System.out.println("Number of options in combobox are :"+noOfOptions);
		
		
		List<String> expectedValues=new ArrayList();
		expectedValues.add("5-star Hotel");
		expectedValues.add("3-star Hotel");
		expectedValues.add("Home Stay");
		
		List<String>actualValues=new ArrayList();
		for(WebElement oneOption:alloptions)
			actualValues.add(oneOption.getText());
		
		Assert.assertEquals(actualValues,expectedValues);
		
		
		
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
