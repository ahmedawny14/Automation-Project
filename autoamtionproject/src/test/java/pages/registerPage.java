package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class registerPage extends TestBase {
	public registerPage() throws IOException {
 		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	
	@FindBy (xpath="//img[@title='Ultimate QA']")
	WebElement Logo;
	
	@FindBy (linkText ="Sign In")
	WebElement SigninLink;
	
	@FindBy (linkText ="I already have an account!")
	WebElement HaveAccount;
	
	@FindBy (linkText ="Terms of Use")
	WebElement CheckTerms;

	@FindBy (linkText ="Customer Privacy Policy")
	WebElement  Checkpolicy;
	
	@FindBy (id="user[first_name]")
	WebElement FirstName;
	
	@FindBy (id="user[last_name]")
	WebElement LastName;
	
	@FindBy (name="user[email]")
	WebElement Email;
	@FindBy (name="user[password]")
	WebElement Password;
	
	@FindBy (id="user[terms]")
	WebElement TermsAgree;
	@FindBy (xpath="//*[@class='button button-primary g-recaptcha']")
	WebElement SignupButton;
	
	@FindBy (xpath="//*[@id=\"main-content\"]/div/div/article/div/ul/li[2]/a")
	WebElement SignUpWithFacebook;
	
	@FindBy (xpath="//*[@id=\"main-content\"]/div/div/article/div/ul/li[1]/a")
	WebElement SignUpWithLinkedin;
	
	@FindBy (xpath="//*[@id=\"main-content\"]/div/div/article/div/ul/li[3]/a")
	WebElement SignUpWithGmail;
	
	public void ClickOnlogo() throws IOException {
		
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
	


	public   void  check_Signin_Link()
	
	{
		
		SigninLink.click();
		
	}
public void HaveAccount() {
	
	
	HaveAccount.click();
	
}

public void  Checkterms() {
	
	
	 CheckTerms.click();
}
public void  CheckPolicy() {
	
	
	   Checkpolicy.click();
}

public void  Validregister() {
	
	FirstName.sendKeys("Ahmed");
	LastName.sendKeys("Awny");
    Email.sendKeys("ahmed4awny@gmail.com ");	
    Password.sendKeys("Ahmedawny_14");
    TermsAgree.click();
    SignupButton.click();
}

public void  registerWithEmptyFname() {
	
	FirstName.sendKeys(" ");
	LastName.sendKeys("Awny");
    Email.sendKeys("ahmed5awny@gmail.com");	
    Password.sendKeys("Ahmedawny_14");
    TermsAgree.click();
    SignupButton.click();
}
public void  registerWithEmptyLname() {
	
	FirstName.sendKeys(" Ahmed");
	LastName.sendKeys(" ");
    Email.sendKeys("ahmed6awny@gmail.com");	
    Password.sendKeys("Ahmedawny_14");
    TermsAgree.click();
    SignupButton.click();
}

public void  registerWithEmptyEmail() {
	
	FirstName.sendKeys(" Ahmed");
	LastName.sendKeys("Awny ");
    Email.sendKeys(" ");	
    Password.sendKeys("Ahmedawny_14");
    TermsAgree.click();
    SignupButton.click();
}
public void  registerWithExistedEmail() {
	
	FirstName.sendKeys(" Ahmed");
	LastName.sendKeys("Awny ");
    Email.sendKeys("ahmedeldaly685@gmail.com");	
    Password.sendKeys("Ahmedawny_14");
    TermsAgree.click();
    SignupButton.click();
}
public void  registerWithInvalidEmail() {
	
	FirstName.sendKeys(" Ahmed");
	LastName.sendKeys("Awny ");
    Email.sendKeys("ahmedeldaly685 ");	
    Password.sendKeys("Ahmedawny_14");
    TermsAgree.click();
    SignupButton.click();
}

public void  registerWithEmptyPassword() {
	
	FirstName.sendKeys(" Ahmed");
	LastName.sendKeys("Awny ");
    Email.sendKeys("ahmed7awny@gmail.com ");	
    Password.sendKeys(" ");
    TermsAgree.click();
    SignupButton.click();
}

public void  registerWithInvalidPassword() {
	
	FirstName.sendKeys(" Ahmed");
	LastName.sendKeys("Awny ");
    Email.sendKeys("ahmed8awny@gmail.com ");	
    Password.sendKeys("1234 ");
    TermsAgree.click();
    SignupButton.click();
}

public void  signupWithFacebook() {
	SignUpWithFacebook.click();
	}
	
public void  signupWithLinkedink() {
	SignUpWithLinkedin .click();
	}


public void  signupWithGmail() {
	SignUpWithGmail.click();
	}



}
	

