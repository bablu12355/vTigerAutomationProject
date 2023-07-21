package testngpractise1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC2 {

	@BeforeClass
	void beforeClass() {
		System.out.println("This will execute before the class ");
	}

	@AfterClass
	void afterClass() {
		System.out.println("This will execute after the class ");
	}

	@BeforeMethod
	void beforeMethod() {
		System.out.println("This will execute before every method ");
	}

	@AfterMethod
	void afetrMethod() {
		System.out.println("This will execute after every method");
	}

	@Test
	void test3() {
		System.out.println("This is test3...");
	}

	@Test
	void test4() {
		System.out.println("This is test4....");

	}

	@BeforeTest
	void beforeTest() {
		System.out.println("This will execute before the test");
	}

	@AfterTest
	void afterTest() {
		System.out.println("This will execute after the test");
	}

	@BeforeSuite
	void beforeSuite() {
		System.out.println("This will execute before the test suite");
	}

	@AfterSuite
	void afterSuite() {
		System.out.println("This will execute after  the test suite");
	}

}
