import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class BasicTestCases {
	static String paySeraLink = "https://www.paysera.ee/v2/en-EE/fees/currency-conversion-calculator#/";
	static String googlePage = "https:www.google.com";
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","//Users//raiyansharif//Documents//Automation//chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get(paySeraLink);
	
		driver.findElement(By.cssSelector("[class='js-localization-popover']")).click();
		driver.findElement(By.cssSelector("[id='countries-dropdown']")).click();
		driver.findElement(By.xpath("//*[@aria-labelledby='countries-dropdown']/li[1]")).click();;
		try {
			Thread.sleep(12000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		WebDriverWait wait = new WebDriverWait(driver,20000);
		
//		WebElement staticDropdown = driver.findElement(By.id("//li[@id='ui-select-choices-0']"));
//		Select dropdown = new Select(staticDropdown);
//		dropdown.selectByIndex(3);
		//<input class="form-control ng-pristine ng-valid ng-not-empty ng-touched" type="text" data-ng-model="currencyExchangeVM.filter.from_amount" data-ng-change="currencyExchangeVM.filter.to_amount = null">
		
//		WebDriverWait w = new WebDriverWait(driver,300);
		
		WebElement sizeEle = driver.findElement(By.xpath("//input[@data-ng-model='currencyExchangeVM.filter.from_amount']"));
//		 w.until(ExpectedConditions.textMatches(By.xpath("//input[@data-ng-model='currencyExchangeVM.filter.from_amount']"), Pattern.compile(regex)));
		 driver.findElement(By.xpath("//input[@data-ng-model='currencyExchangeVM.filter.to_amount']")).sendKeys("200");
		driver.findElement(By.xpath("//div[@class='rate-table-filter']/form/div[1]/div")).click();
		driver.findElement(By.xpath("//div[@class='rate-table-filter']/form/div[1]/div[1]/ul/li/div[4]")).click();
//		System.out.println(driver.findElement(By.xpath("//div[@class='rate-table-filter']/form/div[1]/div")).getText());
//		System.out.println(driver.findElement(By.xpath("//div[@class='ng-scope']//tbody/tr[1]/td[2]")).getText());
//		Assert.assertEquals(1, 1);
		List<WebElement> options = driver.findElements(By.xpath("//div[@class='ng-scope']//tbody/tr"));
		for(WebElement option : options) {
			System.out.println(option.getText());
			
		}
		
		
	}
	
	

}
