package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class MultiSelect {

	WebDriver driver;
	@Test
	public void f() {

		driver.get("http://cookbook.seleniumacademy.com/Config.html");
		//Select multi=new Select(driver.findElement(By.xpath("//select[@name='make']")));
		Select multi= new Select(driver.findElement(By.name("color")));	
		if(multi.isMultiple()) {
			System.out.println("Multiselect is supported");
			
		multi.selectByValue("wt");

		
		multi.selectByValue("br");	
		
		//multi.deselectByValue("wt");
		
		
		
		List<WebElement> alloptions=multi.getOptions();
		int noOfOptions=alloptions.size();
		System.out.println("Number of options available in multiselect are:"+noOfOptions);
		
		List<WebElement>allSelectedOptions=multi.getAllSelectedOptions();
		for(WebElement webelement:allSelectedOptions)
		{
			System.out.println("Selected options are: "+webelement.getText());	
		}
		
		
		
		//System.out.println("Number of options selected are: "+multi.getAllSelectedOptions());
		
		
		multi.deselectAll();


		
		
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
