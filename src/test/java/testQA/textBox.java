package testQA;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseQA.baseFile;
import pages.homePage;
import pages.textBoxPage;
import utilities.readTextboxdata;

public class textBox extends baseFile{
	
	 homePage home;
	 textBoxPage textBox; 
	public textBox()
	{
		super();
	}
	@BeforeMethod
	public void setUp() throws IOException
	{
		launchUrl();
		home  = new homePage(driver);
		textBox = new textBoxPage(driver);
	}
	
	@AfterMethod
	public void end()
	{
		quitBrowser();
	}

	
	@Test(dataProvider = "textBoxData", dataProviderClass=readTextboxdata.class)
	public void validateEmailTextBox(String email) throws IOException
	{
		
		home.navToElements();
		textBox.clickTextbox();
		textBox.enterEmail(email);
		textBox.clickSubmitButton();
	}
}
