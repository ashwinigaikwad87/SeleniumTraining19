package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Assignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver;
		System.setProperty("webdriver.gecko.driver", "test\\resources\\geckodriver-64bit.exe");
		 driver=new FirefoxDriver();

		driver.get("http://www.yahoomail.com");

		WebElement LoginUser=driver.findElement(By.id("login-username"));
		LoginUser.sendKeys("ashwinigaikwad87");
		driver.findElement(By.id("login-signin")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("login-passwd")).sendKeys("Target@2019");
		Thread.sleep(5000);
		driver.findElement(By.id("login-signin")).click();
		
		String currenturl=driver.getCurrentUrl();
		if(currenturl=="https://mail.yahoo.com/d/folders/1")
			System.out.println("Login successful !");
		else
			System.out.println("Login unsuccessful");
		
		
		
	}

}
