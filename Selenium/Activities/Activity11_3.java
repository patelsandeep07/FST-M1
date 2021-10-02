package selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity11_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/javascript-alerts");

		// get title
		String title = driver.getTitle();
		System.out.println("Title of the page is: " + title);

		// find element of confirm alert and click on it
		WebElement promptAlert = driver.findElement(By.id("prompt"));
		promptAlert.click();

		// switch to alert
		Alert prompAlrt = driver.switchTo().alert();
		System.out.println("Prompt Alert text is: " + prompAlrt.getText());

		prompAlrt.sendKeys("Yes, you are!");

		// closing alert and browser
		prompAlrt.accept();
		driver.close();
	}

}
