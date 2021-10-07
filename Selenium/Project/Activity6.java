package testngProjectActivity;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Activity6 {

	WebDriver driver;
	OrangeHRMBase orangeHRMBase;
	Actions act;

	@BeforeMethod
	public void beforeMethod() {
		// driver initialization
		driver = new FirefoxDriver();
		// initialize class object
		orangeHRMBase = new OrangeHRMBase();
		// Initialize actions class
		act = new Actions(driver);
		// opening url
		driver.get("http://alchemy.hguy.co/orangehrm");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void directoryItem() {
		// login with given details
		orangeHRMBase.loginIntoSite(driver);

		WebElement directoryItm = driver.findElement(By.id("menu_directory_viewDirectory"));
		System.out.println("Directory item available on page: " + directoryItm.isDisplayed());

		act.moveToElement(directoryItm).pause(Duration.ofSeconds(2)).click().build().perform();

		WebElement srchHeader = driver.findElement(By.xpath("//div[contains(@class,'searchForm')]/div/h1"));
		String expHeader = srchHeader.getText();

		Assert.assertEquals(expHeader, "Search Directory");
	}

	@AfterMethod
	public void afterMethod() {
		// closing browser
		driver.close();
	}

}
