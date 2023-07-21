package testngpractise1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupingExample {

	@Test(groups={"Sanity"})
	void testMethod1() {
		System.out.println("this is Test Method One.... ");
	}

	@Test(groups={"Sanity"})
	void testMethod2() {
		System.out.println("this is Test Method Two.........  ");
	}

	@Test(groups={"regression"})
	void testMethod3() {
		System.out.println("this is Test Method Three..... ");
	}

	@Test(groups={"regression"})
	void testMethod4() {
		System.out.println("this is Test Method Four......... ");
	}

	@Test(groups={"Sanity","regression"})
	void testMethod5() {
		System.out.println(" this is Test Method Fifth....... ");
	}
}
