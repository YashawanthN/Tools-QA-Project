import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class logIn {
	public static  WebDriver driver;
	
	public  static void main(String[] args) throws InterruptedException {

	WebDriverManager.edgedriver().setup();
	driver  = new EdgeDriver();
	
	driver.get("https://www.saucedemo.com/");
	
	WebElement useName = driver.findElement(By.id("user-name"));
	useName.sendKeys("standard_use");
	
	WebElement password = driver.findElement(By.id("password"));
	password.sendKeys("secret_sauce");
	
	Thread.sleep(3000);
	
	WebElement button = driver.findElement(By.id("login-button"));
	button.click();
}
}