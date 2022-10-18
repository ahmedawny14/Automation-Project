package testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;
import utilities.utilities;

public class loginTest extends TestBase {
	public static utilities uti;

	public loginTest() throws IOException {
		super();

	}

	public static LoginPage login;
	public static HomePage home;

	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("spark.html");
	{
		extent.attachReporter(spark);

	}

	@BeforeMethod
	public void beforeMethod(Method method) throws IOException {

		test = extent.createTest(method.getName());

		setup();

		home = new HomePage();
		login = new LoginPage();
		home.SigninLink();

	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {

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

	@Test(priority = 19)
	public void checkLogo() {

		login.checklogo();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.urlToBe("https://courses.ultimateqa.com/collections"));
		String expectedResult = "https://courses.ultimateqa.com/collections";
		String actualResult = driver.getCurrentUrl();
		AssertJUnit.assertEquals(expectedResult, actualResult);
	}

	@Test(priority = 20)
	public void checktitle(Method method) {

		login.CheckTitle();
		String expectedResult = "Ultimate QA";
		String actualResult = driver.getTitle();
		AssertJUnit.assertEquals(expectedResult, actualResult);

	}

	@Test(priority = 21)
	public void checkurl() {
		login.CheckUrl();

		String expectedResult = "https://courses.ultimateqa.com/users/sign_in";
		String actualResult = driver.getCurrentUrl();
		AssertJUnit.assertEquals(expectedResult, actualResult);
	}

	@Test(priority = 22)

	public void checkSininLink(ITestResult result) {

		login.check_Signin_Link();

		String expectedResult = "https://courses.ultimateqa.com/users/sign_in";
		String actualResult = driver.getCurrentUrl();
		AssertJUnit.assertEquals(expectedResult, actualResult);

	}

	@Test(priority = 23)
	public void checkForgotPasswordLink() {
		login.check_forgotPassword_Link();

		String expectedResult = "https://courses.ultimateqa.com/users/password/new";
		String actualResult = driver.getCurrentUrl();
		AssertJUnit.assertEquals(expectedResult, actualResult);
	}

	@Test(priority = 24)
	public void checkLinkedinLogin() {
		login.LinkedinkLogin();
		boolean Expectedresult = true;
		boolean ActualResult = driver
				.findElement(By.xpath(
						"//div[@class='header__logo']//li-icon[@alt='LinkedIn']//*[name()='svg']//*[name()='path'][1]"))
				.isDisplayed();
		AssertJUnit.assertEquals(ActualResult, Expectedresult);
	}

	@Test(priority = 25)
	public void checkFacebookLogin(Method method) {
		login.facebookLogin();
		boolean Expectedresult = true;
		boolean ActualResult = driver
				.findElement(By.xpath("//*[@id=\"blueBarDOMInspector\"]/div/div[1]/div/div/h1/a/i")).isDisplayed();
		AssertJUnit.assertEquals(ActualResult, Expectedresult);
	}

	@Test(priority = 26)
	public void checkGmailLogin(Method method) {

		login.GmailLogin();
		boolean Expectedresult = true;
		boolean ActualResult = driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).isDisplayed();
		AssertJUnit.assertEquals(ActualResult, Expectedresult);
	}

	@Test(dataProvider = "LoginData", priority = 27)
	public void loginTestCase(String email, String password) throws IOException

	{

		login.emailTextBox.sendKeys(email);

		login.passwordTextBox.sendKeys(password);
		login.LoginBtn.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.urlToBe("https://courses.ultimateqa.com/collections"));
		String expectedResult = "https://courses.ultimateqa.com/collections";
		String actualResult = driver.getCurrentUrl();
		AssertJUnit.assertEquals(expectedResult, actualResult);
	}

	@DataProvider
	public Object[][] LoginData() throws IOException {

		Object data[][] = utilities.ReadFromExcel("Sheet1");
		return data;

	}

}
