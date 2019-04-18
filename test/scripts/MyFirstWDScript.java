package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyFirstWDScript {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver", "test\\resources\\geckodriver-64bit.exe");
		driver=new FirefoxDriver();
		
		driver.get("http://selenium-examples.nichethyself.com/");
		WebElement loginUserName=driver.findElement(By.id("loginname")); // findElement is in driver class 
		loginUserName.sendKeys("stc123");//send keys is in WebElements
		
		driver.findElement(By.id("loginpassword")).sendKeys("12345");
		driver.findElement(By.id("loginbutton")).click();
		
		String currenturl= driver.getCurrentUrl();
		
		if(currenturl.contains("password"))
			System.out.println("Login successful. Test case passed.");
		else
			System.out.println("Login unsuccessful.Test case failed.");
		
		
		
		//driver.findElement(By.id("logo")).click();
		
		
		

	}

}
