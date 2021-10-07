package testngProjectActivity;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class OrangeHRMBase {

	public void loginIntoSite(WebDriver driver) {
		// Get the username and password field and input details
		WebElement username = driver.findElement(By.id("txtUsername"));
		WebElement password = driver.findElement(By.id("txtPassword"));

		username.sendKeys("orange");
		password.sendKeys("orangepassword123");

		// find login button and click on it
		WebElement loginbtn = driver.findElement(By.id("btnLogin"));
		loginbtn.click();

	}

	public void calendar(WebDriver driver, String date, String month, String year) {
		WebElement mnth = driver.findElement(By.className("ui-datepicker-month"));
		Select monthSel = new Select(mnth);
		monthSel.selectByVisibleText(month);
		;

		WebElement yrs = driver.findElement(By.className("ui-datepicker-year"));
		Select yrSel = new Select(yrs);
		yrSel.selectByVisibleText(year);

		List<WebElement> dts = driver.findElements(By.className("ui-state-default"));
		for (WebElement dt : dts) {

			String calDate = dt.getText();
			if (calDate.equalsIgnoreCase(date)) {
				dt.click();
			}
		}
	}

}
