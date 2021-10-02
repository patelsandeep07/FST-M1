package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Activity2 {

	WebDriver driver;

	@Test
	public void test1() {
		// Get the title of page
		String title = driver.getTitle();
		System.out.println("Title of the page is: " + title);

		// title assertion
		Assert.assertEquals(title, "Target Practice");
	}

	@Test
	public void test2() {
		WebElement blackBtn = driver.findElement(By.xpath("//button[@class,'ui black button']"));

		// assert the text
		Assert.assertEquals(blackBtn.getText(), "White");
	}

	@Test(enabled = false)
	public void test3() {
		System.out.println("Skipped Test method");
	}

	@Test
	public void test4() {
		// this test will be skipped and shown as skipped
		throw new SkipException("Skippng test case");
	}

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/target-practice");
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
