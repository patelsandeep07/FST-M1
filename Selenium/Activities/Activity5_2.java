package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Webdrvier instance
		WebDriver driver = new FirefoxDriver();

		// Opening browser
		driver.get("https://training-support.net/selenium/dynamic-controls");

		// Get the title of page
		String title = driver.getTitle();
		System.out.println("Title of the page is: " + title);

		// find checkbox
		WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));

		// Print checkbox is selected or not
		System.out.println("Checkbox is selected: " + checkbox.isSelected());

		// Clcik on checkbox
		checkbox.click();

		// Print checkbox is selected or not
		System.out.println("Checkbox is selected: " + checkbox.isSelected());

		// closing browser
		driver.close();
	}

}
