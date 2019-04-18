package datadriventesting;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class ddtCSV {
	WebDriver driver;
	
	
	@Test (dataProvider = "ReadFromCSV",dataProviderClass=MyDataProviders.class)
	public void loginToNicheThyself1(String user, String password) {
		  driver.get("http://selenium-examples.nichethyself.com");
		  driver.findElement(By.name("username")).sendKeys(user);
		  driver.findElement(By.name("password")).sendKeys(password);
		  driver.findElement(By.name("loginform")).findElement(By.tagName("button")).click();		
	}
	  
	  
  
  @BeforeMethod
  public void beforeMethod() {
	  
	  System.setProperty("webdriver.gecko.driver","test\\resources\\geckodriver-64bit.exe");
	  driver = new FirefoxDriver();
  }

  @AfterMethod
  public void afterMethod() {
  }
 

}
