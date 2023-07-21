package testngpractise1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC1 {

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
	void test1() {
		System.out.println("This is test1...");
	}

	@Test
	void test2() {
		System.out.println("This is test2....");
	}

}
