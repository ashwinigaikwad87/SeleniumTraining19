package testngannotations;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class UnderstandAnnotations3 {
 
 
	  
	  @Test
	   public void test1() {
	 	 
	  System.out.println("Inside test1 of Third Class");
	   }
	   
	  
	  @Test
	   public void test2() {
	 	  System.out.println("Inside test2 of Third Class");
	   }

	  
	  @Test
	   public void test3() {
	 	  System.out.println("Inside test3 of Third Class");
	   }
	   
	  


	  @BeforeMethod
	   public void beforeMethod() {
	 	  
	 System.out.println("Inside beforeMethod of Third Class");
	   }

	   
	 @AfterMethod
	   public void afterMethod() {
	 	  
	 System.out.println("Inside afterMethod of Third Class");
	   }

	   
	 @BeforeClass
	   public void beforeClass() {
	 	  
	 System.out.println("Inside beforeClass of Third Class");
	 }

	   

	 @AfterClass
	   public void afterClass() {
	 	  System.out.println("Inside afterClass of Third Class");
	 }

	   @BeforeTest
	   public void beforeTest() {
	 	  System.out.println("Inside beforeTest of Third Class");
	 }

	   @AfterTest
	   public void afterTest() {
	 	  System.out.println("Inside afterTest of Third Class");
	 }

	   @BeforeSuite
	   public void beforeSuite() {
	 	  System.out.println("Inside beforeSuite of Third Class");
	 }

	   @AfterSuite
	   public void afterSuite() {
	 	  System.out.println("Inside afterSuite of Third Class");
	 }

	 }
