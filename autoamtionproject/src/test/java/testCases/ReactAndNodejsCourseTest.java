package testCases;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.ITestResult;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import base.TestBase;
import junit.framework.Assert;
import pages.HomePage;
import pages.LoginPage;
import pages.ReactAndNodejsCoursePage;
import utilities.utilities;

public class ReactAndNodejsCourseTest extends TestBase {

	public ReactAndNodejsCourseTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static utilities uti;
	public static ReactAndNodejsCoursePage ReactAndNodejs;
	public static WebDriverWait wait;
	public static HomePage home;

	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("spark.html");
	{
		extent.attachReporter(spark);

	}

	@BeforeMethod
	public void beforemethod(Method method) throws IOException, InterruptedException {
		test = extent.createTest(method.getName());

		setup();
		uti = new utilities();
		LoginPage login = new LoginPage();

		driver.manage().window().maximize();
		ReactAndNodejs = new ReactAndNodejsCoursePage();
		login.performLogin();
		Thread.sleep(15000);
		driver.navigate().to("https://courses.ultimateqa.com/enrollments");

		login.checklogo();
		home.ReactAndNodejsCourse();

	}

	@AfterMethod
	public void afterMethod(Method method, ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test Pass");
		} else if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.PASS, "Test Fail");
		} else {
			test.log(Status.SKIP, "Test Skipped");
		}

		extent.flush();

		driver.quit();

	}

	@Test(priority = 43)
	public void CheckTitle(Method method) {
		ReactAndNodejs.GetTitle();
		String expectedResult = "Modern React and NodeJS Development (hands-on projects)";
		String actualResult = driver.getTitle();
		Assert.assertEquals(expectedResult, actualResult);
	}

	@Test(priority = 44)
	public void CheckUrl() {
		ReactAndNodejs.GetUrl();
		String expectedResult = "https://courses.ultimateqa.com/courses/react-and-nodejs";
		String actualResult = driver.getCurrentUrl();
		Assert.assertEquals(expectedResult, actualResult);

	}

	@Test(priority = 45)
	public void checkLogo() {

		ReactAndNodejs.CheckLogo();
		String expectedResult = "https://courses.ultimateqa.com/collections";
		String actualResult = driver.getCurrentUrl();
		Assert.assertEquals(expectedResult, actualResult);

	}

	@Test(priority = 46)
	public void MyDashboard(Method method) throws InterruptedException, IOException {

		ReactAndNodejs.MyDashboard();
		boolean expectedResult = true;
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("My Dashboard")));

		boolean actualResult = driver
				.findElement(By.xpath("//*[@id=\"main-content\"]/section[2]/div/ul/li/section/header/a/img"))
				.isDisplayed();
		ReactAndNodejs.CheckLogo();

		Assert.assertEquals(expectedResult, actualResult);

	}

