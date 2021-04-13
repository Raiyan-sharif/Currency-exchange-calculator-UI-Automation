import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.DecimalFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class BasicTestCases {
	static String paySeraLink = "https://www.paysera.ee/v2/en-EE/fees/currency-conversion-calculator#/";
	static String googlePage = "https:www.google.com";
	private static DecimalFormat df = new DecimalFormat("0.00");
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

		
		driver.findElement(By.xpath("//input[@data-ng-model='currencyExchangeVM.filter.to_amount']")).sendKeys("200");
		driver.findElement(By.xpath("//div[@class='rate-table-filter']/form/div[1]/div")).click();
		driver.findElement(By.xpath("//div[@class='rate-table-filter']/form/div[1]/div[1]/ul/li/div[4]")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//input[@data-ng-model='currencyExchangeVM.filter.from_amount']")).getText(), "");
		List<WebElement> options = driver.findElements(By.xpath("//div[@class='ng-scope']//tbody/tr"));
		for(WebElement option : options) {
//			System.out.println();
			String data = option.getText();
			String listOfData[] = data.split(" ");
			double y = Double.parseDouble(listOfData[5].replaceAll(",", ""));
//			double y = Double.parseDouble(listOfData[4].replaceAll(",", ""));
			
			System.out.println(y);
//			double actual = 
			String d[] = listOfData[6].replaceAll("[,]", "").split("\\(");
			String actual =d[1].replaceAll("\\)", "");
			if(!d[0].replaceAll("\\)", "").contains("-")) {
				double x = Double.parseDouble(d[0].replaceAll("\\)", ""));
				System.out.println(x);
				System.out.println(actual);
				String expected = df.format(x-y);
				
				System.out.println(expected);
				Assert.assertEquals(actual, expected,"Does Not Match");
			}
			
		}
		
		
	}
	
	

}
