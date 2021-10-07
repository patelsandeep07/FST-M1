package testngProjectActivity;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity7 {
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
	public void addQualification() {
		// login with given details
		orangeHRMBase.loginIntoSite(driver);

		// Initialize actions class
		act = new Actions(driver);

		// clcik on my info
		WebElement myInfo = driver.findElement(By.id("menu_pim_viewMyDetails"));
		act.moveToElement(myInfo).pause(Duration.ofSeconds(2)).click().build().perform();

		// click on qualification
		WebElement qualification = driver.findElement(By.linkText("Qualifications"));
		qualification.click();

		// adding workexperience
		WebElement workExp = driver.findElement(By.id("addWorkExperience"));
		workExp.click();

		// adding workexp details
		WebElement employer = driver.findElement(By.id("experience_employer"));
		employer.sendKeys("IBM");
		WebElement jobTitle = driver.findElement(By.id("experience_jobtitle"));
		jobTitle.sendKeys("Test Analyst");
		WebElement fromDate = driver.findElement(By.id("experience_from_date"));
		fromDate.clear();
		fromDate.sendKeys("2021-01-01");
		WebElement toDate = driver.findElement(By.id("experience_to_date"));
		toDate.clear();
		toDate.sendKeys("2021-01-01");

		// saving workexperience details
		driver.findElement(By.id("btnWorkExpSave")).click();

		// get and assert the success msg
		String successMsg = driver.findElement(By.xpath("//div[@class='inner']/div")).getText();
		String[] okMsg = successMsg.split("[\\r\\n]+");
		System.out.println(okMsg[0]);
		Assert.assertEquals(okMsg[0], "Successfully Saved");
	}

	@AfterMethod
	public void afterMethod() {
		// closing browser
		driver.close();
	}
}
