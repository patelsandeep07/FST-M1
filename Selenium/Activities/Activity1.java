package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Webdrvier instance
		WebDriver driver = new FirefoxDriver();

		// Opening browser
		driver.get("https://www.training-support.net");

		// Closing browser
		driver.close();
	}

}
