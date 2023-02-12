package vTigertAutomate;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TryCatch {

	public static void main(String[] args) {
		WebDriverManager.chromiumdriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888");
		try {
			driver.findElement(By.xpath("//input[@name='user_names']")).sendKeys("admin");
		} catch (NoSuchElementException e) {
			driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");

//			e.printStackTrace();
		}
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("Bablu@123");
		driver.findElement(By.xpath("//input[@name='Login']")).click();

	}

}
