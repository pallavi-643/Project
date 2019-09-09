package pages;


import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BankWirePaymentPage {
	
	private WebDriver driver;

	By bankWirePaymentText =  By.xpath("//div[@id='center_column']/form/div/h3");
	By confirmTheOrderLink =  By.xpath("//*[@id='cart_navigation']/button/span");
	By backToOrdersLink    =  By.xpath("//*[@id='center_column']/p/a");
	
	public BankWirePaymentPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void confirmOrder() {
		assertTrue(driver.findElement(bankWirePaymentText).isDisplayed());
		driver.findElement(confirmTheOrderLink).click();
	}
	
	public void backToOrders() {
		driver.findElement(backToOrdersLink).click();
		
	} 
	
}
