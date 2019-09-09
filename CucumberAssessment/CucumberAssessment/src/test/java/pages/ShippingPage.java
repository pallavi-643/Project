package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShippingPage {
	
	private WebDriver driver;
	
	public By shippingWebElement  =  By.xpath("//div[@id='carrier_area']/h1");
	public By proceedToCheckout04 =  By.xpath("//*[@id='form']/p/button/span");
	public By errorMessage        =  By.xpath("//*[@id='order']/div[2]/div/div/div/div/p");
	public By closeErrorMsg       =  By.xpath("//*[@id='order']/div[2]/div/div/a");
	public By termsCheckbox       =  By.id("cgv");

	public ShippingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void closeErrorMessage() {
		driver.findElement(closeErrorMsg).click();
	}
	
	public void clickTermsCheckbox() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(termsCheckbox).click();
	}
	
	public PaymentPage proceedToPaymentPage() throws InterruptedException {
		driver.findElement(proceedToCheckout04).click();
	
		PaymentPage paymentObj = new PaymentPage(driver);
		
		return paymentObj;
	}
	
}
