package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity7_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Webdrvier instance
		WebDriver driver = new FirefoxDriver();

		// Opening browser
		driver.get("https://www.training-support.net/selenium/dynamic-attributes");

		// Get the title of page
		String title = driver.getTitle();
		System.out.println("Title of the page is: " + title);


	}

}
