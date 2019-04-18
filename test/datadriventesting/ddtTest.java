package datadriventesting;

import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class ddtTest {WebDriver driver;

	@Test(dataProvider = "LoginSeleniumExample")
 public void LoginTest(String id, String pass) throws InterruptedException {
		driver.get("http://selenium-examples.nichethyself.com/");
		WebElement user = driver.findElement(By.id("loginname"));
		user.sendKeys(id);					
		driver.findElement(By.id("loginpassword")).sendKeys(pass);
		driver.findElement(By.id("loginbutton")).click();	
		Thread.sleep(5000);

 }
 @BeforeMethod
 public void beforeMethod() {
		System.setProperty("webdriver.gecko.driver","test\\resources\\geckodriver-64bit.exe");
		System.setProperty("webdriver.chrome.driver","test\\resources\\chromedriver.exe");

//		driver = new FirefoxDriver();
		driver = new ChromeDriver();

 }

 @AfterMethod
 public void afterMethod() {
 }


 @DataProvider (name="LoginSeleniumExample")
 public Object[][] myDataProvider() {
	  String[][] data = readDataFromXLS("test\\resources\\data\\loginJXL.xls","LoginData","StartAndEnd");
	  return data;
 }
 
 
 public String[][] readDataFromXLS(String xlFilePath, String sheetName, String tableName){
     String[][] tabArray=null;
     try{
         Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
         //Workbook class is provied by jxl.jar
         //WebDriver provided by Selenium 
         //File is class provided by Java to read a physical file
         Sheet sheet = workbook.getSheet(sheetName);
         Cell tableStart=sheet.findCell(tableName);
         
         int startRow,startCol, endRow, endCol,ci,cj;
         
         startRow=tableStart.getRow();//2
         startCol=tableStart.getColumn();//1

         Cell tableEnd= sheet.findCell(tableName, startCol+1,startRow+1, 100, 64000,  false);                

         endRow=tableEnd.getRow();//7
         endCol=tableEnd.getColumn();//6
         System.out.println("startRow="+startRow+", endRow="+endRow+", " +
                 "startCol="+startCol+", endCol="+endCol);
         tabArray=new String[endRow-startRow-1][endCol-startCol-1];//5,4
         ci=0; //array row
         //ci=0,i=3, j=3,cj=1
         for (int i=startRow+1;i<endRow;i++,ci++){//i represents xls row
             cj=0;//array column
             for (int j=startCol+1;j<endCol;j++,cj++){//j represents xls column
                 tabArray[ci][cj]=sheet.getCell(j,i).getContents();
             }
         }
     }
     catch (Exception e)    {
         System.out.println("Please check if file path, sheet name and tag name are correct");
         
     }

     return(tabArray);
 }

}
