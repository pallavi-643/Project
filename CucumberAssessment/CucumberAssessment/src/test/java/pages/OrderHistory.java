package pages;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class OrderHistory {
	
	private WebDriver driver;

	public By orderHistoryWebElement  =  By.xpath("//*[@id='center_column']/h1");
	public By orderReference          =  By.xpath("//*[@id='order-list']/tbody/tr/td[1]/a");
	public By orderDate               =  By.xpath("//*[@id='order-list']/tbody/tr/td[2]");
	public By totalPrice              =  By.xpath("//*[@id='order-list']/tbody/tr/td[3]/span");	
	
	public OrderHistory(WebDriver driver) {
		this.driver = driver;
	}
	
	public String orderDateVerification() {
		LocalDate localDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		String localDateString = localDate.format(formatter);
		return localDateString;
	} 
	
	public void takeScreenshot() throws IOException {
		TakesScreenshot scrShot = ((TakesScreenshot)driver);
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+"\\src\\test\\java\\screenshots\\testcase02.png"));
		
	}
	
	
}
