package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;

public class ReactAndNodejsCoursePage extends TestBase {

	public ReactAndNodejsCoursePage() throws IOException {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@title='Ultimate QA']")
	WebElement logo;

	@FindBy(xpath = "//*[@id=\"main-content\"]/section[1]/div/div/section")
public	WebElement maincontentVideo;

	@FindBy(linkText = "My Dashboard")
	WebElement Dashboardlink;

	@FindBy(xpath = "/html/body/header/div/div/section[1]/ul/li/a/i")
	WebElement Dropdown;

	@FindBy(linkText = "My Account")
	WebElement MyAccountLink;

	@FindBy(linkText = "My Dashboard")
	WebElement MyDashboardLink;

	@FindBy(linkText = "Support")
	public
	WebElement SupportLink;

	@FindBy(linkText = "Sign Out")
	 public WebElement SignOutLink;

	@FindBy(xpath = "//*[@id=\"main-content\"]/section[2]/article/ul/li[1]/div/div/header/span")
	public
	WebElement Ch1ShowContent;

	@FindBy(xpath = "//*[@id=\"main-content\"]/section[2]/article/ul/li[2]/div/div/header/span")
	public
	WebElement Ch2ShowContent;

	@FindBy(xpath = "//*[@id=\"main-content\"]/section[2]/article/ul/li[3]/div/div/header/span")
	public
	WebElement Ch3ShowContent;

	@FindBy(xpath = "//*[@id=\"main-content\"]/section[2]/article/ul/li[4]/div/div/header/span/span")
 public 	WebElement Ch4ShowContent;

	@FindBy(xpath = "//*[@id=\"main-content\"]/section[2]/article/ul/li[5]/div/div/header/span/span")
	public
	WebElement Ch5ShowContent;

	@FindBy(xpath = "//*[@id=\"main-content\"]/section[2]/article/ul/li[6]/div/div/header/span/span")
	 public WebElement Ch6ShowContent;

	@FindBy(linkText = "Get started now")
	 public WebElement GetStartbutton;

	public void GetTitle() {

		driver.getTitle();
	}

	public void GetUrl() {

		driver.getCurrentUrl();

	}

	public void CheckLogo() {
		logo.click();
	}

	public void MyDashboard() {
		Dashboardlink.click();
	}

	public void introductionVideo() {
		maincontentVideo.click();
	}

	public void AccountInfoDropDown() {
      Dropdown.click();
		 
    }

	public void MyAccountLink() {
		MyAccountLink.click();
	}

	public void MyDashboardLink() {
		MyDashboardLink.click();
		 
	}

	public void SupportLink() {
		SupportLink.click();
	}

	public void SignOutLink() {
		SignOutLink.click();
	}

	public void Ch1_showContent() {
		Ch1ShowContent.click();
	}

	public void Ch2_showContent() {
		Ch2ShowContent.click();
	}

	public void Ch3_showContent() {
		Ch3ShowContent.click();
	}

	public void Ch4_showContent() {
		Ch4ShowContent.click();
	}

	public void Ch5_showContent() {
		Ch5ShowContent.click();
	}

	public void Ch6_showContent() {
		Ch6ShowContent.click();
	}

	public void GetStartbutton() {
		GetStartbutton.click();

	}

}
