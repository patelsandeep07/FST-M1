package projectActivities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AddGoogleKeepReminder {

	AppiumDriver<MobileElement> driver = null;

	@BeforeClass
	public void setUp() throws MalformedURLException {
		// Set desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "pixelEmulator");
		caps.setCapability("platformName", "Android");
		caps.setCapability("appPackage", "com.google.android.keep");
		caps.setCapability("appActivity", "com.google.android.keep.activities.BrowseActivity");

		try {
			// Instantiate Appium Driver
			driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
			System.out.println("Google Keep is open");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test(dataProvider = "task")
	public void addNote(String task, String description) {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// find element for addNote and click on it
		MobileElement addNote = driver.findElementById("com.google.android.keep:id/new_note_button");
		addNote.click();

		// find task element and add task details
		MobileElement addTask = driver.findElementById("com.google.android.keep:id/editable_title");
		addTask.sendKeys(task);

		// find note element and add note details
		MobileElement addNt = driver.findElement(By.id("com.google.android.keep:id/edit_note_text"));
		addNt.sendKeys(description);

		// find reminder eleement and click on it
		MobileElement remBtn = driver
				.findElementByXPath("//android.widget.TextView[@content-desc=\"Single-column view\"]");
		remBtn.click();

		// add reminder for today
		MobileElement addRem = driver.findElementByXPath(
				"//android.support.v7.widget.RecyclerView[@resource-id='com.google.android.keep:id/bs_list_view']/android.view.ViewGroup[1]");
		addRem.click();

		// find back button and click on it.
		MobileElement backBtn = driver
				.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
		backBtn.click();

		// find title element and store in string
		String titleString = driver.findElementById("com.google.android.keep:id/index_note_title").getText();
		System.out.println(titleString);

		// find description element and store in string
		String desc = driver.findElementById("com.google.android.keep:id/index_note_text_description").getText();
		System.out.println(desc);

		// Reminder
		Boolean remSel = driver.findElementById("com.google.android.keep:id/browse_reminder_chip").isDisplayed();
		System.out.println(remSel);

		// Assertion
		Assert.assertEquals(titleString, task);
		Assert.assertEquals(desc, description);
		Assert.assertTrue(remSel);
	}

	@DataProvider(name = "task")
	public static Object[][] provideTask() {
		return new Object[][] { { "Complete Activity with Google Tasks", "Adding Google Activity" },
				{ "Complete Activity with Google Keep", "Adding Google Keep Note" },
				{ "Complete the second Activity Google Keep", "Adding Google Keep Note2" } };
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
