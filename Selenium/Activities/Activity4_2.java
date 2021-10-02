package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Webdrvier instance
		WebDriver driver = new FirefoxDriver();

		// Opening browser
		driver.get("https://www.training-support.net/selenium/simple-form");

		// Get the title of page
		String title = driver.getTitle();
		System.out.println("Title of the page is: " + title);

		// Find first name and last name and send details
		WebElement firstName = driver.findElement(By.xpath("//input[@id='firstName']"));
		firstName.sendKeys("Sandeep");

		WebElement lastName = driver.findElement(By.xpath("//input[@id='lastName']"));
		lastName.sendKeys("Patel");

		// find element email and contact number and send details
		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
		email.sendKeys("a@b.com");

		WebElement contactNum = driver.findElement(By.xpath("//input[@id='number']"));
		contactNum.sendKeys("1234567890");

		// Submit the form
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		// Switch to alert
		driver.switchTo().alert().accept();

		// closing browser
		driver.close();

	}

}
