package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity12_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new FirefoxDriver();
		Actions act = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);

		driver.get("https://www.training-support.net/selenium/popups");

		// get title
		String title = driver.getTitle();
		System.out.println("Title of the page is: " + title);

		// find sign in button
		WebElement button = driver.findElement(By.xpath("//button[contains(@class,'orange')]"));

		// hoverover button
		act.moveToElement(button).pause(Duration.ofSeconds(1)).build().perform();

		// tooltip attribute
		String tooltipTxt = button.getAttribute("data-tooltip");
		System.out.println("Tooltip Text is: " + tooltipTxt);

		// click on sign in
		button.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInModal")));

		// find username and password and input credential
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("admin");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("password");

		// find login and click on it
		WebElement login = driver.findElement(By.xpath("//button[text()='Log in']"));
		login.click();

		// login confirmation text
		String loginTxt = driver.findElement(By.id("action-confirmation")).getText();
		System.out.println(loginTxt);

		// closing the browser
		driver.close();

	}

}
