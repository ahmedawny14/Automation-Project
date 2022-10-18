package testCases;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import base.TestBase;
import pages.HomePage;
import pages.LoginPage;
import pages.registerPage;
import utilities.utilities;

public class register extends TestBase {

	public static HomePage homepage;
	public static registerPage RegisterPage;
	public static LoginPage loginpage;
	public static utilities uti;

	public register() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("spark.html");
	{
		extent.attachReporter(spark);

	}

	@BeforeMethod
	public void beforeMethod(Method method) throws ATUTestRecorderException, IOException {

		test = extent.createTest(method.getName());

		setup();

		homepage = new HomePage();
		loginpage = new LoginPage();
		RegisterPage = new registerPage();
		uti = new utilities();

		homepage.SigninLink();
		loginpage.CreateNewAccountLink();

	}

	@AfterMethod
	public void aftermethod(Method method, ITestResult result) throws ATUTestRecorderException, IOException {
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

	@Test(priority = 1)
	public void clickOnLogo() throws IOException

	{
		RegisterPage.ClickOnlogo();
		String ExpectedResult = "https://courses.ultimateqa.com/collections";
		String ActualResult = driver.getCurrentUrl();
		Assert.assertEquals(ActualResult, ExpectedResult);
	}

	@Test(priority = 2)
	public void checkTitle(Method method) // check the title of the page
	{
		String ExpectedResult = "Ultimate QA";
		String ActualResult = RegisterPage.CheckTitle();
		Assert.assertEquals(ActualResult, ExpectedResult);
	}

	@Test(priority = 3)
	public void checkUrl(Method method) // check the url of the page
	{
		String ExpectedResult = "https://courses.ultimateqa.com/users/sign_up";
		String ActualResult = RegisterPage.CheckUrl();
		Assert.assertEquals(ActualResult, ExpectedResult);
	}

	@Test(priority = 4)
	public void check_Signin_Link(Method method) // It should go to login page
	{
		RegisterPage.check_Signin_Link();
		String ExpectedResult = "https://courses.ultimateqa.com/users/sign_in";
		String actualResult = driver.getCurrentUrl();
		Assert.assertEquals(actualResult, ExpectedResult);
	}

	@Test(priority = 5)

	public void check_I_already_have_account_Link(Method method) // It should go to login page
	{
		RegisterPage.HaveAccount();
		String ExpectedResult = "https://courses.ultimateqa.com/users/sign_in";
		String actualResult = driver.getCurrentUrl();
		Assert.assertEquals(actualResult, ExpectedResult);
	}

	@Test(priority = 6)
	public void check_terms_of_use_Link(Method method) // it should open terms page in another tab
	{
		RegisterPage.Checkterms();
		Set<String> handle = driver.getWindowHandles();
		Iterator<String> iterator = handle.iterator();
		String window1 = iterator.next();
		String window2 = iterator.next();
		driver.switchTo().window(window2);
		String ExpectedResult = "https://courses.ultimateqa.com/pages/terms";
		String actualResult = driver.getCurrentUrl();
		Assert.assertEquals(actualResult, ExpectedResult);
	}

	@Test(priority = 7)
	public void check_CustomerPrivacyPolicy_Link(Method method) // it should open policy page in another tab
	{
		RegisterPage.CheckPolicy();
		Set<String> handle = driver.getWindowHandles();
		Iterator<String> iterator = handle.iterator();
		String window1 = iterator.next();
		String window2 = iterator.next();
		driver.switchTo().window(window2);
		String ExpectedResult = "https://courses.ultimateqa.com/pages/privacy";
		String actualResult = driver.getCurrentUrl();
		Assert.assertEquals(actualResult, ExpectedResult);
	}

	@Test(priority = 8)

	public void register_With_ValidData(Method method) throws InterruptedException // Entering all fields with valid
																					// data
	{

		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		RegisterPage.Validregister();
		String ExpectedResult = "https://courses.ultimateqa.com/collections";
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.urlToBe("https://courses.ultimateqa.com/collections"));
		String actualResult = driver.getCurrentUrl();
		Assert.assertEquals(actualResult, ExpectedResult);

	}

	@Test(priority = 9)

