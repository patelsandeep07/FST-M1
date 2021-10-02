package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity6_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Webdrvier instance
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, 10);

		// Opening browser
		driver.get("https://training-support.net/selenium/dynamic-controls");

		// Get the title of page
		String title = driver.getTitle();
		System.out.println("Title of the page is: " + title);

		// find checkbox and toogle checkbox
		WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
		WebElement toggleCheckbox = driver.findElement(By.id("toggleCheckbox"));

		// click on toggle checkbox
		toggleCheckbox.click();

		// wait for checkbox to disappear
		wait.until(ExpectedConditions.invisibilityOf(checkbox));

		// click on toggle checkbox again
		toggleCheckbox.click();

		// wait for checkbox to reappear
		wait.until(ExpectedConditions.visibilityOf(checkbox));
		checkbox.click();

		// close browser
		driver.close();
	}

}
