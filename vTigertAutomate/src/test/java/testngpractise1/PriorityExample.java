package testngpractise1;

import org.testng.annotations.Test;

public class PriorityExample {
	@Test(priority=1)
	void testOne() {
		System.out.println("This is test one");
	}

	@Test(priority=2)
	void testTwo() {
		System.out.println("This is test two");
	}

	@Test(priority=3)
	void testThree() {
		System.out.println("This is test three");
	}

	@Test(priority=4,enabled=false)
	void testFour() {
		System.out.println("This is test four");
	}
}
