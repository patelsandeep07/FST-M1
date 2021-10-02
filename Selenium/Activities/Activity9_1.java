package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity9_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/selects");

		// find webelement dropdown
		WebElement dropdown = driver.findElement(By.xpath("//select[@id='single-select']"));

		Select sel = new Select(dropdown);
		// Select the second option using selectByVisibleText()
		sel.selectByVisibleText("Option 2");

		System.out.println("Selected option is: " + sel.getFirstSelectedOption().getText());

		// Select the third option using selectByIndex()
		sel.selectByIndex(3);
		System.out.println("Selected option is: " + sel.getFirstSelectedOption().getText());

		// Select the fourth option using selectByValue()
		sel.selectByValue("4");
		System.out.println("Selected option is: " + sel.getFirstSelectedOption().getText());

		// get all the options in the dropdown and print them one by one
		List<WebElement> options = sel.getOptions();

		for (WebElement option : options) {
			System.out.println("Available options are: " + option.getText());
		}

		// closing browser
		driver.close();
	}

}
