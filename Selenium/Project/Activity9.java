package testngProjectActivity;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity9 {

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
	public void emergencyCont() {
		orangeHRMBase.loginIntoSite(driver);

		// click on apply leave
		WebElement myInfo = driver.findElement(By.id("menu_pim_viewMyDetails"));

		act.moveToElement(myInfo).pause(Duration.ofSeconds(1)).click().build().perform();

		// click on emergency contact
		WebElement emergencyCont = driver.findElement(By.linkText("Emergency Contacts"));
		emergencyCont.click();

		// retrive all contact details
		List<WebElement> contacts = driver.findElements(By.xpath("//table[@id='emgcontact_list']/tbody/tr"));

		System.out.println("Emergency Contact Details are: ");

		Iterator<WebElement> it = contacts.iterator();
		while (it.hasNext()) {
			WebElement cont = it.next();

			System.out.println(cont.getText());
		}
	}

	@AfterMethod
	public void afterMethod() {
		// closing browser
		driver.close();
	}

}
