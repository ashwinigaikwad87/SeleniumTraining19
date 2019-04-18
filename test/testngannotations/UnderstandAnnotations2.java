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

public class UnderstandAnnotations2 {
 
 
	  
	  @Test
	   public void test1() {
	 	 
	  System.out.println("Inside test1 of Second Class");
	   }
	   
	  
	  @Test
	   public void test2() {
	 	  System.out.println("Inside test2 of Second Class");
	   }

	  
	  @Test
	   public void test3() {
	 	  System.out.println("Inside test3 of Second Class");
	   }
	   
	  


	  @BeforeMethod
	   public void beforeMethod() {
	 	  
	 System.out.println("Inside beforeMethod of Second Class");
	   }

	   
	 @AfterMethod
	   public void afterMethod() {
	 	  
	 System.out.println("Inside afterMethod of Second Class");
	   }

	   
	 @BeforeClass
	   public void beforeClass() {
	 	  
	 System.out.println("Inside beforeClass of Second Class");
	 }

	   

	 @AfterClass
	   public void afterClass() {
	 	  System.out.println("Inside afterClass of Second Class");
	 }

	   @BeforeTest
	   public void beforeTest() {
	 	  System.out.println("Inside beforeTest of Second Class");
	 }

	   @AfterTest
	   public void afterTest() {
	 	  System.out.println("Inside afterTest of Second Class");
	 }

	   @BeforeSuite
	   public void beforeSuite() {
	 	  System.out.println("Inside beforeSuite of Second Class");
	 }

	   @AfterSuite
	   public void afterSuite() {
	 	  System.out.println("Inside afterSuite of Second Class");
	 }

	 }
