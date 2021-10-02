package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Webdrvier instance
		WebDriver driver = new FirefoxDriver();

		// Opening browser
		driver.get("https://www.training-support.net");

		// Get the title of page
		String title = driver.getTitle();
		System.out.println("Title of the page is: " + title);

		// find about us using XPATH and Click on it
		driver.findElement(By.xpath("//a[@id='about-link']")).click();

		// get title of next page
		String newTitle = driver.getTitle();
		System.out.println("Title of the next page is: " + newTitle);

		// closing the browser
		driver.close();
	}

}
