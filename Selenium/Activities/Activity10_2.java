package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity10_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new FirefoxDriver();
		Actions act = new Actions(driver);
		String pressedKeyTxt;

		driver.get("https://www.training-support.net/selenium/input-events");
		// get title
		String title = driver.getTitle();
		System.out.println("Title of the page is: " + title);

		WebElement pressedKey = driver.findElement(By.id("keyPressed"));

		//Press the key of your first name in caps
		act.sendKeys("S").build().perform();
		pressedKeyTxt = pressedKey.getText();
		System.out.println("Pressed Key is: " + pressedKeyTxt);

		act.keyDown(Keys.CONTROL).sendKeys("a").sendKeys("c").keyUp(Keys.CONTROL).build().perform();
		pressedKeyTxt = pressedKey.getText();
		System.out.println("Pressed Key is: " + pressedKeyTxt);
		// closing browser
		driver.close();
	}

}
