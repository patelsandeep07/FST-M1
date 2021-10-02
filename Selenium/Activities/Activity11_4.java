package selenium;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity11_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		String childwindow;
		Iterator<String> it;
		driver.get("https://www.training-support.net/selenium/tab-opener");

		// get title
		String title = driver.getTitle();
		System.out.println("Title of the page is: " + title);

		// get parent window handle
		String parentWindow = driver.getWindowHandle();
		System.out.println("Parent Windows: " + parentWindow);

		// Find the button to open a new tab and click it.
		WebElement button = driver.findElement(By.id("launcher"));
		button.click();
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));

		// Get the window handles
		Set<String> allWindowHandles = driver.getWindowHandles();
		System.out.println("All windows handle: " + allWindowHandles);

		it = allWindowHandles.iterator();

		while (it.hasNext()) {
			childwindow = it.next();

			if (!parentWindow.equals(childwindow)) {
				driver.switchTo().window(childwindow);
			}
		}

		// print the handle of the current window
		System.out.println("Current Window handle: " + driver.getWindowHandle());

		// wait for page to load
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("content")));

		// Print newtab title
		System.out.println("New tab title is: " + driver.getTitle());

		// get the heading of new page
		String newTabText = driver.findElement(By.className("content")).getText();
		System.out.println("New tab heading is: " + newTabText);

		// open another tab
		driver.findElement(By.id("actionButton")).click();

		// Make sure the new tab's handle is part of the handles set
		allWindowHandles = driver.getWindowHandles();
		System.out.println("All window handles: " + allWindowHandles);

		// Loop through the handles set till we get to the newest handle
		it = allWindowHandles.iterator();

		while (it.hasNext()) {
			childwindow = it.next();

			if (!parentWindow.equals(childwindow)) {
				driver.switchTo().window(childwindow);
			}
		}

		// Print the handle of the current window
		System.out.println("New tab handle: " + driver.getWindowHandle());

		// Wait for the newest tab to load completely
		wait.until(ExpectedConditions.titleIs("Newtab2"));

		// Print New Tab Title
		System.out.println("New Tab Title is: " + driver.getTitle());

		// Get heading on new page
		newTabText = driver.findElement(By.xpath("//div[@class='content']")).getText();
		System.out.println("New tab heading is: " + newTabText);

		// Close the browser
		driver.quit();
	}

}
