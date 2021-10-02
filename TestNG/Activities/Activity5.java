package suiteExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Activity5 {

	WebDriver driver;

	@Test(groups = { "HeaderTests", "ButtonTests" })
	public void titlePage() {
		String title = driver.getTitle();
		System.out.println(title);
	}

	@Test(dependsOnMethods = { "titlePage" }, groups = { "HeaderTests" })
	public void headerTest1() {
		// header test
		String thirdHeader = driver.findElement(By.id("third-header")).getText();
		Assert.assertEquals(thirdHeader, "Third header");
	}

	@Test(dependsOnMethods = { "titlePage" }, groups = { "HeaderTests" })
	public void headerTest2() {
		// header test
		String fifthHeader = driver.findElement(By.xpath("//div[@class='column']/h5")).getText();
		Assert.assertEquals(fifthHeader, "Fifth header");
	}

	@Test(dependsOnMethods = { "titlePage" }, groups = { "ButtonTests" })
	public void buttonTest1() {
		// button test
		String oliveTxt = driver.findElement(By.xpath("//button[@class='ui olive button']")).getText();
		Assert.assertEquals(oliveTxt, "Olive");
	}

	@Test(dependsOnMethods = { "titlePage" }, groups = { "ButtonTests" })
	public void buttonTest2() {
		// button test
		String brownTxt = driver.findElement(By.xpath("//button[@class='ui brown button']")).getCssValue("color");
		Assert.assertEquals(brownTxt, "rgb(255, 255, 255)");
	}

	@BeforeClass(alwaysRun = true)
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/target-practice");
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		// closing browser
		driver.close();
	}

}
