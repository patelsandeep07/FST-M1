package testngProjectActivity;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Activity8 {

	WebDriver driver;
	OrangeHRMBase orangeHRMBase;
	Actions act;
	Select sel;

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
	public void applyLeave() {
		// login with given details
		orangeHRMBase.loginIntoSite(driver);

		// click on apply leave
		WebElement applyLeave = driver
				.findElement(By.xpath("//table[@class='quickLaungeContainer']/tbody/tr[1]/td[4]"));

		act.moveToElement(applyLeave).pause(Duration.ofSeconds(2)).click().build().perform();

		WebElement leaveType = driver.findElement(By.id("applyleave_txtLeaveType"));
		// initialize sel
		sel = new Select(leaveType);
		sel.selectByVisibleText("privilege leaves");

		// click on from date and select date

		WebElement fromDate = driver.findElement(By.id("applyleave_txtFromDate"));
		fromDate.click();
		orangeHRMBase.calendar(driver, "20", "Oct", "2021");

		// click on apply
		driver.findElement(By.id("applyBtn")).click();

		// Get the success/failure message
		String getMsg = driver.findElement(By.xpath("//div[@class='inner']/div")).getText();
		String[] okMsg = getMsg.split("[\\r\\n]+");
		System.out.println(okMsg[0]);

		// go to leave menu
		WebElement leaveMenu = driver.findElement(By.id("menu_leave_viewLeaveModule"));
		WebElement myLeave = driver.findElement(By.id("menu_leave_viewMyLeaveList"));

		act.moveToElement(leaveMenu).pause(Duration.ofSeconds(1)).moveToElement(myLeave).pause(Duration.ofSeconds(1))
		.click().build().perform();

		// select only pending approval and search
		driver.findElement(By.id("leaveList_chkSearchFilter_checkboxgroup_allcheck")).click();
		driver.findElement(By.id("leaveList_chkSearchFilter_1")).click();
		driver.findElement(By.id("btnSearch")).click();


		// get the leave apply details
		List<WebElement> dts = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr/td[1]"));
		int count = dts.size();
		for (int i = 1; i <= count; i++) {
			String date = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[" + i + "]/td[1]"))
					.getText();

			if (date.matches("2021-10-20")) {
				String status = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[" + i + "]/td[6]"))
						.getText();
				System.out.println(status);
				// Assertion for pending approval
				Assert.assertEquals(status, "Pending Approval(1.00)");
			}
		}
	}

	@AfterMethod
	public void afterMethod() {
		// closing browser
		driver.close();
	}
}
