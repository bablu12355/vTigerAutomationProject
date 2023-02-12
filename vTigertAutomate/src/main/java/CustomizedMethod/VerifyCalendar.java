package CustomizedMethod;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class VerifyCalendar {

	public static void main(String[] args) throws InterruptedException {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, 40);
		Date d = c.getTime();
		DateFormat df = new SimpleDateFormat("d_MMM");
		String date = df.format(d);
		System.out.println(date);
		String[] arrDate = date.split("_");
		String day = arrDate[0];
		String month = arrDate[1];

		WebDriver driver = new ChromeDriver();
		driver.get("https://erail.in/");
		Thread.sleep(5000);
		// td[@id='tdDateFromTo']//input[@type='button']
		Actions ac = new Actions(driver);

		WebElement we = driver.findElement(By.xpath("//input[@title='Select Departure date for availability']"));
		ac.click(we).build().perform();
		Thread.sleep(5000);
		WebElement wr = driver.findElement(By.xpath("//td[contains(text(),'"+month+"')]//parent::tr//following-sibling::tr//following-sibling::tr//td[text()='"+day+"']"));
		ac.click(wr).build().perform();
		// td[text()='Mar-23']//parent::tr//following-sibling::tr//following-sibling::tr//td[text()='3']

	}

}
