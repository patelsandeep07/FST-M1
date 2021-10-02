package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity12_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement button;
		String buttonTxt;
		String buttonCol;

		driver.get("https://www.training-support.net/selenium/iframes");

		// get title
		String title = driver.getTitle();
		System.out.println("Title of the page is: " + title);

		// Switch to iframe on the page
		driver.switchTo().frame(0);

		// heading of 1st iframe
		String firstHeading = driver.findElement(By.className("content")).getText();
		System.out.println("Heading of the first fram is: " + firstHeading);

		// get the button
		button = driver.findElement(By.id("actionButton"));
		buttonTxt = button.getText();
		System.out.println("Text of button is: " + buttonTxt);

		// get color of button
		buttonCol = button.getCssValue("color");
		System.out.println("Button Colour is: " + buttonCol);

		// click on button
		button.click();

		// get the button
		button = driver.findElement(By.id("actionButton"));
		buttonTxt = button.getText();
		System.out.println("Text of button after click is: " + buttonTxt);

		// get color of button
		buttonCol = button.getCssValue("color");
		System.out.println("Button Colour after click is: " + buttonCol);

		// Switch to default frame
		driver.switchTo().defaultContent();

		// Switch to frame 2
		driver.switchTo().frame(1);

		// heading of 2nd iframe
		String secondHeading = driver.findElement(By.className("content")).getText();
		System.out.println("Heading of the second frame is: " + secondHeading);

		// get the button
		button = driver.findElement(By.id("actionButton"));
		buttonTxt = button.getText();
		System.out.println("Text of button is: " + buttonTxt);

		// get color of button
		buttonCol = button.getCssValue("color");
		System.out.println("Button Colour is: " + buttonCol);

		// Vertical scroll down by 600 pixels
		js.executeScript("window.scrollBy(0,600)");

		// click on button
		button.click();

		// get the button
		button = driver.findElement(By.id("actionButton"));
		buttonTxt = button.getText();
		System.out.println("Text of button after click is: " + buttonTxt);

		// get color of button
		buttonCol = button.getCssValue("color");
		System.out.println("Button Colour after click is: " + buttonCol);

		// Switch to default frame
		driver.switchTo().defaultContent();

		// closing browser
		driver.close();

	}

}
