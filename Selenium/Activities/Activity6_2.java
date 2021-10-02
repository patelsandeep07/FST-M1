package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity6_2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// Webdrvier instance
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, 10);

		// Opening browser
		driver.get("https://training-support.net/selenium/ajax");

		// Get the title of page
		String title = driver.getTitle();
		System.out.println("Title of the page is: " + title);

		// Get change content and click
		WebElement changeContent = driver.findElement(By.xpath("//button[@class='ui violet button']"));
		changeContent.click();

		// find element hello
		WebElement ajax = driver.findElement(By.xpath("//div[@id='ajax-content']"));

		// wait for text to load
		wait.until(ExpectedConditions.textToBePresentInElement(ajax, "HELLO!"));

		// getText and print it
		String textHello = ajax.getText();
		System.out.println(textHello);

		// wait for text to load
		wait.until(ExpectedConditions
				.textToBePresentInElement(ajax, "I'm late!"));

		// print "I'm late!"
		String textImLate = ajax.getText();
		System.out.println(textImLate);

		//closing browser
		driver.close();
	}

}
