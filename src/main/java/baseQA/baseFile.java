package baseQA;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import java.time.Duration;


import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;


import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.generatereports;
import utilities.readConfigureProperties;

public class baseFile {
	public static WebDriver driver;
	public static ExtentReports extentReport;
	public static ExtentTest extentTest;
	public static generatereports initialiseReport;
	
	@BeforeSuite
	public void extendReportInitialization(ITestContext context) {
		initialiseReport =	new generatereports(context);
		initialiseReport.createReport();
	}

	@AfterSuite
	public void generateReport() throws IOException {
		extentReport.flush();
		Desktop.getDesktop().browse(new File(System.getProperty("user.dir") + "\\reports\\testReport.html").toURI());
	}

	@BeforeTest
	public void initialization(ITestContext context) throws IOException {

		if (readConfigureProperties.getConfigurationProperties("browser").toString().equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (readConfigureProperties.getConfigurationProperties("browser").toString()
				.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			;
			driver = new FirefoxDriver();
		} else if (readConfigureProperties.getConfigurationProperties("browser").toString().equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			;
			driver = new EdgeDriver();
		} else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

		extentTest = extentReport.createTest(context.getName());

		Capabilities capabilities = ((RemoteWebDriver) driver).getCapabilities();
		String device = capabilities.getBrowserName() + "_" + capabilities.getBrowserVersion();
		extentTest.assignCategory(device);
		
		extentTest.info("Navigate to url");
	}

	@AfterTest
	public void quitBrowser() {
		driver.quit();
	}

	public void launchUrl() throws IOException {
		driver.get(readConfigureProperties.getConfigurationProperties("baseurl").toString());
	}

}
