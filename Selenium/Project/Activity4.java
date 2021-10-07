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

public class Activity4 {
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

	@Test()
	public void addEmp() {
		// login with given details
		orangeHRMBase.loginIntoSite(driver);

		// find PIM firm header and click on it
		WebElement pimHeader = driver.findElement(By.linkText("PIM"));
		act.moveToElement(pimHeader).pause(Duration.ofSeconds(2)).click().build().perform();

		// click on add button
		// wait.until(ExpectedConditions.elementToBeClickable(By.id("btnAdd")));
		WebElement addbtn = driver.findElement(By.id("btnAdd"));
		addbtn.click();

		// find required field and input value
		WebElement firstName = driver.findElement(By.id("firstName"));
		WebElement lastName = driver.findElement(By.id("lastName"));

		String fName = "Sandeep";
		String lName = "Patel";
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);

		// click on save button
		WebElement saveBtn = driver.findElement(By.id("btnSave"));
		saveBtn.click();

		// click on PIM header
		pimHeader = driver.findElement(By.id("menu_pim_viewPimModule"));
		pimHeader.click();

		// search employee name
		WebElement srchName = driver.findElement(By.id("empsearch_employee_name_empName"));
		srchName.sendKeys(fName + " " + lName);

		WebElement srchBtn = driver.findElement(By.id("searchBtn"));
		srchBtn.click();

		// Verify search result
		String expFName = driver.findElement(By.xpath("//tr[@class='odd']/td[3]/a")).getText();
		String expLName = driver.findElement(By.xpath("//tr[@class='odd']/td[4]/a")).getText();

		Assert.assertEquals(expFName, fName);
		Assert.assertEquals(expLName, lName);
	}

	@AfterMethod
	public void afterMethod() {
		// closing browser
		driver.close();
	}

}
