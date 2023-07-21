package pageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilLayer.WebUtil;

public class LoginPage {

	@FindBy(xpath = "//p[text()='My Account']")
	private WebElement accountBT;

	@FindBy(xpath = "//input[@id=':r0:']")
	private WebElement Phon_NO;

	@FindBy(xpath = "//button[text()='LOGIN']")
	private WebElement loginBt;

	
	@FindBy(xpath = "//button[@type='submit']") 
	public WebElement otpSubmit;

	@FindBy(xpath = "//input[@id=':r1:']")
	private WebElement OTP_BT;
	
	@FindBy(xpath = "//input[@id='first_name']")
	private WebElement First_name;
	
	@FindBy(xpath = "//input[@id='last_name']")
	private WebElement Last_name;
	
	@FindBy(xpath = "//input[@id='email']")
	private WebElement Emailadd;
	
	@FindBy(xpath = "//button[text()='Update']")
	private WebElement Update_BT;
	
	
	
	
	
	@FindBy(xpath = "img[class='MuiAvatar-img css-1hy9t21']")
	private WebElement MY_profile;
	
	
	
	@FindBy(xpath = "//div[@id='gender']")
	private WebElement Gender;
	
	private WebUtil util;

	public LoginPage(WebUtil util) {
		this.util = util;
		PageFactory.initElements(util.getDriver(), this);

	}

	public void Account_ln() {

		util.click(accountBT,"AccountButton");
	}
	public void phon_No() {
		util.sendkeys(Phon_NO,"phon","8874662816");
	}
		
		public void Login() {
			util.click(loginBt, "loginButton");
		}	
		
		public void Otp_Bt() {
			util.sendkeys(OTP_BT,"opt","123456");
		System.out.println(OTP_BT.getAttribute("value"));
		}
		
		public void  Firstname() {
			util.sendkeys(First_name,"firstName_ln","goldi");
			
		}		
			public void  Lastname() {
				util.sendkeys(Last_name,"lastName_ln","Yadav");
			}
			
			public void Email() {
				util.sendkeys(Emailadd,"emailAddress","goldi7365@ygmail.com");
			}	
			
			public void Updatebutton() {
				util.click(Update_BT,"updatebutton");
			}	
			
			
				
			public void  profileimg() {
				util.click(MY_profile,"profile");
			}	
	
				public void Gender() {
					util.click(Gender,"dateofbirth");				
				
				
//	public String loginPageTitle() {
//		return util.getTitle();
//	}

}}
