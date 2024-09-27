package testQA;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseQA.baseFile;
import pages.elementsPage;
import pages.homePage;
import utilities.readConfigureProperties;

public class launch extends baseFile{
	
	homePage cards;
	elementsPage elements;
	public launch()
	{
		super();
	}
	
	@BeforeTest
	public void setup() throws IOException
	{
		launchUrl();
		cards = new homePage(driver);
		elements = new elementsPage(driver);
	}
	
	@Test
	public void verifyTextboxElement() throws IOException, InterruptedException
	{
		cards.elementCardDisplay();
		String actual = driver.getCurrentUrl();
		String expected = readConfigureProperties.getConfigurationProperties("url").toString()+"elements";
		System.out.println(actual);
		System.out.println(expected);
		Assert.assertEquals(actual, expected);
		elements.textboxDisplay();
	}
	
	//@AfterTest
	public void end()
	{
		quitBrowser();
	}
}
