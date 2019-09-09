package step_defination;


import static org.junit.Assert.assertTrue;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;
import pages.LogIn;


public class Second { 
static WebDriver driver;
	
	@Before
	public void initBrowser(){
		String basePath = System.getProperty("user.dir");		
		System.setProperty("webdriver.chrome.driver", basePath + "\\src\\test\\java\\webdrivers\\" + "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();	
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
	}
	
	@After
	public void tearDown(){
		driver.close();
	} 
	
	@Given("^User is on welcome page$")
	public void open_the_required_URL() throws Exception {
		driver.get("http://automationpractice.com/index.php");
	  
	} 
	
	@When("^User click signUp and enter valid userId and password$")
	public void user_clicks_on_Sign_in_button() {
		new HomePage(driver).clickOnSignInLink();
		 new LogIn(driver).login();
	} 
	 
	

	@When("^User Click on My Personal Information$")
	public void clickOnPersonalInfo() { 
		driver.findElement(By.xpath("//*[@id='center_column']/div/div[1]/ul/li[4]/a/span")).click();
	    
	}   
	
	@When("^User Edit the first name and give new password$")
	public void editTheFirstName() { 
		driver.findElement(By.id("firstname")).sendKeys("Abcd");
		driver.findElement(By.id("old_passwd")).sendKeys("Pall123");
		driver.findElement(By.id("passwd")).sendKeys("Pallavi");
		driver.findElement(By.id("confirmation")).sendKeys("Pallavi"); 
		driver.findElement(By.xpath("//*[@id='center_column']/div/form/fieldset/div[11]/button/span")).click();
	    
	}  
	
	@Then("^Assert that First Name is Updated$")
	public void update_Personal_Information() throws Exception {
		assertTrue(driver.findElement(By.xpath("//*[@id='center_column']/div/p")).isDisplayed());
	}
	 
	
	 
	
	

}
