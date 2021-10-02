package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity10_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		Actions act = new Actions(driver);
		driver.get("https://www.training-support.net/selenium/input-events");

		// get title
		String title = driver.getTitle();
		System.out.println("Title of the page is: " + title);

		// find element for dice
		WebElement dice = driver.findElement(By.id("D3Cube"));

		// 1 click
		act.click(dice);

		// get the value of side
		WebElement sideValue = driver.findElement(By.xpath("//div[@class='active']"));
		System.out.println("Side value after 1 click is: " + sideValue.getText());

		// double click
		act.doubleClick(dice);

		// get the value of side after double click
		sideValue = driver.findElement(By.xpath("//div[@class='active']"));
		System.out.println("Side value after double click is: " + sideValue.getText());

		// right click
		act.contextClick(dice).perform();
		// get the value of side after context click
		sideValue = driver.findElement(By.xpath("//div[@class='active']"));
		System.out.println("Side value after context click is: " + sideValue.getText());

		// closing browser
		driver.close();

	}

}
