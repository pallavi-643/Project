package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	private WebDriver driver;
	
	By signInLink  =  By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickOnSignInLink() {
	
		driver.findElement(signInLink).click();
		
			
	}
	
}
