package step_defination;

import static org.junit.Assert.assertTrue;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.BankWirePaymentPage;
import pages.HomePage;
import pages.LogIn;
import pages.OrderHistory;
import pages.PaymentPage;
import pages.ShippingPage;


public class First {
	WebDriver driver;
	
	@Before
	public void initBrowser(){
		String basePath = System.getProperty("user.dir");		
		System.setProperty("webdriver.chrome.driver", basePath + "\\src\\test\\java\\webdrivers\\" + "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();	
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
	}
	
	//@After
	public void tearDown(){
		driver.quit();
	} 	
	
	@Given("^User is on Your Logo Website page$")
	public void user_is_on_Your_Logo_Website_page() throws Exception {
		driver.get("http://automationpractice.com/index.php");
	}

	@When("^User click signUp button and enter valid userId and password$")
	public void user_click_signUp_button_and_enter_valid_userId_and_password() throws Exception {
		new HomePage(driver).clickOnSignInLink();
		new LogIn(driver).login();
	}

	@When("^User click on T-shirt button and Add to the cart$")
	public void user_click_on_T_shirt_button_and_Add_to_the_cart() throws Exception {
		driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[3]/a")).click();
		Actions action=new Actions(driver);
	    action.moveToElement(driver.findElement(By.xpath("//*[@id='center_column']/ul/li[1]/div/div[1]/div/a[1]/img"))).build().perform();
		
		driver.findElement(By.xpath("//*[@id='center_column']/ul/li/div/div[2]/div[2]/a[1]/span")).click();
	}

	@When("^click on Proceed for payment$")
	public void click_on_Proceed_for_payment() throws Exception {
		driver.findElement(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span")).click();
		driver.findElement(By.xpath("//*[@id='center_column']/p[2]/a[1]/span")).click();
		driver.findElement(By.xpath("//*[@id='center_column']/form/p/button/span")).click();
		driver.findElement(By.xpath("//*[@id='form']/p/button/span")).click();
	}

	@When("^close the error pop ups and proceed for payment through Bankwire Method$")
	public void close_the_error_pop_ups_and_proceed_for_payment_through_Bankwire_Method() throws Exception {
		ShippingPage ship = new ShippingPage(driver);
        ship.closeErrorMessage();
	    ship.clickTermsCheckbox();
	    ship.proceedToPaymentPage();
	    PaymentPage paymentPage = new PaymentPage(driver);
		paymentPage.choosingBankWirePayment();
		BankWirePaymentPage bankWire = new BankWirePaymentPage(driver);
		bankWire.confirmOrder();
	}

	@Then("^Assert that newly created order is displayed in order history page$")
	public void assert_that_newly_created_order_is_displayed_in_order_history_page() throws Exception {
		BankWirePaymentPage bankWire = new BankWirePaymentPage(driver);
	    bankWire.backToOrders();
		OrderHistory orderHistory = new OrderHistory(driver);
		assertTrue(driver.findElement(orderHistory.orderReference).isDisplayed());
	}
	 
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
