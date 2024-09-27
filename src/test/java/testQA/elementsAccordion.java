package testQA;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseQA.baseFile;
import pages.homePage;

public class elementsAccordion extends baseFile {

	public homePage home;

	public elementsAccordion() {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException {
		launchUrl();
		home = new homePage(driver);
	}

	@AfterMethod
	public void end() {
		quitBrowser();
	}

	@Test(priority = 1)
	public void verifyElementAccorionIsOpen() {
		String showOrCollapse = home.navToElements().getElementmentAccordionAttribute();
		System.out.println(showOrCollapse);
		Assert.assertEquals(showOrCollapse, "element-list collapse show");
	}
	@Test (priority = 2)
	public void verifyElementAccordionIsClosed() throws InterruptedException {
		String showOrCollapse = home.navToElements().clickOnElementsAccordion().getElementmentAccordionAttribute();
		System.out.println(showOrCollapse);
		Assert.assertEquals(showOrCollapse, "element-list collapse");
	}
}
