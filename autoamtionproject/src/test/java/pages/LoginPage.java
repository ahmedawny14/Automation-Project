package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class LoginPage extends TestBase{

	public LoginPage() throws IOException {
 PageFactory.initElements(driver, this);		// TODO Auto-generated constructor stub
	}
	@FindBy (xpath="/html/body/header/div/div/section[2]/a/img")
	public WebElement Logo;
	
  	@FindBy (linkText ="Sign In")
	WebElement SigninLink;
  	
  	@FindBy (xpath="//a[@class='form__forgot-password']")
  	WebElement forgotPasswordLink;
  	
  	@FindBy (xpath="//input[@id='user[remember_me]']")
  	WebElement remeberMe;
  	
  	@FindBy (xpath="//input[@id='user[email]']")
 	 public WebElement emailTextBox;
	
	@FindBy (xpath="//input[@id='user[password]']")
	 public WebElement passwordTextBox;
	
	@FindBy (xpath="//input[@value='Sign in']")
	 public WebElement LoginBtn;
	
	@FindBy (xpath="//*[@id=\"main-content\"]/div/div/article/div/ul/li[1]/a")
	WebElement LinkedinLogin;
	
	@FindBy (xpath="//*[@id=\"main-content\"]/div/div/article/div/ul/li[2]/a")
	WebElement FacebookLogin;
	
	@FindBy (xpath="//*[@id=\"main-content\"]/div/div/article/div/ul/li[3]/a")
	WebElement GmailLogin;
	
	@FindBy(xpath="//*[@id=\"main-content\"]/div/div/aside/a")
	 WebElement CreateNewAccountLink;
	
	
	public void checklogo() {
		
		Logo.click();
	}

	
	public String CheckTitle() {
		String ActualTitle= driver.getTitle();
		return  ActualTitle;
	}
	
	
	public String CheckUrl() {
		String ActualUrl= driver.getCurrentUrl();
		return  ActualUrl;
	}
	
	public void performLogin()
	{
		
		SigninLink.click();
		emailTextBox.sendKeys("ahmedeldaly685@gmail.com");
		passwordTextBox.sendKeys("Ahmedawny_14");
		LoginBtn.click();
		
		
	}
	
public   void  check_Signin_Link()
	
	{
		
		SigninLink.click();
		
	}
	
public   void  check_forgotPassword_Link()

{
	
	 forgotPasswordLink.click();
	
}

	
public void   LinkedinkLogin() {
	 LinkedinLogin .click();
	}


 
	
public void  facebookLogin() {
	FacebookLogin.click();
	}


public void   GmailLogin() {
	GmailLogin.click();
	}
 public void CreateNewAccountLink()
 {
	 
	 CreateNewAccountLink.click();
	 
 }
 

	
	
}




