import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicTestCases {
	static String paySeraLink = "https://www.paysera.ee/v2/en-EE/fees/currency-conversion-calculator#/";
	static String googlePage = "https:www.google.com";
	public static void main(String[] args) {
		//webdriver.chrome.driver
		///Users/raiyansharif/Documents/Automation/chromedriver
		System.setProperty("webdriver.chrome.driver","//Users//raiyansharif//Documents//Automation//chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get(paySeraLink);
		String title = driver.getTitle();
		System.out.println(title);
		
		
		//For Security Perpose
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		if(paySeraLink.equals(currentUrl)) {
			System.out.println("Correct URL Hit");
		}
		//<input class="form-control ng-pristine ng-valid ng-not-empty ng-touched" type="text" data-ng-model="currencyExchangeVM.filter.from_amount" data-ng-change="currencyExchangeVM.filter.to_amount = null">
		 driver.findElement(By.xpath("//input[@data-ng-model='currencyExchangeVM.filter.from_amount']")).sendKeys("200");
//		driver.findElement(By.xpath("//*[@id='currency-exchange-app']/div/div/div[2]/div[1]/form/div[1]/input")).sendKeys("200");
//		driver.findElement(By.cssSelector("input.form-control.ng-pristine.ng-valid.ng-not-empty.ng-touched")).sendKeys("200");
//		driver.navigate().to(googlePage);
		//
//		driver.navigate().back();
//		System.out.println(driver.getPageSource());
//		driver.close();
		/*
		  Locators : ID, ClassName, Name, LinkText, Xpath, Css, TagName
		 */
		
	}
}
