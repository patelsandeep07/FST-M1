package testngProjectActivity;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity3 {
	WebDriver driver;
	OrangeHRMBase orangeHRMBase;


	@BeforeMethod
	public void beforeMethod() {
		// driver initialization
		driver = new FirefoxDriver();
		// initialize class object
		orangeHRMBase = new OrangeHRMBase();
		// opening url
		driver.get("http://alchemy.hguy.co/orangehrm");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void loginAndVerfiyHomePage() {
		// login with given details
		orangeHRMBase.loginIntoSite(driver);
		// verify homepage is open
		WebElement home = driver.findElement(By.id("welcome"));
		String[] welMsg = home.getText().split(" ");

		assertEquals(welMsg[0], "Welcome");
	}

	@AfterMethod
	public void afterMethod() {
		// closing browser
		driver.close();
	}
}
