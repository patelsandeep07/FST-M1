package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Activity1 {

	WebDriver driver;

	@Test
	public void f() {
		// Get the title of page
		String title = driver.getTitle();
		System.out.println("Title of the page is: " + title);

		// title assertion
		Assert.assertEquals(title, "Training Support");

		// find aboout us and click on it
		driver.findElement(By.id("about-link")).click();

		// New title
		String newTitle = driver.getTitle();
		System.out.println("Title of the new page is: " + newTitle);

	}

	@BeforeMethod
	public void beforeMethod() {
		driver = new FirefoxDriver();
		driver.get("https://www.training-support.net");
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

}
