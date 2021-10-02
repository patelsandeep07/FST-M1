package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity8_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/tables");

		// find element for rows and columns
		List<WebElement> columns = driver
				.findElements(By.xpath("//table[@class='ui celled striped table']/tbody/tr[1]/td"));
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='ui celled striped table']/tbody/tr"));

		// Print number of columns and rows
		System.out.println("Number of Columns are: " + columns.size());

		System.out.println("Number of Rows are: " + rows.size());

		// print third row of table
		WebElement thirdRow = driver.findElement(By.xpath("//table[@class='ui celled striped table']/tbody/tr[3]"));
		System.out.println("Third rows values are : " + thirdRow.getText());

		// Print cell values of 2nd row, 2nd column
		WebElement secondRowCol = driver
				.findElement(By.xpath("//table[@class='ui celled striped table']/tbody/tr[2]/td[2]"));
		System.out.println("Second row, Second column value is : " + secondRowCol.getText());

		// closing browser
		driver.close();

	}

}
