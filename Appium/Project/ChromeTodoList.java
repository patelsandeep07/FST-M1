package projectActivities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ChromeTodoList {
	AppiumDriver<MobileElement> driver = null;

	@BeforeTest
	public void setup() throws MalformedURLException {
		// Set desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "pixelEmulator");
		caps.setCapability("platformName", "Android");
		caps.setCapability("appPackage", "com.android.chrome");
		caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		caps.setCapability("noReset", true);

		// Instantiate Appium Driver
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
	}

	@Test
	public void testSearchAppium() throws InterruptedException {
		String[] actualList = new String[] { "Add tasks to list", "Get number of tasks", "Clear the list" };
		String task1 = actualList[0];
		String task2 = actualList[1];
		String task3 = actualList[2];

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.training-support.net/selenium");

		MobileElement getStarted = driver.findElementByXPath("//android.widget.Button[@text='Get Started!']");
		getStarted.click();

		Thread.sleep(2000);

		// Scroll to to do list
		driver.findElement(
				MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(10)"));

		MobileElement toDoList = driver.findElementByXPath(
				"//android.webkit.WebView/android.view.View[2]/android.view.View[3]/android.view.View[15]/android.view.View");
		toDoList.click();

		Thread.sleep(2000);

		MobileElement task = driver.findElementByXPath("//android.widget.EditText[@resource-id='taskInput']");
		task.sendKeys(task1);
		MobileElement addTask = driver.findElementByXPath("//*[@text='Add Task']");
		addTask.click();
		Thread.sleep(1000);

		task.sendKeys(task2);
		addTask.click();
		Thread.sleep(1000);

		task.sendKeys(task3);
		addTask.click();
		Thread.sleep(1000);

		// list of element for added tasks
		List<MobileElement> taskList = driver
				.findElementsByXPath("//android.view.View[@resource-id='tasksList']/android.view.View");

		System.out.println(taskList.size());

		for (int i = 2; i <= taskList.size(); i++) {
			MobileElement t1 = driver
					.findElementByXPath("//android.view.View[@resource-id='tasksList']/android.view.View[" + i
							+ "]/android.view.View");

			// Validation with actual values provided
			System.out.println("List of the value contains value from provided String : "
					+ Arrays.asList(actualList).contains(t1.getAttribute("text")));

			Thread.sleep(1000);
			t1.click();
		}
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
