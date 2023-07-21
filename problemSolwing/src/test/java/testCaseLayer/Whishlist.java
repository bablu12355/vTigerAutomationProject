package testCaseLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilLayer.WebUtil;

public class Whishlist {

	
	
	@FindBy(xpath = "//p[text()='All Products']")  // old xpath ="//p[text()='Wishlist']"
	private WebElement ALL_ProductBT;
	
	@FindBy(xpath = "//p[text()='Laptop & Accessories']")  // old xpath ="//p[text()='Wishlist']"
	private WebElement Laptop_Accessories;
	
	
	
	@FindBy(xpath = "//p[text()='Wishlist']")  // old xpath ="//p[text()='Wishlist']"
	private WebElement wishList;
	
	private WebUtil util;

	public Whishlist(WebUtil util) {
		this.util = util;
		PageFactory.initElements(util.getDriver(), this);

	}

	public void Allproduct() {

		
		util.actionClick(ALL_ProductBT,"allproduct_link");
		System.out.println("clicked successfully on All Products");
		util.sleep(3);
		util.click(Laptop_Accessories, "Laptop & Accessories");
		util.sleep(3);
		util.actionClick(wishList,"wishlist");

	}
}
