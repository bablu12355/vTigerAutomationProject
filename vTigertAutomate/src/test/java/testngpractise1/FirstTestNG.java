package testngpractise1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTestNG {
	@Test(priority = 1)
	void setup() {
		System.out.println("openning browser");
	}

	@Test(priority = 2)
	void login() {
		System.out.println("This is login text");
	Assert.assertEquals(10/0, 10/0);
	}

	@Test
	void Hompage() {
		System.out.println("This is Homepage text");
	}

	@Test(priority = 3)
	void tearTown() {
		System.out.println("Closing browser");
	}
}
