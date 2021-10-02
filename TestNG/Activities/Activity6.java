package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Activity6 {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/login-form");
	}

	@Test
	@Parameters({ "username", "password" })
	public void loginform(String username, String password) {
		// Find username and pasword fields
		WebElement usernameField = driver.findElement(By.id("username"));
		WebElement passwordField = driver.findElement(By.id("password"));

		// enter values
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);

		// click on login
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		// assert message
		String loginMsg = driver.findElement(By.id("action-confirmation")).getText();
		Assert.assertEquals(loginMsg, "Welcome Back, admin");
	}

	@AfterClass
	public void afterClass() {
		// closing browser
		driver.close();
	}

}
