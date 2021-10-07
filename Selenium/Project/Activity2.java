package testngProjectActivity;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity2 {
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		// driver initialization
		driver = new FirefoxDriver();
		// opening url
		driver.get("http://alchemy.hguy.co/orangehrm");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void getUrlOfHeader() {
		WebElement headerImg = driver.findElement(By.xpath("//div[@id='divLogo']/img"));

		// get img src and print it
		String imgSrc = headerImg.getAttribute("src");
		System.out.println(imgSrc);
	}

	@AfterMethod
	public void afterMethod() {
		// closing browser
		driver.close();
	}

}
