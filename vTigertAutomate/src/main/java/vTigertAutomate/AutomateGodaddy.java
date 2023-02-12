package vTigertAutomate;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomateGodaddy {

	public static void main(String[] args) throws InterruptedException {
//		WebDriver driver = testCase1();
//		Thread.sleep(3000);
//		driver.close();
//		WebDriver driver1 = testCase2();
//		Thread.sleep(3000);
//		driver1.close();
//		WebDriver driver2 = testCase3();
//		Thread.sleep(3000);
//		driver2.close();
		WebDriver driver3 = testCase4();
	}

	public static WebDriver testCase1() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.godaddy.com");
		driver.manage().window().setSize(new Dimension(800, 900));
		return driver;
	}

	public static WebDriver testCase2() {
		WebDriver driver1 = testCase1();
		driver1.manage().window().maximize();
		System.out.println(driver1.getTitle());
		System.out.println(driver1.getCurrentUrl());
		return driver1;

	}

	public static WebDriver testCase3() {
		WebDriver driver2 = testCase1();
		String actual_title = driver2.getTitle();
		System.out.println(actual_title);
		String expected_Title = "Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy IN";
		if (expected_Title.equals(actual_title)) {
			System.out.println("user is able to verify the title of home page");
		} else {
			System.out.println("user isn't able to verify the title of home page");
		}
		String Url = driver2.getCurrentUrl();

		String expected1_Url = "https://www.godaddy.com/en-in";
		if (expected1_Url.equals(Url)) {
			System.out.println("user is Able to verify get Current URL of the page");
		} else {
			System.out.println("user is  n't Able to verify get Current URL of the page");

		}
		String actual_PageSorce = driver2.getPageSource();
		// System.out.println(actual_PageSorce);
		if (actual_PageSorce.contains(
				"GoDaddy offers domain names, web hosting, online marketing, phone services, web design and an easy to use website builder.")) {
			System.out.println("user is confirmed that title is present in page source");
		} else {
			System.out.println("user isn't confirmed that title is present in page source");
		}
		return driver2;
	}

	public static WebDriver testCase4() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver3 = new ChromeDriver();
		driver3.get("https://www.godaddy.com");
		driver3.manage().window().maximize();
		driver3.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver3.findElement(By.xpath("//button[@id='id-d6f9deab-d554-45df-a52c-8a9ab53948b5']")).click();
		WebElement rightClick = driver3.findElement(By.xpath("//a[text()='Domain Name Search']"));
		Actions action = new Actions(driver3);
		
		action.contextClick(rightClick).sendKeys(Keys.F5).perform();

		return driver3;

	}
}
