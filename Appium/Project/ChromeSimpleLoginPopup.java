package projectActivities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ChromeSimpleLoginPopup {

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

	@Test(dataProvider = "userDetails")
	public void popUpLogin(String user, String pass) throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.training-support.net/selenium");

		// Click on get started
		MobileElement getStarted = driver.findElementByXPath("//android.widget.Button[@text='Get Started!']");
		getStarted.click();

		Thread.sleep(1000);

		// Scroll to end find pop up and click on it
		driver.findElement(
				MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(10)"));

		List<MobileElement> avlOptions = driver.findElementsByXPath(
				"//android.widget.FrameLayout[@resource-id='com.android.chrome:id/compositor_view_holder']/android.widget.FrameLayout/android.webkit.WebView/android.view.View[2]/android.view.View[3]/android.view.View");
		for (int i = 1; i <= avlOptions.size(); i++) {
			MobileElement opt = driver.findElementByXPath(
					"//android.widget.FrameLayout[@resource-id='com.android.chrome:id/compositor_view_holder']/android.widget.FrameLayout/android.webkit.WebView/android.view.View[2]/android.view.View[3]/android.view.View["
							+ i + "]/android.view.View");
			String optText = opt.getAttribute("text");
			String[] splitString = optText.split(" ");
			if (splitString[0].equalsIgnoreCase("Popups")) {
				opt.click();
				break;
			}
		}
		Thread.sleep(1000);

		// find sign in and click on it
		MobileElement signInBtn = driver.findElementByXPath(
				"//android.widget.FrameLayout[@resource-id='com.android.chrome:id/compositor_view_holder']/android.widget.FrameLayout/android.webkit.WebView/android.view.View/android.view.View[4]/android.widget.Button");
		signInBtn.click();

		// find username and send details
		MobileElement username = driver.findElementByXPath("//android.widget.EditText[@resource-id='username']");
		username.sendKeys(user);

		// find password and send details
		MobileElement password = driver.findElementByXPath("//android.widget.EditText[@resource-id='password']");
		password.sendKeys(pass);

		// find login and click on it
		MobileElement login = driver.findElementByXPath("//android.widget.Button[@text='Log in']");
		login.click();

		// get confirmation message
		MobileElement loginMsg = driver.findElementByXPath("//android.view.View[@resource-id='action-confirmation']");
		String confirmMsg = loginMsg.getAttribute("text");

		if (confirmMsg.equalsIgnoreCase("Welcome Back, admin")) {
			System.out.println("Log in successful");
		} else {
			System.out.println("Log in failed");
		}
	}

	@DataProvider(name = "userDetails")
	public static Object[][] provideTask() {
		return new Object[][] { { "admin", "password" }, { "Admin1", "Password" } };
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
