package testngpractise1;

import org.testng.annotations.Test;

public class SecondTestNG {
	@Test(priority = 1)
	void setup() {
		System.out.println("Openning browser");
	}

	@Test(priority = 2)
	void searchCustomer() {
		System.out.println("This is search customer test");
	}

	@Test(priority = 3)
	void addCustomer() {
		System.out.println("This is Add Customer Test");
	}

	@Test(priority = 4)
	void tearTown() {
		System.out.println("Closing browser");
	}
}
