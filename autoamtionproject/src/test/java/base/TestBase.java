package base;

import java.io.IOException;
import java.util.Properties;
import java.io.FileInputStream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import atu.testrecorder.ATUTestRecorder;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static Properties prop;
	public static ATUTestRecorder recorder;

	public static ExtentTest test;
	ExtentSparkReporter spark;

	public static ExtentReports extent;

	public TestBase() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"E:\\automationNewProject\\autoamtionproject\\src\\test\\resources\\configFiles\\config.properties");
		prop.load(fis);

	}

	public static WebDriver driver;

	public static void setup() throws IOException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(prop.getProperty("url"));

	}

}