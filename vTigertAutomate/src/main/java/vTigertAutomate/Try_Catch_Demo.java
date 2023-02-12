package vTigertAutomate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Try_Catch_Demo {

	public static void main(String[] args) {
         try {
        	System.out.println(10/0); 
         }
	catch(ArithmeticException w) {
//		w.printStackTrace();
	}
	finally {
		System.out.println("Finally Block Execute");
	}
         WebDriverManager.chromiumdriver().setup();
 		WebDriver driver = new ChromeDriver();
 		driver.get("http://localhost:8888");
	
	}

}
