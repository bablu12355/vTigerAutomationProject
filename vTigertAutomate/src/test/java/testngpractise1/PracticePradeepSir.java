package testngpractise1;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticePradeepSir {

	@FindBy(name = "user_name")
	static WebElement userN;

	@FindBy(name = "user_password")
	static WebElement userP;

	@FindBy(name = "Login")
	static WebElement loginB;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get("http://localhost:8888");
		PageFactory.initElements(driver, PracticePradeepSir.class);
//		WebElement loginB = driver.findElement(By.name("Login"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
//		WebElement userN= driver.findElement(By.name("user_name"));
		js.executeScript("arguments[0].value='admin'", userN);
//		WebElement userP=driver.findElement(By.name("user_password"));
		js.executeScript("arguments[0].value='Babli@123'", userP);
		js.executeScript("arguments[0].click()", loginB);

		js.executeScript("arguments[0].value='admin'", userN);
	}

}
