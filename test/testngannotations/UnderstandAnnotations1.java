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

public class UnderstandAnnotations1 {
 
 
	  
	  @Test
	   public void test1() {
	 	 
	  System.out.println("Inside test1 of First Class");
	   }
	   
	  
	  @Test
	   public void test2() {
	 	  System.out.println("Inside test2 of First Class");
	   }

	  
	  @Test
	   public void test3() {
	 	  System.out.println("Inside test3 of First Class");
	   }
	   
	  


	  @BeforeMethod
	   public void beforeMethod() {
	 	  
	 System.out.println("Inside beforeMethod of First Class");
	   }

	   
	 @AfterMethod
	   public void afterMethod() {
	 	  
	 System.out.println("Inside afterMethod of First Class");
	   }

	   
	 @BeforeClass
	   public void beforeClass() {
	 	  
	 System.out.println("Inside beforeClass of First Class");
	 }

	   

	 @AfterClass
	   public void afterClass() {
	 	  System.out.println("Inside afterClass of First Class");
	 }

	   @BeforeTest
	   public void beforeTest() {
	 	  System.out.println("Inside beforeTest of First Class");
	 }

	   @AfterTest
	   public void afterTest() {
	 	  System.out.println("Inside afterTest of First Class");
	 }

	   @BeforeSuite
	   public void beforeSuite() {
	 	  System.out.println("Inside beforeSuite of First Class");
	 }

	   @AfterSuite
	   public void afterSuite() {
	 	  System.out.println("Inside afterSuite of First Class");
	 }

	 }
