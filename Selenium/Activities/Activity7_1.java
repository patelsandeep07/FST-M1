package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity7_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Webdrvier instance
		WebDriver driver = new FirefoxDriver();

		// Opening browser
		driver.get("https://www.training-support.net/selenium/dynamic-attributes");

		// Get the title of page
		String title = driver.getTitle();
		System.out.println("Title of the page is: " + title);

		// find useername and password fields
		WebElement username = driver.findElement(By.xpath("//input[@type='text']"));
		WebElement password = driver.findElement(By.xpath("//input[@type='password']"));

		// send details to username and password
		username.sendKeys("admin");
		password.sendKeys("password");

		// find Login button and click
		WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
		login.click();

		// print login message
		String loginText = driver.findElement(By.id("action-confirmation")).getText();
		System.out.println(loginText);

		// closing browser
		driver.close();
	}

}
