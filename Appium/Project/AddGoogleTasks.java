package projectActivities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AddGoogleTasks {
	AppiumDriver<MobileElement> driver = null;

	@BeforeClass
	public void setUp() throws MalformedURLException {
		// Set desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "pixelEmulator");
		caps.setCapability("platformName", "Android");
		caps.setCapability("appPackage", "com.google.android.apps.tasks");
		caps.setCapability("appActivity", "com.google.android.apps.tasks.ui.TaskListsActivity");

		try {
			// Instantiate Appium Driver
			driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
			System.out.println("Google Activity is open");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// find getStarted and click on it
			MobileElement getStarted = driver.findElementById("com.google.android.apps.tasks:id/welcome_get_started");
			getStarted.click();

		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test(dataProvider = "task")
	public void addNewTasks(String task) throws InterruptedException {

		//find addActivity and click on it
		MobileElement addAct = driver
				.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Create new task\"]");
		addAct.click();

		// find new task element and add tasks as text
		MobileElement newTask = driver.findElementById("com.google.android.apps.tasks:id/add_task_title");
		newTask.sendKeys(task);

		// find save btn and click on it
		MobileElement saveBtn = driver.findElementById("com.google.android.apps.tasks:id/add_task_done");
		saveBtn.click();

		// validation
		Thread.sleep(2000);
		String act = driver
				.findElementByXPath(
						"//android.support.v7.widget.RecyclerView[@resource-id='com.google.android.apps.tasks:id/tasks_list']/android.widget.FrameLayout[1]//android.view.ViewGroup/android.widget.TextView")
				.getText();
		System.out.println(act);
		Assert.assertEquals(act, task);
	}

	@DataProvider(name = "task")
	public static Object[][] provideTask() {
		return new Object[][] { { "Complete Activity with Google Tasks" }, { "Complete Activity with Google Keep" },
			{ "Complete the second Activity Google Keep" } };
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
