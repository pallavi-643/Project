package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PaymentPage {
	
	private WebDriver driver;

	public By pleaseChooseYourPaymentMethod = By.xpath("//div[@id='center_column']/h1");
	By payByBankWireLink   =  By.xpath("//div[@id='HOOK_PAYMENT']/div[1]/div/p/a");
	
	public PaymentPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void choosingBankWirePayment() {
		driver.findElement(payByBankWireLink).click();
		
		
	}
	
}
