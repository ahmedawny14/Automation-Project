package testCases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import base.TestBase;
import junit.framework.Assert;
import pages.HomePage;

public class homepageTest extends TestBase {

	public static HomePage homepage;
	public static Actions action;
	public static ExtentTest test;

	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("spark.html");
	{
		extent.attachReporter(spark);

	}

	public homepageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void before(Method method) throws IOException {
		test = extent.createTest(method.getName());

		setup();
		driver.get("https://courses.ultimateqa.com/collections");
		homepage = new HomePage();
		action = new Actions(driver);

	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
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

	@Test(priority = 27)
	public void checklogo() {

		homepage.CheckLogo();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.urlToBe("https://courses.ultimateqa.com/collections"));
		String expectedResult = "https://courses.ultimateqa.com/collections";
		String actualResult = driver.getCurrentUrl();
		Assert.assertEquals(expectedResult, actualResult);

	}

	@Test(priority = 28)
	public void checktitle() {

		homepage.Checktitle();
		String expectedResult = "Ultimate QA";
		String actualResult = driver.getTitle();
		Assert.assertEquals(expectedResult, actualResult);
	}

	@Test(priority = 29)
	public void checkurl() {
		homepage.checkUrl();

		String expectedResult = "https://courses.ultimateqa.com/collections";
		String actualResult = driver.getCurrentUrl();
		Assert.assertEquals(expectedResult, actualResult);
	}

	@Test(priority = 30)
	public void SigninLink() {

		homepage.SigninLink();
		String expectedResult = "https://courses.ultimateqa.com/users/sign_in";
		String actualResult = driver.getCurrentUrl();
		Assert.assertEquals(expectedResult, actualResult);

	}

	@Test(priority = 31)
	public void checkAllCourseslink() {

		homepage.allCoursesLink();
		String expectedResult = "https://courses.ultimateqa.com/collections/courses";
		String actualResult = driver.getCurrentUrl();
		Assert.assertEquals(expectedResult, actualResult);

	}

	@Test(priority = 32)
	public void ReactAndNodejsCourse() {

		homepage.ReactAndNodejsCourse();
		String expectedResult = "https://courses.ultimateqa.com/courses/react-and-nodejs";
		String actualResult = driver.getCurrentUrl();
		Assert.assertEquals(expectedResult, actualResult);

	}

	@Test(priority = 33)
	public void NodejsAndCypressCourse() {

		homepage.NodejsAndCypressCourse();
		String expectedResult = "https://courses.ultimateqa.com/courses/coding-and-testing-an-authentication-api-nodejs-cypress";
		String actualResult = driver.getCurrentUrl();
		Assert.assertEquals(expectedResult, actualResult);

	}

	@Test(priority = 34)
	public void SeleniumJavaCourse() {

		homepage.SeleniumJavaCourse();
		String expectedResult = "https://ultimateqa.com/selenium-java-2";
		String actualResult = driver.getCurrentUrl();
		Assert.assertEquals(expectedResult, actualResult);

	}

	@Test(priority = 35)
	public void JavaSdkCourse() {

		homepage.JavaSdkCourse();
		String expectedResult = "https://courses.ultimateqa.com/courses/testproject-java-sdk-tutorial";
		String actualResult = driver.getCurrentUrl();
		Assert.assertEquals(expectedResult, actualResult);

	}

	@Test(priority = 36)
	public void previousPageSign() {
		homepage.NextPageSign();
		homepage.previousPageSign();
		String expectedResult = "https://courses.ultimateqa.com/collections?page=1";
		String actualResult = driver.getCurrentUrl();
		Assert.assertEquals(expectedResult, actualResult);
	}

	@Test(priority = 37)
	public void nextPageSign() {
		homepage.NextPageSign();
		String expectedResult = "https://courses.ultimateqa.com/collections?page=2";
		String actualResult = driver.getCurrentUrl();
		Assert.assertEquals(expectedResult, actualResult);
	}

	@Test(priority = 38)
	public void Gotopage1() {
		homepage.Gotopage2();
		homepage.Gotopage1();
		String expectedResult = "https://courses.ultimateqa.com/collections?page=1";
		String actualResult = driver.getCurrentUrl();
		Assert.assertEquals(expectedResult, actualResult);
	}

	@Test(priority = 39)
	public void Gotopage2() {
		homepage.Gotopage2();
		String expectedResult = "https://courses.ultimateqa.com/collections?page=2";
		String actualResult = driver.getCurrentUrl();
		Assert.assertEquals(expectedResult, actualResult);
	}

	@Test(priority = 40)
	public void Gotopage3() {
		homepage.Gotopage3();
		String expectedResult = "https://courses.ultimateqa.com/collections?page=3";
		String actualResult = driver.getCurrentUrl();
		Assert.assertEquals(expectedResult, actualResult);
	}

	@Test(priority = 41)
	public void searchForSpecificItem() {
		homepage.searchEngine();
		HomePage.SearchEngine.sendKeys("Modern React and NodeJS Development" + Keys.ENTER);
		boolean Expectedresult = true;
		boolean Actualresult = driver
				.findElement(By.xpath("//*[@id=\"main-content\"]/div/div/section/div/ul/li/a/header/img"))
				.isDisplayed();
		Assert.assertEquals(Expectedresult, Actualresult);

	}

	@Test(priority = 42)
	public void searchMultipleItems() {
		homepage.searchEngine();
		HomePage.SearchEngine.sendKeys("java" + Keys.ENTER);
		int ExpectedResult = 4;
		int ActualResult = driver.findElements(By.xpath("//*[@class= 'products__list-item']")).size();
		Assert.assertEquals(ExpectedResult, ActualResult);
	}

}
