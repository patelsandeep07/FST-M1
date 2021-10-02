package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity10_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new FirefoxDriver();
		Actions act = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);

		driver.get("https://training-support.net/selenium/drag-drop");

		// get title
		String title = driver.getTitle();
		System.out.println("Title of the page is: " + title);

		// find webelement of ball,dropzone1 and dropzone2
		WebElement ball = driver.findElement(By.id("draggable"));
		WebElement dropzone1 = driver.findElement(By.id("droppable"));
		WebElement dropzone2 = driver.findElement(By.id("dropzone2"));

		// drag and drop to dropzone1
		act.dragAndDrop(ball, dropzone1).build().perform();
		wait.until(ExpectedConditions.attributeToBeNotEmpty(dropzone1, "background-color"));
		System.out.println("Dropped in dropzone1");

		// drag and drop to dropzone2
		act.dragAndDrop(dropzone1, dropzone2).build().perform();
		wait.until(ExpectedConditions.attributeToBeNotEmpty(dropzone2, "background-color"));
		System.out.println("Dropped in dropzone2");

		// closing browser
		driver.close();

	}

}
