package pageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilLayer.WebUtil;

public class HomePage {
WebUtil util=null;
	public HomePage(WebUtil util) {
		this.util=util;
		PageFactory.initElements(util.getDriver(), this);
		
	}
	
	@FindBy(xpath = "//p[text()='All Products']")
	WebElement allProducts;
	
}
