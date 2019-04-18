package actionsclass;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class GmailTab {
	WebDriver driver;
	
	WebDriverWait wait;

	@Test
	public void f() throws InterruptedException {

		driver.get("https://www.google.com/");
		String parentWindowHandle = driver.getWindowHandle();
		WebElement gmail= driver.findElement(By.xpath("//a[contains(text(),\"Gmail\")]"));
		Actions builder=new Actions(driver);
		builder.keyDown(Keys.CONTROL).click(gmail).sendKeys(Keys.chord(Keys.CONTROL,Keys.TAB)).release().build().perform();
		
		
		//builder.keyDown(Keys.CONTROL).click(gmail).release().build().perform();


		Set<String> allOpenWindowHandles=driver.getWindowHandles();

		for(String oneOpenWindowHandle :allOpenWindowHandles ) {
			if(!oneOpenWindowHandle.equals(parentWindowHandle)) {
				driver.switchTo().window(oneOpenWindowHandle);
				Thread.sleep(5000);
				break;

			}
		}
		
		driver.switchTo().window(parentWindowHandle);
		
		WebElement search=wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		search.sendKeys("Jobs in Selenium");
	
		WebElement searchresult=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'jobs in selenium')]")));
		
		builder.moveToElement(searchresult).click().perform();
		
		
		
		
		//Thread.sleep(3000);
		





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
