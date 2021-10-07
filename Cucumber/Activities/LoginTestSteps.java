package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginTestSteps {

	WebDriver driver;
	WebDriverWait wait;

	@Given("^User is on Login page$")
	public void user_is_on_Login_page() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 10);
		driver.get("https://www.training-support.net/selenium/login-form");
	}

	@When("^User enters username and password$")
	public void user_enters_username_and_password() {
		// Find username, pasword and login fields
		WebElement usernameField = driver.findElement(By.id("username"));
		WebElement passwordField = driver.findElement(By.id("password"));
		WebElement loginbtn = driver.findElement(By.xpath("//button[@type='submit']"));

		// enter values
		usernameField.sendKeys("admin");
		passwordField.sendKeys("password");

		// click on login
		loginbtn.click();
	}

	@When("^User enters \"(.*)\" and \"(.*)\"$")
	public void user_enters_and(String username, String password) throws Throwable {
		// Enter username from Feature file
		driver.findElement(By.id("username")).sendKeys(username);
		// Enter password from Feature file
		driver.findElement(By.id("password")).sendKeys(password);
		// Click Login
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@Then("^Read the page title and confirmation message$")
	public void read_the_page_title_and_confirmation_message() {
		// get page title
		String title = driver.getTitle();
		System.out.println("Title of the page is: " + title);

		// get the login message
		String loginTxt = driver.findElement(By.id("action-confirmation")).getText();
		System.out.println("Login message is: " + loginTxt);
	}

	@Then("^Close the Browser$")
	public void close_the_Browser() {
		// closing browser
		driver.close();
	}

}
