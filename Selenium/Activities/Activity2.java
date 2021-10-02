package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Webdrvier instance
		WebDriver driver = new FirefoxDriver();

		// Opening browser
		driver.get("https://www.training-support.net");

		// Get the title of page
		String title = driver.getTitle();
		System.out.println("Title of the page is: " + title);

		// Find element by id
		WebElement idLocator = driver.findElement(By.id("about-link"));
		System.out.println("Text in Element: " + idLocator.getText());

		// Find Element by classname
		WebElement classLocator = driver.findElement(By.className("green"));
		System.out.println("Text in Element: " + classLocator.getText());

		// Find element by linktext
		WebElement linkTextLoc = driver.findElement(By.linkText("About Us"));
		System.out.println("Text in Element: " + linkTextLoc.getText());

		// find element by cssselector
		WebElement cssLocator = driver.findElement(By.cssSelector("a#about-link"));
		System.out.println("Text in Element: " + cssLocator.getText());

		// Closing browser
		driver.close();

	}

}
