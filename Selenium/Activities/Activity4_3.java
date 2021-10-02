package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Webdrvier instance
		WebDriver driver = new FirefoxDriver();

		// Opening browser
		driver.get("https://www.training-support.net/selenium/target-practice");

		// Get the title of page
		String title = driver.getTitle();
		System.out.println("Title of the page is: " + title);

		// third header on the page and get the value
		String thirdHead = driver.findElement(By.xpath("//h3[@id='third-header']")).getText();
		System.out.println("Text value of Header 3 is: " + thirdHead);

		// fifth header and its 'color' css property
		String cssPropH5 = driver.findElement(By.xpath("//h5[@class='ui green header']")).getCssValue("color");
		System.out.println("Colour CSS vlaue of Header 5 is: " + cssPropH5);

		// get attribute of violet button
		String violetButtonAtt = driver.findElement(By.xpath("//button[@class='ui violet button']"))
				.getAttribute("class");
		System.out.println("Class attribute value of Violet button is: " + violetButtonAtt);

		// grey button using absolute xpath
		String greyButtonTxt = driver
				.findElement(By.xpath("html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[3]/button[2]")).getText();
		System.out.println("Grey Button text value is: " + greyButtonTxt);

		// closing the browser
		driver.close();

	}

}
