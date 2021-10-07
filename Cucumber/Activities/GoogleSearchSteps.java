package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleSearchSteps {
	WebDriver driver;
	WebDriverWait wait;

	@Given("^User is on Google Home Page$")
	public void givenFunctionName() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 10);
		driver.get("https://www.google.com/");
	}

	@When("^User types in Cheese and hits ENTER$")
	public void whenFunctionName() {
		// find search bar
		WebElement searchbar = driver.findElement(By.xpath("//input[@title='Search']"));

		// input cheese
		searchbar.sendKeys("Cheese", Keys.ENTER);
	}

	@Then("^Show how many search results were shown")
	public void thenFunctionName() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("result-stats")));
		String resultStats = driver.findElement(By.id("result-stats")).getText();
		System.out.println("Number of results found: " + resultStats);
	}

	@And("^Close the browser")
	public void andFunctionName() {
		driver.close();
	}

}
