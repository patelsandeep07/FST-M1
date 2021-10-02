package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Webdrvier instance
		WebDriver driver = new FirefoxDriver();

		// Opening browser
		driver.get("https://training-support.net/selenium/simple-form");

		// Get Title
		String title = driver.getTitle();
		System.out.println(title);

		// Find first name and last name and send details
		WebElement firstName = driver.findElement(By.id("firstName"));
		firstName.sendKeys("Sandeep");

		WebElement lastName = driver.findElement(By.id("lastName"));
		lastName.sendKeys("Patel");

		// find element email and contact number and send details
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("a@b.com");

		WebElement contactNum = driver.findElement(By.id("number"));
		contactNum.sendKeys("1234567890");

		// Submit the form
		driver.findElement(By.cssSelector(".ui.green.button")).click();

		// close the browser
		driver.close();

	}

}
