package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity9_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/selects");

		// find webelement dropdown
		WebElement multiSel = driver.findElement(By.xpath("//select[@id='multi-select']"));

		Select sel = new Select(multiSel);

		if (sel.isMultiple()) {
			// Select the 'JavaScript' option by visible text.
			sel.selectByVisibleText("Javascript");

			// Select the 'NodeJS' option by value
			sel.selectByValue("node");

			// Select the 4th, 5th, and the 6th options by index
			for (int i = 4; i <= 6; i++) {
				sel.selectByIndex(i);
			}

			// Deselect the 'NodeJS' option by value attribute
			sel.deselectByValue("node");

			// Deselect the 7th option by index
			sel.deselectByIndex(7);

			// first selected option
			System.out.println("First Selected option is: " + sel.getFirstSelectedOption().getText());

			// Print all selected options one by one and deselect all options
			List<WebElement> options = sel.getAllSelectedOptions();

			for (WebElement option : options) {
				System.out.println("Selected option are: " + option.getText());
			}

			// Deselect all options
			sel.deselectAll();
			// closing browser
			driver.close();
		}

	}

}
