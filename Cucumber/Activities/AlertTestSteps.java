package stepDefinitions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AlertTestSteps {

	WebDriver driver;
	WebDriverWait wait;
	Alert alert;

	@Given("^User is on the page$")
	public void user_is_on_the_page() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 10);

		driver.get("https://www.training-support.net/selenium/javascript-alerts");
	}

	@When("^User clicks the Simple Alert button$")
	public void user_clicks_the_Simple_Alert_button() {
		// find simple alert and click on it
		WebElement simpletAlert = driver.findElement(By.id("simple"));
		simpletAlert.click();
	}

	@Then("^Alert opens$")
	public void alert_opens() {
		alert = driver.switchTo().alert();
	}

	@Then("^Read the text from it and print it$")
	public void read_the_text_from_it_and_print_it() {
		String alertTxt = alert.getText();
		System.out.println("Alert Text: " + alertTxt);
	}

	@Then("^Close the alert$")
	public void close_the_alert() {
		// closing the alert
		alert.accept();
	}

	@Then("^Close Browser$")
	public void close_Browser() {
		driver.close();
	}

	@When("^User clicks the Confirm Alert button$")
	public void user_clicks_the_Confirm_Alert_button() {
		// find confirm button and click
		WebElement confirm = driver.findElement(By.id("confirm"));
		confirm.click();
	}

	@Then("^Close the alert with Cancel$")
	public void close_the_alert_with_Cancel() {
		// closing the alert with cancel
		alert.dismiss();

	}

	@When("^User clicks the Prompt Alert button$")
	public void user_clicks_the_Prompt_Alert_button() {
		// find prompt and click
		WebElement prompt = driver.findElement(By.id("prompt"));
		prompt.click();
	}

	@Then("^Write a custom message in it$")
	public void write_a_custom_message_in_it() {
		alert.sendKeys("Alert Message");
	}

}
