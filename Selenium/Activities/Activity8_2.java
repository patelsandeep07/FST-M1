package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity8_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/tables");

		// find element for rows and columns
		List<WebElement> columns = driver
				.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr[1]/td"));
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr"));

		// Print number of columns and rows
		System.out.println("Number of Columns are: " + columns.size());

		System.out.println("Number of Rows are: " + rows.size());

		// Print cell values of 2nd row, 2nd column
		WebElement secondRowCol1 = driver
				.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
		System.out.println("Second row, Second column value before sorting is : " + secondRowCol1.getText());

		// click on header name
		WebElement headerName = driver.findElement(By.xpath("//table[@id='sortableTable']/thead/tr/th[1]"));
		headerName.click();

		// Print cell values of 2nd row, 2nd column after sorting
		WebElement secondRowCol2 = driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
		System.out.println("Second row, Second column value before sorting is : " + secondRowCol2.getText());

		driver.close();

	}

}
