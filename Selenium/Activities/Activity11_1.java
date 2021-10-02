package selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity11_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/javascript-alerts");

		// get title
		String title = driver.getTitle();
		System.out.println("Title of the page is: " + title);

		// webelement for simple alert and click on it
		WebElement simpleAlert = driver.findElement(By.id("simple"));
		simpleAlert.click();

		Alert simpleAlt = driver.switchTo().alert();
		System.out.println("Simple Alert Text is: " + simpleAlt.getText());

		// closing alert and browser
		simpleAlt.accept();
		driver.close();

	}

}
