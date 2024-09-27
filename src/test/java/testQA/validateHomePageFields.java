package testQA;

import java.io.IOException;
import java.lang.reflect.Method;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import baseQA.baseFile;
import pages.homePage;
import utilities.captureScreenshot;
import utilities.readConfigureProperties;

public class validateHomePageFields extends baseFile {

	public homePage home;

	public validateHomePageFields() {
		super();
	}

	@BeforeMethod
	public void setup(ITestContext context) throws IOException {
		launchUrl();
		home = new homePage(driver);
	}
	
	@AfterMethod
	public void checkStatus(Method m, ITestResult result)
	{
		if (result.getStatus() == ITestResult.FAILURE) {
			String screenshotpath = null;
			screenshotpath = captureScreenshot.getScreenshot(result.getMethod().getMethodName());
			extentTest.addScreenCaptureFromPath(screenshotpath);
			extentTest.fail(result.getThrowable());
		}
		if(result.getStatus() == ITestResult.SUCCESS)
		{
			extentTest.pass(m.getName()+ " is Passed");
		}
		if(result.getStatus() == ITestResult.SKIP)
		{
			extentTest.skip(m.getName()+" is Skipped");
		}

	}
	@Test(priority = 1)
	public void verifyHomePageUrl() throws IOException {
		String actualUrl = home.getUrl();
		String expectedUrl = readConfigureProperties.getConfigurationProperties("baseurl").toString();
		System.out.println(actualUrl);
		System.out.println(expectedUrl);
		Assert.assertEquals(actualUrl, expectedUrl);

	}

	@Test(priority = 2)
	public void verifyElementcardIsDisplayed() throws IOException, InterruptedException {
		boolean isDisplay = home.elementCardDisplay();
		Assert.assertTrue(isDisplay);
	}

	@Test(priority = 3)
	public void verifyElementcardIsEnabled() {
		boolean isEnabled = home.elementCardEnable();
		Assert.assertTrue(isEnabled, "Element Card is available and accessed");
	}

	@Test(priority = 4)
	public void verifyElementCardLabel() {
		String cardLabel = home.getTextOfElementCard();
		System.out.println(cardLabel);
		Assert.assertEquals(cardLabel, "Elements");
		extentTest.info("Test isfailed");
	}
	

}
