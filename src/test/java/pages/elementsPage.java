package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class elementsPage{
	
	public WebDriver driver;
	public elementsPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(xpath = "//div[@class ='element-group'][1]/div")
	WebElement elementMenu;
	
	@FindBy(xpath = "//div[text() = 'Elements']")
	WebElement elementAccordion;
	
	@FindBy(xpath = "//span[text() = 'Text Box']")
	WebElement textbox;
	
	public elementsPage clickOnElementsAccordion() throws InterruptedException
	{
		elementAccordion.click();
		Thread.sleep(1000);
		return this;
	}
	public String getElementmentAccordionAttribute()
	{
		String value = elementMenu.getAttribute("class");
		return value;
	}
	
	public void textboxDisplay()
	{
		textbox.isDisplayed();
	}

}
