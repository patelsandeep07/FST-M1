package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Activity3 {

	WebDriver driver;

	@Test
	public void loginForm() {
		// enter username and password details and click on login
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		// confirmation message
		String confMsg = driver.findElement(By.id("action-confirmation")).getText();
		Assert.assertEquals(confMsg, "Welcome Back, admin");
	}
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/login-form");
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
