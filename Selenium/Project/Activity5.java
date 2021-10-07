package testngProjectActivity;

import java.time.Duration;
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

public class Activity5 {
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

	@Test()
	public void editEmp() {
		// login with given details
		orangeHRMBase.loginIntoSite(driver);

		// click on myinfo
		WebElement myInfo = driver.findElement(By.id("menu_pim_viewMyDetails"));
		act.moveToElement(myInfo).pause(Duration.ofSeconds(2)).click().build().perform();

		WebElement editBtn = driver.findElement(By.id("btnSave"));
		editBtn.click();

		// find all element to update
		WebElement firstName = driver.findElement(By.id("personal_txtEmpFirstName"));
		firstName.clear();
		firstName.sendKeys("Jasmeet");
		WebElement lastName = driver.findElement(By.id("personal_txtEmpLastName"));
		lastName.clear();
		lastName.sendKeys("Singh");
		WebElement radioBtnGenderM = driver.findElement(By.id("personal_optGender_1"));
		radioBtnGenderM.click();
		System.out.println(radioBtnGenderM.isSelected());

		WebElement drpDwnNationality = driver.findElement(By.id("personal_cmbNation"));
		// initialize select for nationality
		sel = new Select(drpDwnNationality);
		sel.selectByVisibleText("Indian");

		WebElement dobField = driver.findElement(By.id("personal_DOB"));
		dobField.sendKeys("1990-12-12");

		editBtn = driver.findElement(By.id("btnSave"));
		editBtn.click();
	}

	@AfterMethod
	public void afterMethod() {
		// closing browser
		driver.close();
	}
}