	public void EmptyFirstName(Method method) throws InterruptedException // don't enter a value in first name field
	{
		RegisterPage.registerWithEmptyFname();
		String ExpectedMsg = "First name can't be blank";
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"notice\"]/ul/li[1]")));
		String ActualMsg = driver.findElement(By.xpath("//*[@id=\"notice\"]/ul/li[1]")).getText();
		Assert.assertEquals(ActualMsg, ExpectedMsg);

	}

	@Test(priority = 10)
	public void EmptyLastName(Method method) throws InterruptedException // don't enter a value in last name field
	{

		RegisterPage.registerWithEmptyLname();
		String ExpectedMsg = "Last name can't be blank";
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"notice\"]/ul/li")));
		String ActualMsg = driver.findElement(By.xpath("//*[@id=\"notice\"]/ul/li")).getText();
		Assert.assertEquals(ActualMsg, ExpectedMsg);

	}

	@Test(priority = 11)

	public void EmptyEmail(Method method) throws InterruptedException // don't enter a value in email field
	{
		RegisterPage.registerWithEmptyEmail();
		String ExpectedMsg = "Email can't be blank";
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"notice\"]/ul/li")));
		String ActualMsg = driver.findElement(By.xpath("//*[@id=\"notice\"]/ul/li")).getText();
		Assert.assertEquals(ActualMsg, ExpectedMsg);

	}

	@Test(priority = 12)

	public void TakenEmail(Method method) throws InterruptedException // enter an email that is existed before
	{

		RegisterPage.registerWithExistedEmail();
		String ExpectedMsg = "Email has already been taken";
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"notice\"]/ul/li")));
		String ActualMsg = driver.findElement(By.xpath("//*[@id=\"notice\"]/ul/li")).getText();
		Assert.assertEquals(ActualMsg, ExpectedMsg);
	}

	@Test(priority = 13)

	public void InvalidEmail(Method method) throws InterruptedException // enter an email without @ and .com
	{
		RegisterPage.registerWithInvalidEmail();

		String ExpectedMsg = "Email is invalid";
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"notice\"]/ul/li")));
		String ActualMsg = driver.findElement(By.xpath("//*[@id=\"notice\"]/ul/li")).getText();
		Assert.assertEquals(ActualMsg, ExpectedMsg);

	}

	@Test(priority = 14)

	public void Emptypassword(Method method) throws InterruptedException // // don't enter a value in password field
	{
		RegisterPage.registerWithEmptyPassword();

		String ExpectedMsg = "Password can't be blank";
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"notice\"]/ul/li")));
		String ActualMsg = driver.findElement(By.xpath("//*[@id=\"notice\"]/ul/li")).getText();
		Assert.assertEquals(ActualMsg, ExpectedMsg);

	}

	@Test(priority = 15)

	public void Invalidpassword(Method method) throws InterruptedException // enter a password less than 8 characters
	{

		RegisterPage.registerWithInvalidPassword();
		String ExpectedMsg = "Password must be at least 8 characters.";
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"notice\"]/ul/li")));
		String ActualMsg = driver.findElement(By.xpath("//*[@id=\"notice\"]/ul/li")).getText();
		Assert.assertEquals(ActualMsg, ExpectedMsg);

	}

	@Test(priority = 16)
	public void signUpWithFacbook(Method method) throws InterruptedException // click on facebook icon
	{

		RegisterPage.signupWithFacebook();
		boolean Expectedresult = true;
		boolean ActualResult = driver
				.findElement(By.xpath("//*[@id=\"blueBarDOMInspector\"]/div/div[1]/div/div/h1/a/i")).isDisplayed();
		Assert.assertEquals(ActualResult, Expectedresult);

	}

	@Test(priority = 17)
	public void signUpWithLinkedin(Method method) throws InterruptedException // click on linkedin icon icon
	{

		RegisterPage.signupWithLinkedink();
		boolean Expectedresult = true;
		boolean ActualResult = driver
				.findElement(By.xpath(
						"//div[@class='header__logo']//li-icon[@alt='LinkedIn']//*[name()='svg']//*[name()='path'][1]"))
				.isDisplayed();
		Assert.assertEquals(ActualResult, Expectedresult);

	}

	@Test(priority = 18)
	public void signUpWithGmail(Method method) throws InterruptedException // click on gmail icon
	{

		RegisterPage.signupWithGmail();

		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div/article/div/ul/li[3]/a")).click();
		boolean Expectedresult = true;
		boolean ActualResult = driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).isDisplayed();
		Assert.assertEquals(ActualResult, Expectedresult);
	}

}