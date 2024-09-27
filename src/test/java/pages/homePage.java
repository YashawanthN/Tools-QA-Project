package pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class homePage {
	
	public WebDriver driver;
	
	public homePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(xpath = "//div [@class = 'card-body']/h5[text()='Elements']")
	WebElement elementCard;
	public void scrollToCards()
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true)", elementCard);
	}
	
	public String getUrl()
	{
		return driver.getCurrentUrl();
	}
	public boolean elementCardDisplay() 
	{
		scrollToCards();
		return elementCard.isDisplayed();	
	}
	public boolean elementCardEnable()
	{
		scrollToCards();
		return elementCard.isEnabled();
	}
	public String getTextOfElementCard()
	{
		scrollToCards();
		return elementCard.getText();
	}
	public elementsPage navToElements()
	{
		scrollToCards();
		elementCard.click();
		elementsPage elementAccordion = new elementsPage(driver);
		return elementAccordion;
	}
}
