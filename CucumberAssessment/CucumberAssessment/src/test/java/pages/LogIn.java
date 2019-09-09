package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogIn { 
	private WebDriver driver; 
	
	By email          =  By.id("email");
	By password       =  By.id("passwd");
	By loginButton    =  By.xpath("//*[@id='SubmitLogin']/span");

	public LogIn(WebDriver driver) {
		this.driver = driver;
	}  
	
	public void login() {
		
		driver.findElement(email).sendKeys("someone@example.com");
	
		driver.findElement(password).sendKeys("Password123");
		
		driver.findElement(loginButton).click();
	

}
}
