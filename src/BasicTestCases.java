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
import java.util.ArrayList;
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
			e.printStackTrace();
		}

		
		driver.findElement(By.xpath("//input[@data-ng-model='currencyExchangeVM.filter.to_amount']")).sendKeys("200");
		driver.findElement(By.xpath("//div[@class='rate-table-filter']/form/div[1]/div")).click();
		driver.findElement(By.xpath("//div[@class='rate-table-filter']/form/div[1]/div[1]/ul/li/div[4]")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//input[@data-ng-model='currencyExchangeVM.filter.from_amount']")).getText(), "");
		List<WebElement> options = driver.findElements(By.xpath("//div[@class='ng-scope']//tbody/tr"));
		List<String> xData = new ArrayList<String>();
		List<String> yData = new ArrayList<String>();
		for(WebElement option : options) {
			List<WebElement> listDataX = option.findElements(By.xpath("//td[5]"));
			List<WebElement> listDataY = option.findElements(By.xpath("//td[4]"));
			String dx,dy;
			
			for(WebElement data:listDataX) {
				dx = data.getText();
//				System.out.println("X: "+d.x);
				xData.add(dx);
				
			}
			for(WebElement data:listDataY) {
				dy = data.getText();
//				System.out.println("Y: "+d.y);
				yData.add(dy);
				
			}
			
			
			
		}
		int c=0;
		for(String i:xData) {
			String x,y,r;
			xData.get(c);
			yData.get(c);
			if(!xData.get(c).equals("-") && (!yData.get(c).equals("-"))) {
				String d[] = xData.get(c).replaceAll("[,]", "").split("\\(");
				x = d[0];
				r = d[1].replaceAll("\\)", "");
				y = yData.get(c).replaceAll("[,]", "");
				String expected = df.format(Double.parseDouble(x)-Double.parseDouble(y));
				System.out.println("Actual: "+r);
				System.out.println("Expected: "+expected);
				Assert.assertEquals(r, expected,"Not Matched");
			}
			c++;
		}		
		driver.close();
	}
	


}
