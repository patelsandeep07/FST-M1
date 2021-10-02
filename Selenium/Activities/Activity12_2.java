package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity12_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/nested-iframes");

		// get title
		String title = driver.getTitle();
		System.out.println("Title of the page is: " + title);

		// switch to first iframe in page
		driver.switchTo().frame(0);

		// switch to first frame in that frame
		driver.switchTo().frame(0);

		// Print heading of frame
		String frm1Heading = driver.findElement(By.className("content")).getText();
		System.out.println(frm1Heading);

		// Switch to default page
		driver.switchTo().defaultContent();

		// switch to first iframe in page
		driver.switchTo().frame(0);

		// switch to second frame in that frame
		driver.switchTo().frame(1);

		// Print heading of frame
		String frm2Heading = driver.findElement(By.className("content")).getText();
		System.out.println(frm2Heading);

		// closing driver
		driver.close();

	}

}
