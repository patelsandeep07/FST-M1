package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Webdrvier instance
		WebDriver driver = new FirefoxDriver();

		// Opening browser
		driver.get("https://training-support.net/selenium/dynamic-controls");

		// Get the title of page
		String title = driver.getTitle();
		System.out.println("Title of the page is: " + title);

		// find input textbox
		WebElement textbox = driver.findElement(By.id("dynamicText"));

		// Print checkbox is enabled or not
		System.out.println("Textbox is enabled: " + textbox.isEnabled());

		// find enable input and click on it
		driver.findElement(By.id("toggleInput")).click();

		// Print checkbox is enabled or not
		System.out.println("Textbox is enabled: " + textbox.isEnabled());

		// closing browser
		driver.close();
	}

}