//@Test(priority=47)
//public void introductionVideo()
//{
// 	home.ReactAndNodejsCourse();
//
// 	wait=new WebDriverWait(driver,15);
// 	
//
//	wait.until(ExpectedConditions.elementToBeClickable(ReactAndNodejs.maincontentVideo));
//  ReactAndNodejs.introductionVideo();
// 
//}

	@Test(priority = 48)
	public void MyAccountLink() throws InterruptedException {
		home.ReactAndNodejsCourse();

		ReactAndNodejs.AccountInfoDropDown();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("My Account")));
		ReactAndNodejs.MyAccountLink();
		String ExpectedResult = "https://courses.ultimateqa.com/account";
		String ActualResult = driver.getCurrentUrl();
		ReactAndNodejs.CheckLogo();

		Assert.assertEquals(ExpectedResult, ActualResult);

	}

	@Test(priority = 49)
	public void MyDashboardLink() throws InterruptedException {
		home.ReactAndNodejsCourse();

		ReactAndNodejs.AccountInfoDropDown();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("My Dashboard")));
		ReactAndNodejs.MyDashboard();
		String ExpectedResult = "https://courses.ultimateqa.com/enrollments";
		String ActualResult = driver.getCurrentUrl();
		ReactAndNodejs.CheckLogo();

		Assert.assertEquals(ExpectedResult, ActualResult);

	}

	@Test(priority = 50)
	public void SupportLink() throws InterruptedException {
		home.ReactAndNodejsCourse();

		ReactAndNodejs.AccountInfoDropDown();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Support")));
		boolean ExpectedResult = true;
		boolean ActualResult = ReactAndNodejs.SupportLink.isEnabled();
		ReactAndNodejs.CheckLogo();

		Assert.assertEquals(ExpectedResult, ActualResult);

	}

	@Test(priority = 58)
	public void SignOut() throws InterruptedException {
		home.ReactAndNodejsCourse();

		ReactAndNodejs.AccountInfoDropDown();
		wait.until(ExpectedConditions.elementToBeClickable(ReactAndNodejs.SignOutLink));

		ReactAndNodejs.SignOutLink();
		String ExpectedResult = "https://courses.ultimateqa.com/";
		String ActualResult = driver.getCurrentUrl();
		ReactAndNodejs.CheckLogo();

		Assert.assertEquals(ExpectedResult, ActualResult);

	}

	@Test(priority = 51)
	public void ShowChapter1Content()

	{
		home.ReactAndNodejsCourse();

		wait = new WebDriverWait(driver, 15);

		wait.until(ExpectedConditions.elementToBeClickable(ReactAndNodejs.Ch1ShowContent));

		ReactAndNodejs.Ch1_showContent();
		boolean ExpectedResult = true;
		boolean ActualResult = driver.findElement(By.xpath("//*[@id=\"chapter-1\"]/li[4]/span")).isDisplayed();
		ReactAndNodejs.CheckLogo();

		Assert.assertEquals(ExpectedResult, ActualResult);

	}

	@Test(priority = 52)
	public void ShowChapter2Content()

	{
		home.ReactAndNodejsCourse();

		wait = new WebDriverWait(driver, 15);

		wait.until(ExpectedConditions.elementToBeClickable(ReactAndNodejs.Ch2ShowContent));

		ReactAndNodejs.Ch2_showContent();
		boolean ExpectedResult = true;
		boolean ActualResult = driver.findElement(By.xpath("//*[@id=\"chapter-2\"]/li[2]/span")).isDisplayed();
		ReactAndNodejs.CheckLogo();

		Assert.assertEquals(ExpectedResult, ActualResult);

	}

	@Test(priority = 53)
	public void ShowChapter3Content() {
		home.ReactAndNodejsCourse();

		wait = new WebDriverWait(driver, 15);

		wait.until(ExpectedConditions.elementToBeClickable(ReactAndNodejs.Ch3ShowContent));

		ReactAndNodejs.Ch3_showContent();
		boolean ExpectedResult = true;
		boolean ActualResult = driver.findElement(By.xpath("//*[@id=\"chapter-3\"]/li[2]/span")).isDisplayed();
		ReactAndNodejs.CheckLogo();

		Assert.assertEquals(ExpectedResult, ActualResult);

	}

	@Test(priority = 54)
	public void ShowChapter4Content() {
		home.ReactAndNodejsCourse();

		wait = new WebDriverWait(driver, 15);

		wait.until(ExpectedConditions.elementToBeClickable(ReactAndNodejs.Ch4ShowContent));

		ReactAndNodejs.Ch4_showContent();
		boolean ExpectedResult = true;
		boolean ActualResult = driver.findElement(By.xpath("//*[@id=\"chapter-4\"]/li[2]/span")).isDisplayed();
		ReactAndNodejs.CheckLogo();

		Assert.assertEquals(ExpectedResult, ActualResult);

	}

	@Test(priority = 55)
	public void ShowChapter5Content()

	{
		home.ReactAndNodejsCourse();

		wait = new WebDriverWait(driver, 15);

		wait.until(ExpectedConditions.elementToBeClickable(ReactAndNodejs.Ch5ShowContent));

		ReactAndNodejs.Ch5_showContent();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"chapter-5\"]/li[6]/span")));
		boolean ExpectedResult = true;
		boolean ActualResult = driver.findElement(By.xpath("//*[@id=\"chapter-5\"]/li[6]/span")).isDisplayed();
		ReactAndNodejs.CheckLogo();

		Assert.assertEquals(ExpectedResult, ActualResult);

	}

	@Test(priority = 56)
	public void ShowChapter6Content()

	{
		home.ReactAndNodejsCourse();
		wait = new WebDriverWait(driver, 15);

		wait.until(ExpectedConditions.elementToBeClickable(ReactAndNodejs.Ch6ShowContent));

		ReactAndNodejs.Ch6_showContent();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"chapter-6\"]/li/span/i")));
		boolean ExpectedResult = true;
		boolean ActualResult = driver.findElement(By.xpath("//*[@id=\"chapter-6\"]/li/span/i")).isDisplayed();
		ReactAndNodejs.CheckLogo();

		Assert.assertEquals(ExpectedResult, ActualResult);
		ReactAndNodejs.CheckLogo();

	}

	@Test(priority = 57)
	public void GetStarted() {
		home.ReactAndNodejsCourse();

		wait = new WebDriverWait(driver, 15);

		wait.until(ExpectedConditions.elementToBeClickable(ReactAndNodejs.GetStartbutton));

		ReactAndNodejs.GetStartbutton();
		String ExpectedResult = "https://courses.ultimateqa.com/enrollments";
		String ActualResult = driver.getCurrentUrl();

		Assert.assertEquals(ExpectedResult, ActualResult);

	}

}