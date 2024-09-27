package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class textBoxPage {
	
	 WebDriver driver;
	
	public textBoxPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[text() = 'Text Box']")
	WebElement textBox;
	
	@FindBy(id = "userEmail")
	WebElement email;
	
	@FindBy(id="submit")
	WebElement submit;
	
	public void clickTextbox()
	{
		textBox.click();
	}
	
	public void enterEmail(String emailID)
	{
		email.sendKeys(emailID);
	}
	public void clickSubmitButton()
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("argumets[0].scrollIntoView(true)", submit);
		submit.click();
	}
	
}
