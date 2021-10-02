package selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity11_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/javascript-alerts");

		// get title
		String title = driver.getTitle();
		System.out.println("Title of the page is: " + title);

		// find element of confirm alert and click on it
		WebElement confirmAlert = driver.findElement(By.id("confirm"));
		confirmAlert.click();

		// switch to alert
		Alert confAlrt = driver.switchTo().alert();
		System.out.println("Confirm Alert text is: " + confAlrt.getText());

		// closing alert and browser
		confAlrt.accept();

		// closing alert using dismiss
		confAlrt.dismiss();
		driver.close();
	}

}
