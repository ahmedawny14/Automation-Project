package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public  class HomePage extends TestBase {

	public   HomePage() throws IOException {
PageFactory.initElements(driver, this);		// TODO Auto-generated constructor stub
	}

@FindBy (xpath="//img[@title='Ultimate QA']")
WebElement logo ;


@FindBy (xpath="//li[@class='header__nav-item header__nav-sign-in']//a[normalize-space()='Sign In']")
WebElement SigninLink ;

@FindBy (xpath="//input[@placeholder='Search']")
 public static WebElement SearchEngine ;

	
@FindBy (linkText="All Courses")
WebElement allCoursesLink ;


@FindBy (xpath="//a[@href='/courses/react-and-nodejs']//header//img[@class='course-card__img-container']")
WebElement ReactAndNodejsCourse ;

@FindBy (xpath="//a[@href='/courses/coding-and-testing-an-authentication-api-nodejs-cypress']//header//img[@class='course-card__img-container']")
WebElement NodejsAndCypressCourse ;

@FindBy (xpath="//a[@href='/courses/selenium-java-bootcamp']//header//img[@class='course-card__img-container']")
WebElement SeleniumJavaCourse ;

@FindBy (xpath="//a[@href='/courses/testproject-java-sdk-tutorial']//header//img[@class='course-card__img-container']")
WebElement JavaSdkCourse;  

@FindBy (xpath="//a[@href='/courses/selenium-with-c']//header//img[@class='course-card__img-container']")
WebElement SeleniumCsharpCourse  ;

@FindBy (xpath="//a[@href='/courses/c']//header//img[@class='course-card__img-container']")
WebElement CsharpCourse  ; 


@FindBy (xpath="//i[@class='fa fa-chevron-left']")
WebElement previousPageSign;



@FindBy (xpath="//i[@class='fa fa-chevron-right']")
WebElement NextPageSign;      	
	

@FindBy (xpath="//a[normalize-space()='1']")
WebElement Gotopage1;  	

@FindBy (xpath="//a[normalize-space()='2']")
WebElement Gotopage2; 

@FindBy (xpath="//a[normalize-space()='3']")
WebElement Gotopage3; 


public void CheckLogo (){
	logo.click();
	 
}


public void Checktitle(){
	driver.getTitle();
	 
}


public void checkUrl() {
	
	
	driver.getCurrentUrl();
}

public void  SigninLink()
{
	
	SigninLink.click();
}

public void allCoursesLink()
{
	

	allCoursesLink.click();
	}



public void searchEngine() {
	
	Actions action = new Actions(driver);
action.moveToElement(SearchEngine).build().perform();
}

 




public void ReactAndNodejsCourse()

{
	ReactAndNodejsCourse.click();	

}

public void NodejsAndCypressCourse()
{
	NodejsAndCypressCourse.click();
}


public void SeleniumJavaCourse() {
	
	
	SeleniumJavaCourse.click();
}

public void JavaSdkCourse() {
	
	
	JavaSdkCourse.click();
}

public void SeleniumCsharpCourse() {
	
	
	SeleniumCsharpCourse.click();
}


public void CsharpCourse() {
	
	CsharpCourse.click();
	
}



public void previousPageSign()

{
	

	previousPageSign.click();
	
}

public void NextPageSign() {
	
	NextPageSign.click();
}


public void Gotopage1()

{
	
	Gotopage1.click();

}

public void Gotopage2()

{
	
	Gotopage2.click();

}

public void Gotopage3()

{
	
	Gotopage3.click();

}








}




	

